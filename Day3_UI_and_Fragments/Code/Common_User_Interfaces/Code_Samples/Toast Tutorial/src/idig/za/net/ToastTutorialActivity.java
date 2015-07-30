package idig.za.net;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class ToastTutorialActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Context theContext = getBaseContext();
        String theMessage = "I said, take it easy, Bob!";
        int theDuration = Toast.LENGTH_SHORT;
        
        Toast myToast = Toast.makeText(theContext, theMessage, theDuration);
        myToast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);       
        myToast.show();
    }
}