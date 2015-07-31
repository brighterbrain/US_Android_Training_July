package com.shared.ok;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class Second extends Activity {
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		textView = (TextView) findViewById(R.id.textView1);   
		SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);      
		String text = app_preferences.getString("myValue", "null");      
		textView.setText(text);
		
	}

}
