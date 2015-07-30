package com.imagebutton.androidimagebutton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	ImageButton imageButton;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		addListenerOnButton();
 
	}
 
	public void addListenerOnButton() {
 
		imageButton = (ImageButton) findViewById(R.id.imageButton1);
 
		imageButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
			   Toast.makeText(MainActivity.this,
				"ImageButton is clicked!", Toast.LENGTH_SHORT).show();
 
			}
 
		});
 
	}
 
}