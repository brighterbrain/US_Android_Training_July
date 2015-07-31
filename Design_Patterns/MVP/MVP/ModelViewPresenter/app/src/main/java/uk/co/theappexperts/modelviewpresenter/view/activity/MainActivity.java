package uk.co.theappexperts.modelviewpresenter.view.activity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.theappexperts.modelviewpresenter.R;
import uk.co.theappexperts.modelviewpresenter.model.User;


public class MainActivity extends BaseActivity {

    private User mUser;
    private Button mBackButton;
    private TextView mFirstName, mLastName, mEmail, mUserName, mRegisteredDate;

    @Override
    protected void provideIntent(Intent intent) {
        super.provideIntent(intent);
        mUser = (User) intent.getSerializableExtra("user");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void welcome() {
        Toast.makeText(getApplicationContext(), "Hello " + mUser.getFirstName() + " " + mUser.getLastName() + ", you are now logged in!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void createPresenter() {
        //Create another presenter for MainPresenter here
        welcome();
    }

    @Override
    protected void configViews() {
        mBackButton = (Button) findViewById(R.id.backBtn);
        mFirstName = (TextView) findViewById(R.id.firstName);
        mLastName = (TextView) findViewById(R.id.lastName);
        mEmail = (TextView) findViewById(R.id.email);
        mUserName = (TextView) findViewById(R.id.userName);
        mRegisteredDate = (TextView) findViewById(R.id.registeredDate);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        bindViews();
    }

    private void bindViews() {
        mFirstName.setText(mFirstName.getText() + " " + mUser.getFirstName());
        mLastName.setText(mLastName.getText() + " " + mUser.getLastName());
        mEmail.setText(mEmail.getText() + " " + mUser.getEmail());
        mRegisteredDate.setText(mRegisteredDate.getText() + " " + mUser.getRegisteredDate());
        mUserName.setText(mUserName.getText() + " " + mUser.getUsername());
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_main;
    }
}
