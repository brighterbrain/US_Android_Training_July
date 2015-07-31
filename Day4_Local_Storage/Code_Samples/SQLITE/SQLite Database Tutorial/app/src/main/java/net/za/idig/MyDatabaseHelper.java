package net.za.idig;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	public MyDatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, Constants.DATABASE_FILE_NAME, null,
				Constants.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase dBase) {
		String sqlString = "CREATE TABLE " + Constants.TABLE_NAME + "("
				+ Constants.Col_ID + " INTEGER PRIMARY KEY , "
				+ Constants.Col_Author + "," + Constants.Col_Title + ")";
		dBase.execSQL(sqlString);
	}

	@Override
	public void onUpgrade(SQLiteDatabase dBase, int oldVersion, int newVersion) {
		if (oldVersion >= newVersion) {
			return;
		}
		String sqlString = "DROP TABLE IF EXISTS " + Constants.TABLE_NAME;
		dBase.execSQL(sqlString);
		onCreate(dBase);
	}
}
