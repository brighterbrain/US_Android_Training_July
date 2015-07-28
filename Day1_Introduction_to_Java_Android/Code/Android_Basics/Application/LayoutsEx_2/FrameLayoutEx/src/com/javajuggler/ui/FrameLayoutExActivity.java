package com.javajuggler.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class FrameLayoutExActivity extends Activity {
    /** Called when the activity is first created. */
	TextView tv;
	ImageView iv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv=(TextView)findViewById(R.id.txtView);
        iv=(ImageView)findViewById(R.id.imgView);
        tv.setOnClickListener(new OnClickListener() {
        	
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				ImageView iv=(ImageView)findViewById(R.id.imgView);
				iv.setVisibility(View.VISIBLE);
				v.setVisibility(View.GONE);
					
			}
		});
        
        iv.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView tv=(TextView)findViewById(R.id.txtView);
				tv.setVisibility(View.VISIBLE);
				v.setVisibility(View.GONE);
			}
		});
    }
}