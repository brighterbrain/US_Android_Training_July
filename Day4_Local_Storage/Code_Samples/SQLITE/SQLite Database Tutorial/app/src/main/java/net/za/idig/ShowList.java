package net.za.idig;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowList extends ListActivity {

	String doThis = null;
	String[] bookTitles;
	MyDatabaseManager dbManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		dbManager = new MyDatabaseManager(this);

		Intent showListIntent = getIntent();
		bookTitles = showListIntent.getStringArrayExtra("bookTitles");
		doThis = showListIntent.getStringExtra("doThis");
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				bookTitles));
		ListView lv = getListView();		
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				if (doThis.equals("addRecord")) {
					addRecord(position);
				}

				if (doThis.equals("displayOnly")) {
					Toast.makeText(getBaseContext(),
							"Press Back Button to go back", Toast.LENGTH_SHORT)
							.show();
				}

				if (doThis.equals("search")) {
					String searchTerm = ((TextView) view).getText().toString();
					getRecordByTitle(searchTerm);
				}

				if (doThis.equals("editOrDelete")) {
					String title = ((TextView) view).getText().toString();
					Intent goDisplayScreen = new Intent(ShowList.this,
							DisplayScreen.class);
					goDisplayScreen.putExtra("title", title);
					startActivity(goDisplayScreen);
				}
			}
		});
	}

	private void getRecordByTitle(String searchTerm) {
		Cursor resultCursor = dbManager.getRecordByTitle(searchTerm);
		int numberRecords = resultCursor.getCount();
		if (numberRecords > 0) {
			bookTitles = new String[resultCursor.getCount()];
			if (numberRecords == 1) {
				resultCursor.moveToFirst();
				String title = resultCursor.getString(1);
				bookTitles[0] = title;
			}

			if (numberRecords > 1) {
				int arrayIndex = 0;
				while (resultCursor.moveToNext()) {
					int titleIndex = resultCursor
							.getColumnIndex(Constants.Col_Title);
					String title = resultCursor.getString(titleIndex);
					bookTitles[arrayIndex] = title;
					arrayIndex++;
				}
			}

			resultCursor.close();
			dbManager.close();
			Intent searchIntent = new Intent(this, MainScreen.class);
			searchIntent.putExtra("displayText", "Record/s found");
			searchIntent.putExtra("showResults", true);
			searchIntent.putExtra("bookTitles", bookTitles);
			startActivity(searchIntent);
		} else {
			resultCursor.close();
			dbManager.close();
			Intent searchIntent = new Intent(this, MainScreen.class);
			searchIntent.putExtra("displayText", "no records found");
			searchIntent.putExtra("showResults", false);
			startActivity(searchIntent);
		}
	}

	protected void addRecord(int position) {
		String bookTitle = bookTitles[position];
		String bookAuthor = "Clive Sargeant";

		long rowId = dbManager.addBookToDB(bookAuthor, bookTitle);
		if (rowId == -1) {
			goBackMainScreen("There was a problem adding the record");
		} else {
			goBackMainScreen("The record has been added");
		}
	}

	private void goBackMainScreen(String displayText) {
		Intent goMainScreenIntent = new Intent(this, MainScreen.class);
		goMainScreenIntent.putExtra("displayText", displayText);
		startActivity(goMainScreenIntent);
	}
}
