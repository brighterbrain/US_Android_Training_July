package com.ui.yogeshblogspot;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageViewExActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void imageClicked(View v)
    {
    	ImageView iv=(ImageView)findViewById(R.id.imageView1);
    	iv.setImageResource(R.drawable.html5);
    	Toast.makeText(getApplicationContext(), "Image Clicked", Toast.LENGTH_LONG).show();
    }
}