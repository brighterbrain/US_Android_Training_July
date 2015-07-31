package net.za.idig;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScreen extends Activity {

	String bookTitle = null;
	MyDatabaseManager dbManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_screen);

		dbManager = new MyDatabaseManager(this);

		Intent displayScreenIntent = getIntent();
		bookTitle = displayScreenIntent.getStringExtra("title");

		TextView myTextView = (TextView) findViewById(R.id.textView1);
		myTextView.setText(bookTitle);

		Button deleteRecordButton = (Button) findViewById(R.id.button_delete);
		deleteRecordButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				deleteRecord(bookTitle);
			}
		});

		Button updateRecordButton = (Button) findViewById(R.id.button_update);
		updateRecordButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				updateRecord(bookTitle);
			}
		});

	}

	protected void updateRecord(String updateBookTitle) {
		Cursor updateCursor = dbManager.getRecordByTitle(updateBookTitle);
		updateCursor.moveToFirst();
		int idColumnIndex = updateCursor.getColumnIndex(Constants.Col_ID);
		int recordID = updateCursor.getInt(idColumnIndex);
		String newTitle = updateBookTitle
				+ " - ideal for beginners to learn Android";
		long numberRowsUpdated = dbManager.updateRecord(recordID, newTitle);
		Toast.makeText(getBaseContext(),
				"Number records updated: " + numberRowsUpdated,
				Toast.LENGTH_SHORT).show();
		updateCursor.close();
		dbManager.close();
		Intent updateIntent = new Intent(this, MainScreen.class);
		startActivity(updateIntent);
	}

	protected void deleteRecord(String deleteBookTitle) {
		Cursor deleteCursor = dbManager.getRecordByTitle(deleteBookTitle);
		deleteCursor.moveToFirst();
		int idColumnIndex = deleteCursor.getColumnIndex(Constants.Col_ID);
		int recordID = deleteCursor.getInt(idColumnIndex);
		long numberRowsDeleted = dbManager.deleteRecord(recordID);
		Toast.makeText(getBaseContext(),
				"Number records deleted: " + numberRowsDeleted,
				Toast.LENGTH_SHORT).show();
		deleteCursor.close();
		dbManager.close();
		Intent deleteIntent = new Intent(this, MainScreen.class);
		startActivity(deleteIntent);
	}
}
