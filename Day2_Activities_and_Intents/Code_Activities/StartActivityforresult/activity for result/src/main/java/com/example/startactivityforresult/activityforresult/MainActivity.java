package com.example.startactivityforresult.activityforresult;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/*Displays a button. Pressing button request a string from
another activity.
On success, the returned string is displayed in a text view

            www.101apps.co.za
*/
public class MainActivity extends ActionBarActivity {

    private static final int REQUEST_CODE_TWO = 102;
    private int REQUEST_CODE_ONE = 101;
    private TextView textViewDisplay;

    private String TAG = "activity_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDisplay = (TextView) findViewById(R.id.textView);

        Button buttonGetScript = (Button) findViewById(R.id.button);
        buttonGetScript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGetScript = new Intent(MainActivity.this,
                        SecondActivity.class);
                startActivityForResult(intentGetScript, REQUEST_CODE_ONE);
            }
        });

        Button buttonCancelled = (Button) findViewById(R.id.button2);
        buttonCancelled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGetScript = new Intent(MainActivity.this,
                        ThirdActivity.class);
                startActivityForResult(intentGetScript, REQUEST_CODE_TWO);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG,"requestCode: " + requestCode + " resultCode: " + resultCode);
        switch(requestCode){
            case 101://it's the result for our request one
                if(resultCode == RESULT_OK){//int value of -1
//                    get the data out of the returned intent
                    String script = data.getStringExtra("script");
//                    display the returned text in the text view
                    textViewDisplay.setText(script);
                } else if (resultCode == RESULT_CANCELED) {//int value of 0 (zero)
                    Toast.makeText(this, "The request " + REQUEST_CODE_ONE +
                            " was cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
            case 102://it's the result for our request two
                if(resultCode == RESULT_OK){//int value of -1
//                    get the data out of the returned intent
                    Bundle bundle = data.getExtras();
                    if(bundle == null){
                        Log.i(TAG, "Contains no data");
                    } else {
                        Log.i(TAG, "Contains data");
                    }
                } else if (resultCode == RESULT_CANCELED) {//int value of 0 (zero)
                    Toast.makeText(this, "The request " + REQUEST_CODE_TWO +
                            " was cancelled", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}
