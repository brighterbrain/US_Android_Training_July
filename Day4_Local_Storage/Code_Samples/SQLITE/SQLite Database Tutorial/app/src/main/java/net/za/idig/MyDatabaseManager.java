package net.za.idig;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class MyDatabaseManager {
	private SQLiteDatabase dataBase;
	private final Context theContext;
	private final MyDatabaseHelper myDbHelper;

	public MyDatabaseManager(Context c) {
		theContext = c;
		myDbHelper = new MyDatabaseHelper(theContext, 
				Constants.DATABASE_FILE_NAME,
				null, Constants.DATABASE_VERSION);
	}

	public void close() {
		dataBase.close();
	}

	public void open() throws SQLiteException {
		try {
			dataBase = myDbHelper.getWritableDatabase();
		} catch (SQLiteException ex) {
		}
	}

	public long deleteRecord(int recordId) {
		open();
		String whereClause = Constants.Col_ID + " = ? ";
		String stringRecordId = Integer.toString(recordId);
		String[] whereArgs = { stringRecordId };
		long numberRowsDeleted = dataBase.delete(Constants.TABLE_NAME,
				whereClause, whereArgs);
		close();
		return numberRowsDeleted;
	}

	public long addBookToDB(String author, String title) {
		open();
		ContentValues values = new ContentValues();
		values.put(Constants.Col_Author, author);
		values.put(Constants.Col_Title, title);
		long rowId = dataBase.insert(Constants.TABLE_NAME, null, values);
		close();
		return rowId;
	}

	public Cursor getRecordByTitle(String searchTerm) {
		open();
		String selection = null;
		Cursor getRecordsTitlesCursor;
		String[] columns = { Constants.Col_ID, Constants.Col_Title };

		// do exact match search first
		selection = Constants.Col_Title + " = '" + searchTerm + "'";// exact
																	// match
		String[] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = null;
		getRecordsTitlesCursor = dataBase.query(Constants.TABLE_NAME, columns, selection,
				selectionArgs, groupBy, having, orderBy);

		// if nothing found do search to see if contains
		if (getRecordsTitlesCursor.getCount() == 0) {
			// contains
			selection = Constants.Col_Title + " LIKE '%" + searchTerm + "%'";// contains
			getRecordsTitlesCursor = dataBase.query(Constants.TABLE_NAME, columns, selection,
					selectionArgs, groupBy, having, orderBy);
		}
		return getRecordsTitlesCursor;
	}

	public Cursor getAllRecords() {
		open();
		Cursor getAllRecordsCursor;
		String[] columns = { Constants.Col_ID, Constants.Col_Author,
				Constants.Col_Title };
		String selection = null;
		String[] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = null;
		getAllRecordsCursor = dataBase.query(Constants.TABLE_NAME, columns, selection,
				selectionArgs, groupBy, having, orderBy);
		return getAllRecordsCursor;
	}

	public long updateRecord(int recordId, String newTitle) {
		open();
		ContentValues values = new ContentValues();
		values.put(Constants.Col_Title, newTitle);
		String whereClause = Constants.Col_ID + " = ? ";
		String[] whereArgs = { Integer.toString(recordId) };
		long numberRowsUpdated = dataBase.update(Constants.TABLE_NAME, values,
				whereClause, whereArgs);
		close();
		return numberRowsUpdated;
	}

	public boolean deleteMyDatabase() {
		return theContext.deleteDatabase(Constants.DATABASE_FILE_NAME);
	}
}
