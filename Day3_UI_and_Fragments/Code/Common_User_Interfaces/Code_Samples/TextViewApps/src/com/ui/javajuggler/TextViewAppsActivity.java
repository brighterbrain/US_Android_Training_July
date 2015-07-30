package com.ui.javajuggler;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

public class TextViewAppsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView tv=(TextView)findViewById(R.id.txtView);
        Linkify.addLinks(tv, Linkify.EMAIL_ADDRESSES);
        
   
    }
}