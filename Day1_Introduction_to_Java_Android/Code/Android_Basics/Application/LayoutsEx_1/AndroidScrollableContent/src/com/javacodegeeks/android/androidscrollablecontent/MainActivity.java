package com.javacodegeeks.android.androidscrollablecontent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrollable_contents);

		ScrollView scrollable_contents = (ScrollView) findViewById(R.id.scrollableContents);
		getLayoutInflater().inflate(R.layout.contents, scrollable_contents);

	}

}
