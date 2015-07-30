package com.example.auto_complete;

import android.R.string;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
//import android.support.v4.content.CursorLoader;
//import android.support.v4.widget.CursorAdapter;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uri allcontacts = ContactsContract.Contacts.CONTENT_URI;
        
        ContentResolver cr = getContentResolver();
       /* Cursor c = cr.query(allcontacts, null, null, null, null);
        c.moveToFirst();
        
        String[] Names = new String[c.getCount() - 1];
        int i = 0;
        if(c.getCount() > 0)
        {
        	while (c.moveToNext())
        	{
        		//Names[i] = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
        		i++;
        	}
        }*/

        String[] Names = new String[]{
       		"Arpan",
        		"Ameya",
        		"Anita",
        		"Shona",
        		"Rahul",
        		"Sunil",
        		"SUnil Sachin",
     		"Shona Arpan",
       		"Shona Bagul",
        		"Ketan Gandhi",
        		"Shobha Raut"
       };
        AutoCompleteTextView autotext = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row,Names);
		autotext.setThreshold(3);
        autotext.setAdapter(adapter);
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
