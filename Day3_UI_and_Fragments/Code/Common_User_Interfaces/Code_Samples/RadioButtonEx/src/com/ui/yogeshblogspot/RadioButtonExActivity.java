package com.ui.yogeshblogspot;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class RadioButtonExActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void checkSpecialization(View v)
    {
    	RadioButton micro=(RadioButton)findViewById(R.id.micro);
    	RadioButton j2ee=(RadioButton)findViewById(R.id.j2ee);
    	RadioButton php=(RadioButton)findViewById(R.id.php);
    	TextView result=(TextView)findViewById(R.id.result);
    	String s="Your Choice is - ";
    	if(micro.isChecked())
    	{
    	s=s+" Microsoft.NET";
    	}
    	if(j2ee.isChecked())
    	{
    		s=s+" J2EE";
    	}
    	if(php.isChecked())
    	{
    		s=s+" Php";
    	}
    	result.setText(s);
    }
}