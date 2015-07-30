package idig.za.net;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class ThemeTutActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView myTextView = (TextView)findViewById(R.id.myTextView);
        myTextView.setTextColor(Color.RED);
    }
}