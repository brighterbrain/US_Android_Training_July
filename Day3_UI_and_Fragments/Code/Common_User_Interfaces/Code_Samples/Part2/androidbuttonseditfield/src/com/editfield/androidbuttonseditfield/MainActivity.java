package com.editfield.androidbuttonseditfield;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

	Button sendBtn;
	EditText edText1;
	EditText edText2;
	EditText edText3;

	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edText1 = (EditText) findViewById(R.id.editText1);
		edText2 = (EditText) findViewById(R.id.editText2);
		edText3 = (EditText) findViewById(R.id.editText3);
		textView = (TextView) findViewById(R.id.textView1);

		sendBtn = (Button) findViewById(R.id.button1);
		sendBtn.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void sum(View v) {
		// Implement sum
	}

	private void calculate() {

		String t1 = edText1.getText().toString();
		String t2 = edText2.getText().toString();

		int sum = Integer.parseInt(t1) + Integer.parseInt(t2);
		edText3.setText(Integer.toString(sum));

		Toast.makeText(MainActivity.this, Integer.toString(sum),
				Toast.LENGTH_LONG).show();

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.button1:
			calculate();
			break;

		default:
			break;
		}

	}
}
