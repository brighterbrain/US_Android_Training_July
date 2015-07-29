package com.ex.first;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First extends Activity {
	Button btn;
	final Context context=this;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn=(Button)findViewById(R.id.button1);
        
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
		//		alert();
				//Toast.makeText(First.this, "Clicked ", Toast.LENGTH_LONG).show();	
		Intent i=new Intent(First.this,Second.class);
			
			startActivity(i);
			//String url ="tel:7845454";
			//Intent i=new Intent(Intent.ACTION_CALL,Uri.parse(url));
			
				//Intent i = new Intent("android.intent.action.DIAL");
				
				
				//Intent i=new Intent(First.this,Second.class);
				//i.putExtra("Name", "Kalpesh");
				//startActivity(i);
				
			
			}
		});   
		
    }
    
    
    public void alert(){
    	AlertDialog.Builder builder=new AlertDialog.Builder(context);
    	
    	builder.setTitle("GET APPLICATION CLOSED");
    	builder.setMessage("Do you want to exit application ?");
    	
    	builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				finish();
			}
		});
    	
    	builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
		});
    	
    	AlertDialog alertDialog = builder.create();

		// show it
		alertDialog.show();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
/*public void alert(){
    	
    	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
    	// Add the buttons
    	alertDialogBuilder.setTitle("Your Title");
    	 
		// set dialog message
		alertDialogBuilder
			.setMessage("Click yes to exit!")
			.setCancelable(false)
			
			.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, close
					// current activity
					finish();
					
				}
			  })
			.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, just close
					// the dialog box and do nothing
					dialog.cancel();
				}
			});

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// show it
			alertDialog.show();
    	
    	
    }
    */
    
    
    
    
}