package it.cs.android3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main_two);
	    Intent intent=getIntent();
	    String s=intent.getStringExtra("username");
	    s="Welcome " +s;
	    TextView text=(TextView)findViewById(R.id.textView3);
	    text.setText(s);
	    // TODO Auto-generated method stub
	}

}
