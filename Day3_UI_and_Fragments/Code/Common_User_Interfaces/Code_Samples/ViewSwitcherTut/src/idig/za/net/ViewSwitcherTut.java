package idig.za.net;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;

public class ViewSwitcherTut extends Activity implements OnClickListener {

	private ViewSwitcher myViewSwitcher;
	ViewFactory myViewFactory;
	private Button nextButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		myViewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher01);

		Button nextButton = (Button) findViewById(R.id.button1);
		nextButton.setOnClickListener(this);

		Button previousButton = (Button) findViewById(R.id.button2);
		previousButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == nextButton) {
			myViewSwitcher.showNext();
		} else {
			myViewSwitcher.showPrevious();
		}
	}
}