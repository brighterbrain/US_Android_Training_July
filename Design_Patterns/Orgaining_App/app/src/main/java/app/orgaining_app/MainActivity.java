package app.orgaining_app;

import android.content.ComponentCallbacks2;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


/**
 * Activity for loading layout resources
 *
 * This activity is used to display different layout resources for user interface design.
 *
 * @author Kalpesh
 * @version 2015.03.06
 * @since 1.0
 */
public class MainActivity extends ActionBarActivity implements ComponentCallbacks2 {
    /**
     * Debug Tag for use logging debug output to LogCat
     */
    private static final String mLogTag = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_main);
            Log.i(mLogTag, "onCreate:" + this);
          this.registerComponentCallbacks(this);
        }
        /**
         * This method simply throws an Exception if the incoming parameter a is not a positive number, just for fun.
         *
         * @param a Whether or not to throw an exception
         * @throws Exception
         */
        catch(Exception e){

        }
    }

    /**
     * Method that creates menu
     *
     * @param a The first integer to add
     * @param b The second integer to add
     * @return The resulting sum of a and b
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onTrimMemory(int level) {
        Log.v("MainActivity Memory", "onTrimMemory() with level=" + level);
        MemoryCache cache= new MemoryCache();
        // Memory we can release here will help overall system performance, and
        // make us a smaller target as the system looks for memory

        if (level >= TRIM_MEMORY_MODERATE) { // 60
            // Nearing middle of list of cached background apps; evict our
            // entire thumbnail cache
            Log.v("MainActivity Memory", "evicting entire thumbnail cache");
            cache.evictAll();
        } else if (level >= TRIM_MEMORY_BACKGROUND) { // 40
            // Entering list of cached background apps; evict oldest half of our
            // thumbnail cache
            Log.v("MainActivity Memory", "evicting oldest half of thumbnail cache");
       //     mCache.trimToSize(mCache.size() / 2);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
