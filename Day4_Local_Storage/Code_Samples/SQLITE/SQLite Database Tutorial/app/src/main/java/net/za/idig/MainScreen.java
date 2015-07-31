package net.za.idig;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainScreen extends Activity {

	String displayText = null;
	String[] bookTitles, searchTerms = null;
	boolean showResults = false;
	MyDatabaseManager dbManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);

		dbManager = new MyDatabaseManager(this);

		Intent mainScreenIntent = getIntent();
		displayText = mainScreenIntent.getStringExtra("displayText");
		showResults = mainScreenIntent.getBooleanExtra("showResults", false);
		bookTitles = mainScreenIntent.getStringArrayExtra("bookTitles");

		Button showResultsButton = (Button) findViewById(R.id.button_show_search_results);
		showResultsButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(showResults){
					displaySearchResults();
				} else {
					Toast.makeText(MainScreen.this, "nothing to display", Toast.LENGTH_SHORT).show();
				}											
			}
		});

		TextView displayTextView = (TextView) findViewById(R.id.textView_display);
		displayTextView.setText(displayText);

		Button addAllBooksButton = (Button) findViewById(R.id.button_add_all_books);
		addAllBooksButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addAllBooks();
			}
		});

		Button addRecordButton = (Button) findViewById(R.id.button_add);
		addRecordButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				addRecord();
			}
		});

		Button findButton = (Button) findViewById(R.id.button_find);
		findButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				displaySearchTerms();
			}
		});

		Button displayBooklistButton = (Button) findViewById(R.id.button_showAll);
		displayBooklistButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				displayBookList();
			}
		});

		final Button confirmDeleteDatabaseButton = (Button) findViewById(R.id.button1_database_delete_confirm);
		confirmDeleteDatabaseButton.setVisibility(8);

		Button deleteDatabaseButton = (Button) findViewById(R.id.button_database_delete);
		deleteDatabaseButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				confirmDeleteDatabaseButton.setVisibility(0);
			}
		});

		confirmDeleteDatabaseButton
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						boolean databaseDeleted = dbManager.deleteMyDatabase();

						if (databaseDeleted) {
							Toast.makeText(MainScreen.this, "database deleted",
									Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(MainScreen.this,
									"problem deleting database...",
									Toast.LENGTH_SHORT).show();
						}
						confirmDeleteDatabaseButton.setVisibility(8);
					}
				});
	}

	private void addAllBooks() {
		bookTitles = getResources().getStringArray(R.array.titles);
		int count = 0;
		for (int i = 0; i < bookTitles.length; i++) {
			String author = "Clive Sargeant";
			String title = bookTitles[i];
			long rowId = dbManager.addBookToDB(author, title);
			if (rowId == -1) {
				Toast.makeText(this, "There is a problem adding the books",
						Toast.LENGTH_SHORT).show();
			} else {
				count++;
			}
		}
		Toast.makeText(this, count + " books added to the database",
				Toast.LENGTH_SHORT).show();
	}

	protected void displaySearchResults() {
		Intent myDisplayResultIntent = new Intent(this, ShowList.class);
		myDisplayResultIntent.putExtra("bookTitles", bookTitles);
		myDisplayResultIntent.putExtra("doThis", "editOrDelete");
		startActivity(myDisplayResultIntent);
	}

	protected void displaySearchTerms() {
		searchTerms = getResources().getStringArray(R.array.search_terms);
		Intent myIntent = new Intent(this, ShowList.class);
		myIntent.putExtra("bookTitles", searchTerms);
		myIntent.putExtra("doThis", "search");
		startActivity(myIntent);
	}

	private void displayBookList() {
		Cursor resultCursorAllRecords = dbManager.getAllRecords();
		if(resultCursorAllRecords.getCount() == 0){
			Toast.makeText(this, "nothing to display", Toast.LENGTH_SHORT).show();
		} else {
			bookTitles = new String[resultCursorAllRecords.getCount()];
			int arrayIndex = 0;
			while (resultCursorAllRecords.moveToNext()) {
				int titleIndex = resultCursorAllRecords
						.getColumnIndex(Constants.Col_Title);
				String title = resultCursorAllRecords.getString(titleIndex);
				bookTitles[arrayIndex] = title;
				arrayIndex++;
			}
			resultCursorAllRecords.close();
			dbManager.close();
			Intent myIntent = new Intent(this, ShowList.class);
			myIntent.putExtra("bookTitles", bookTitles);
			myIntent.putExtra("doThis", "displayOnly");
			startActivity(myIntent);
		}		
	}

	protected void addRecord() {
		bookTitles = getResources().getStringArray(R.array.new_books);
		Intent showNewBooksListIntent = new Intent(this, ShowList.class);
		showNewBooksListIntent.putExtra("doThis", "addRecord");
		showNewBooksListIntent.putExtra("bookTitles", bookTitles);
		startActivity(showNewBooksListIntent);
	}
}
