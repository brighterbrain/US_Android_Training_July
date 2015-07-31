package com.example.shared;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SharedMailActivity extends Activity {
	EditText email,password;
	CheckBox chkRemember;
	Button btnLogin,btnCancel;
	String txtEmail,txtPassword;
	
	Boolean check;
	//step 1 ( app_ref )
	SharedPreferences app_pref;
	SharedPreferences.Editor editor;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //step 1.1
         app_pref=PreferenceManager.getDefaultSharedPreferences(this);
        email=(EditText)findViewById(R.id.editText1);
        password=(EditText)findViewById(R.id.editText2);
        
        btnLogin=(Button)findViewById(R.id.button1);
        btnCancel=(Button)findViewById(R.id.button2);
        
        chkRemember=(CheckBox)findViewById(R.id.checkBox1);
        
        //Step 3 (getstring )
        txtEmail=app_pref.getString("KeyEmail", "");
        txtPassword=app_pref.getString("sharedpaas","");
        check=app_pref.getBoolean("bool", false);
        email.setText(txtEmail);
        password.setText(txtPassword);
        chkRemember.setChecked(check);
      
      
      
         btnCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(chkRemember.isChecked()){
					//Step 2 (editor)
                    email.setError("Empty text");
                    //
				 editor=app_pref.edit();
					editor.putString("KeyEmail", email.getText().toString().trim());
					editor.putString("sharedpaas", password.getText().toString().trim());
					editor.putBoolean("bool", true);
					editor.commit();
					
				}else{
					editor=app_pref.edit();
				//	editor.remove("KeyEmail");
					editor.clear();
					editor.commit();
					
				}
			//	finish();
				
			}
		});
        
        
    }
}