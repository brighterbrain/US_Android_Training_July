package com.ui.yogeshblogspot;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckBoxExampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void techSelection(View v)
    {
    	String ch="You Choose - ";
    	CheckBox android=(CheckBox)findViewById(R.id.android);
    	CheckBox blackberry=(CheckBox)findViewById(R.id.blackberry);
    	CheckBox iphone=(CheckBox)findViewById(R.id.iphone);
    	CheckBox windows=(CheckBox)findViewById(R.id.windows);
    	TextView res=(TextView)findViewById(R.id.result);
    	if(android.isChecked())
    	{
    	ch=ch+" Android";	
    	}
    	if(blackberry.isChecked())
    	{
    	ch=ch+" Blackberry";	
    	}
    	if(iphone.isChecked())
    	{
    	ch=ch+" IPhone";	
    	}
    	if(windows.isChecked())
    	{
    	ch=ch+" Windows Mobile";	
    	}
    	res.setText(ch);
    }
    public void webTechSelection(View v)
    {
    String ch="You Chooose - ";
    	CheckBox micro=(CheckBox)findViewById(R.id.micro);
    	CheckBox j2ee=(CheckBox)findViewById(R.id.j2ee);
    	CheckBox php=(CheckBox)findViewById(R.id.php);
    	TextView tv=(TextView)findViewById(R.id.webresult);
    	if(micro.isChecked())
    	{
    	ch=ch+" Microsoft.NET";	
    	}
    	if(j2ee.isChecked())
    	{
    		ch=ch+" J2EE";
    	}
    	if(php.isChecked())
    	{
    	ch=ch+" PHP";	
    	}
    	tv.setText(ch);
    	
    }
}