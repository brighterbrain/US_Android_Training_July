package com.ex.first;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

public class Second extends Activity{
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.second);
		
	tv=(TextView)findViewById(R.id.textView1);
		
		
		Bundle extras=getIntent().getExtras();
		
		if(extras !=null){
			String value=extras.getString("Name");
			tv.setText("Welcome" + value);
		}
		
		/*Bundle extras = getIntent().getExtras();
		if (extras != null) {
			
		    String value = extras.getString("Name");
		   // t1.setText("Welcome"+ value);
		}
*/	}

	
	
}
