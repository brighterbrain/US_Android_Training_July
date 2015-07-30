package com.javajuggler.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleButtonExampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void myClickHandler(View handler)
    {
    ToggleButton tb=(ToggleButton)findViewById(R.id.cctglBtn);
    if(tb.isChecked())
    {
    	Toast.makeText(getApplicationContext(), "Status is On", Toast.LENGTH_LONG).show();
    }
    else
    {
    	Toast.makeText(getApplicationContext(), "Status is Off", Toast.LENGTH_LONG).show();
    }
    }
    
}