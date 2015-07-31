package nd.sevakkalpesh.app.singleton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import nd.sevakkalpesh.app.pattern.Singleton;


public class ActivityA extends ActionBarActivity implements View.OnClickListener{
Button btnSecondScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSecondScreen=(Button)findViewById(R.id.button1);

        Toast.makeText(getApplicationContext(), Singleton.getInstance().getString(), Toast.LENGTH_LONG).show();



        btnSecondScreen.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    public void onSecondScreen(){
        Singleton.getInstance().setString("Singleton");
        Intent intent = new Intent(getApplicationContext(),ActivityB.class);
        this.startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        //Change the string value and launch intent to ActivityB
         Singleton.getInstance().setString("Singleton");
         Intent intent = new Intent(getApplicationContext(),ActivityB.class);
         this.startActivity(intent);
    }
}
