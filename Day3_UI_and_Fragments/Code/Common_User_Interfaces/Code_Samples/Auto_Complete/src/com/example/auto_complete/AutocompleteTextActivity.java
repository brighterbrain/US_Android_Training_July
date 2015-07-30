package com.example.auto_complete;

import android.R.color;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
 
public class AutocompleteTextActivity extends Activity {
    /** Called when the activity is first created. */
   // static final String[] ITEMS = new String[] { "Tea",
   //     "Coffee", "Milk", "Expresso", "Lemon Tea", "Cappuciano",
   //     "Hot Water", "Tomato Soup", "Ginger Tea", "ColdDrink"};
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);    
        setContentView(R.layout.auto);    
        
  Uri allcontacts = ContactsContract.Contacts.CONTENT_URI;
        
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(allcontacts, null, null, null, null);
        c.moveToFirst();
        
        String[] Names = new String[c.getCount() - 1];
        int i = 0;
        if(c.getCount() > 0)
        {
        	while (c.moveToNext())
        	{
        		Names[i] = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
        		i++;
        	}
        }
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_country);    
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, Names);    
        textView.setAdapter(adapter);
      
        }
}  