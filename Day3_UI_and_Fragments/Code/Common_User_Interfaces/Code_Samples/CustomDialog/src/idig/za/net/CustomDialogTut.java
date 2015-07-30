package idig.za.net;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomDialogTut extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button customButtonAlert = (Button) findViewById(R.id.customDialogButton);
		Button radioButtonAlert = (Button) findViewById(R.id.radioDialogButton);
		Button listButtonAlert = (Button) findViewById(R.id.listDialogButton);

		customButtonAlert.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showDialog(1, null);
			}
		});

		radioButtonAlert.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showDialog(2, null);
			}
		});

		listButtonAlert.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showDialog(3, null);
			}
		});
	}

	protected Dialog onCreateDialog(int id, Bundle b) {
		Dialog dialog = null;
		switch (id) {
		case 1:
			dialog = new Dialog(CustomDialogTut.this);
			dialog.setContentView(R.layout.custom_dialog);
			dialog.setTitle("Custom Dialog");
			TextView text = (TextView) dialog.findViewById(R.id.text);
			text.setText("Hello, my name is Andy the Android and I'm appearing in a Custom dialog!");
			ImageView image = (ImageView) dialog.findViewById(R.id.image);
			image.setImageResource(R.drawable.android_image);
			break;

		case 2:
			final CharSequence[] items = { "Belgium", "Germany", "Greece" };
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Pick a country");
			builder.setSingleChoiceItems(items, -1,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int item) {
							Toast.makeText(getApplicationContext(),
									items[item], Toast.LENGTH_SHORT).show();
						}
					});
			
			builder.setNegativeButton("Close Dialog", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		           }
		       });
			AlertDialog alert = builder.create();
			alert.show();
			break;

		case 3:
			final CharSequence[] moreItems = { "Pacific", "Indian", "Atlantic" };
			AlertDialog.Builder moreBuilder = new AlertDialog.Builder(this);
			moreBuilder.setTitle("Pick an ocean");
			moreBuilder.setItems(moreItems,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int item) {
							Toast.makeText(getApplicationContext(),
									moreItems[item], Toast.LENGTH_SHORT).show();
						}
					});
			AlertDialog moreAlert = moreBuilder.create();
			moreAlert.show();
			break;
		}
		return dialog;
	}
}