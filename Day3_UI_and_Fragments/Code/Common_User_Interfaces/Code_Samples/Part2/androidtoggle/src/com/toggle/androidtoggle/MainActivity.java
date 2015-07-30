package com.toggle.androidtoggle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	private ToggleButton toggleButton1, toggleButton2,toggleButton3;
	private Button btnDisplay;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();

	}

	public void addListenerOnButton() {

		toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
		toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
		btnDisplay = (Button) findViewById(R.id.btnDisplay);
		
		toggleButton3 =  (ToggleButton) findViewById(R.id.toggle);
		
		btnDisplay.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				StringBuffer result = new StringBuffer();
				result.append("ToggleButton1 : ").append(toggleButton1.getText());
				result.append("\nToggleButton2 : ").append(toggleButton2.getText());
				result.append("\nToggleButton3 : ").append(toggleButton3.isChecked());
				
				Toast.makeText(MainActivity.this, result.toString(),Toast.LENGTH_LONG).show();
			}

		});

	}
}