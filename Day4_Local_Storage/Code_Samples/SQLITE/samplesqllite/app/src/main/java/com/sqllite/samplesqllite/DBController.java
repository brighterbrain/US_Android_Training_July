package com.sqllite.samplesqllite;

import java.util.ArrayList;
import java.util.HashMap;
 
import android.util.Log;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DBController  extends SQLiteOpenHelper {
  private static final String LOGCAT = null;
 
  private static final int DB_VERSION = 1;
  
  private static final String TABLE_NAME = "animals";
  
  public DBController(Context applicationcontext) {
    super(applicationcontext, "androidsqlite.db", null, DB_VERSION);
    Log.d(LOGCAT,"Created");
  }
 
  @Override
  public void onCreate(SQLiteDatabase database) {
    String query;
    query = "CREATE TABLE animals ( animalId INTEGER PRIMARY KEY, animalName TEXT)";
    database.execSQL(query);
    Log.d(LOGCAT,"animals database created Created");
  }
  
  @Override
  public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
    String query;
    query = "DROP TABLE IF EXISTS animals";
    database.execSQL(query);
    onCreate(database);
  }
 
  public void insertAnimal(HashMap<String, String> queryValues) {
    SQLiteDatabase database = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put("animalName", queryValues.get("animalName"));
    
    long insertRowId = database.insert("animals", null, values);
    
    if(insertRowId != -1){
    	System.out.println("Successfully inserted row....");
    }
    
    database.close();
  }
 
  public int updateAnimal(HashMap<String, String> queryValues) {
    SQLiteDatabase database = this.getWritableDatabase();  
    ContentValues values = new ContentValues();
    values.put("animalName", queryValues.get("animalName"));
    return database.update(TABLE_NAME, values, "animalId" + " = ?", new String[] {"1" });
  }
 
  public void deleteAnimal(String id) {
    Log.d(LOGCAT,"delete");
    SQLiteDatabase database = this.getWritableDatabase();  
    String deleteQuery = "DELETE FROM  animals where animalId='"+ id +"'";
    Log.d("query",deleteQuery);   
    database.execSQL(deleteQuery);
  }
 
  public ArrayList<HashMap<String, String>> getAllAnimals() {
    ArrayList<HashMap<String, String>> wordList;
    wordList = new ArrayList<HashMap<String, String>>();
    String selectQuery = "SELECT  * FROM animals";
    SQLiteDatabase database = this.getWritableDatabase();
    Cursor cursor = database.rawQuery(selectQuery, null);
    if (cursor.moveToFirst()) {
      do {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("animalId", cursor.getString(0));
        map.put("animalName", cursor.getString(1));
        wordList.add(map);
      } while (cursor.moveToNext());
    }
    return wordList;
  }
 
  public HashMap<String, String> getAnimalInfo(String id) {
    HashMap<String, String> wordList = new HashMap<String, String>();
    SQLiteDatabase database = this.getReadableDatabase();
    String selectQuery = "SELECT * FROM animals where animalId='"+id+"'";
    Cursor cursor = database.rawQuery(selectQuery, null);
    if (cursor.moveToFirst()) {
      do {
        wordList.put("animalName", cursor.getString(1));
      } while (cursor.moveToNext());
    }           
    return wordList;
  } 
}