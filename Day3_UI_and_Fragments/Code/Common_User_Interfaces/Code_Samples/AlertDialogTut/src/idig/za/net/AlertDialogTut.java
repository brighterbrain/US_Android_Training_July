package idig.za.net;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogTut extends Activity implements OnClickListener {
	
	//Context context = getBaseContext();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button showDialogButton = (Button) findViewById(R.id.button1);
		showDialogButton.setOnClickListener(this);		
	}
	
	
	
	
	
	
	
	
	
	public void showMyDialog(){
		
		AlertDialog dialog = new AlertDialog.Builder(this).create();

		dialog.setMessage("What would you like to do?");
		dialog.setButton(DialogInterface.BUTTON_POSITIVE,
				"Exit for home", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getBaseContext(), "Go home and sleep!", Toast.LENGTH_LONG).show();
					}
				});

		dialog.setButton(DialogInterface.BUTTON_NEGATIVE,
				"Abort for coffee", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getBaseContext(), "Go drink your cup of Java!", Toast.LENGTH_LONG).show();
					}
				});
		
		dialog.setButton(DialogInterface.BUTTON_NEUTRAL,
				"Continue for tea", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getBaseContext(), "Go drink your cup of Ceylon!", Toast.LENGTH_LONG).show();
					}
				});
		
		dialog.show();
	}

	@Override
	public void onClick(View v) {
		showMyDialog();		
	}
}