package com.example.startactivityforresult.activityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/*This activity receives a request for a string.
It returns a string to calling activity

        www.101apps.co.za
*/
public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intentReturnResult = new Intent();

        /*failed to get data so we return cancelled*/
        setResult(RESULT_CANCELED,intentReturnResult);
        finish();
    }

}
