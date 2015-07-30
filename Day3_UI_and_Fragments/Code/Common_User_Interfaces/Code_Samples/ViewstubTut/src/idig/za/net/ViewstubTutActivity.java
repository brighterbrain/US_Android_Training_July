package idig.za.net;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;

public class ViewstubTutActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button showStubButton = (Button) findViewById(R.id.showStubButton);
		showStubButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				ViewStub stub = (ViewStub) findViewById(R.id.viewStub1);
				stub.inflate();
			}
		});
	}
}