package nd.sevakkalpesh.app.singleton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import nd.sevakkalpesh.app.pattern.Singleton;

/**
 * Created by kalpesh on 03/03/2015.
 */
public class ActivityB extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Show the string value of the singleton
        Toast.makeText(getApplicationContext(), Singleton.getInstance().getString(), Toast.LENGTH_SHORT).show();
    }
}