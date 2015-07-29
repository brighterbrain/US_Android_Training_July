package com.example.startactivityforresult.activityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/*This activity receives a request for a string.
It returns a string to calling activity

        www.101apps.co.za
*/
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String script = getString(R.string.script_string);
        Intent intentReturnResult = new Intent();
        intentReturnResult.putExtra("script", script);

        /*test result ok and result cancelled by changing value of success*/
        boolean success = true;
        if (success) {
            setResult(RESULT_OK,intentReturnResult);
        } else {
            setResult(RESULT_CANCELED,intentReturnResult);
        }
        finish();
    }

}
