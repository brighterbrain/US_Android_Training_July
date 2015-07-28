package com.ui.yogeshblogspot;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class GridViewExActivity extends Activity {
    /** Called when the activity is first created. */
	static final String[] androidVersions=new String[]
	                                                 {
		"Cupcake (Android 1.5)","Donut (Android 1.6)","Eclair (Android 2.0)","Froyo (Android 2.2)","Gingerbread (Android 2.3)","Honeycomb (Android 3.0)",
		"Ice Cream Sandwich (Android 4.0)","Jelly Bean (Android 4.1)"
	                                                 };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        GridView gv=(GridView)findViewById(R.id.versions);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, androidVersions);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						((TextView) v).getText(), Toast.LENGTH_SHORT).show();
				
			}
        	
		});
    }
}