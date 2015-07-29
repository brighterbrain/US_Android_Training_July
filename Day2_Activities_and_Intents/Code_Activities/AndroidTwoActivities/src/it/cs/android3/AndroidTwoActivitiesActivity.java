package it.cs.android3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AndroidTwoActivitiesActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	Button button;
	EditText username;
	EditText password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button=(Button)findViewById(R.id.button1);
        username=(EditText)findViewById(R.id.editText1);
        password=(EditText)findViewById(R.id.editText2);
        button.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		if (arg0==button) {
			//if (username.getText().toString().equals("marco") &&
			//	password.getText().toString().equals("sicurezza")) {
				
				Intent intent=new Intent(this,SecondActivity.class);
				intent.putExtra("username",username.getText().toString());
				startActivity(intent);
			//}
		}
		
	}
}