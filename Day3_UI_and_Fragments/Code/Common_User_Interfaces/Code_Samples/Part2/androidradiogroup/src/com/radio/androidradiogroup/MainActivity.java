package com.radio.androidradiogroup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private RadioGroup radioGroupWebsite;
	private RadioButton radioBtn1;
	private Button btnWebsiteName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addListenerRadioButton();
	}

	private void addListenerRadioButton() {

		radioGroupWebsite = (RadioGroup) findViewById(R.id.radioGroup1);
		btnWebsiteName = (Button) findViewById(R.id.button1);
		btnWebsiteName.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// get selected radio button from radioGroupWebsite
				int selected = radioGroupWebsite.getCheckedRadioButtonId();
				radioBtn1 = (RadioButton) findViewById(selected);
				Toast.makeText(MainActivity.this, radioBtn1.getText(),
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		/*
		 * Inflate the menu; this adds items to the action bar if it is present
		 */
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}