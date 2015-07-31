package com.shared.ok;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SharedActivity extends Activity {
	EditText etset,etget;
	Button btnset,btnget,btnremove;
	
	SharedPreferences app_pref;
	SharedPreferences.Editor editor;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Step 1 declare
        app_pref=PreferenceManager.getDefaultSharedPreferences(this);
        
        
        
        etset=(EditText)findViewById(R.id.editText1);
        etget=(EditText)findViewById(R.id.editText2);
        
        btnset=(Button)findViewById(R.id.button1);
        btnget=(Button)findViewById(R.id.button2);
       btnremove=(Button)findViewById(R.id.button3);
        btnset.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Step 2 declare
			 editor=app_pref.edit();
			 editor.putString("myValue", etset.getText().toString().trim());
				
				editor.commit();
			//	Intent myIntent = new Intent(SharedActivity.this,Second.class);                
			//	startActivity(myIntent);
				
			}
		});
        
        btnget.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String myPref=app_pref.getString("myValue", "Nullll");
				etget.setText(myPref);
				
				
			}
		});
        
      btnremove.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			editor.remove("myValue");
			editor.commit(); // commit changes
			
		}
	});
        
    }
}