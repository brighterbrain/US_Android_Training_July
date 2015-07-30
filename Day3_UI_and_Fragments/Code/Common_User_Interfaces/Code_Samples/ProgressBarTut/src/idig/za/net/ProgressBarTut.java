package idig.za.net;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarTut extends Activity {

	private static ProgressBar progress_bar;
	int percent_complete = 0;
	TextView finishedText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		progress_bar = (ProgressBar) findViewById(R.id.progress_bar_view);
		finishedText = (TextView) findViewById(R.id.finishedTextView);

		Button showProgressBarButton = (Button) findViewById(R.id.show_progress_bar);
		showProgressBarButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				progress_bar.setVisibility(View.VISIBLE);
				finishedText.setText(R.string.displayHint);
				doBackgrndStuff();
			}
		});
	}

	private Handler my_handler = new Handler() {
		public void handleMessage(Message msg) {
			progress_bar.setVisibility(View.INVISIBLE);
			displayFinished();
		}
	};

	private void doBackgrndStuff() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				percent_complete = 0;
				my_handler.post(updateBar);

				for (int i = 0; i < 11; i++) {
					doStuff();
					percent_complete = i * 10;
					my_handler.post(updateBar);
				}
				my_handler.sendEmptyMessage(0);
			}
		});
		thread.start();
	}

	public void displayFinished() {
		finishedText.setText("It's all over Bob!");
	}

	public void doStuff() {
		int a = 0;
		for (int i = 0; i < 1000; i++)
			for (int j = 0; j < 1000; j++)
				a = i + j;
	}

	final Runnable updateBar = new Runnable() {
		public void run() {
			progress_bar.setProgress(percent_complete);
		}
	};
}