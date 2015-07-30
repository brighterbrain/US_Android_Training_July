package com.ui.yogeshblogspot;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ImageButtonExActivity extends Activity {
    /** Called when the activity is first created. */
	ImageButton img;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        img=(ImageButton)findViewById(R.id.imgButton2);
        img.setImageResource(R.drawable.many);
    }
    public void clickHandler(View v)
    {
    switch(v.getId())
    {
    case R.id.imgButton1:
    	Toast.makeText(getApplicationContext(), "You clicked on Initor", Toast.LENGTH_LONG).show();
    	break;
    case R.id.imgButton2:
    	Toast.makeText(getApplicationContext(), "You clicked on Many Means",Toast.LENGTH_LONG).show();
    	break;
    	
    
    }
    }
}