package uk.co.theappexperts.modelviewpresenter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * This class is the Base class for all activities
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());
        provideIntent(getIntent());
        configViews();
        createPresenter();
    }

    protected abstract void createPresenter();

    protected abstract void configViews();

    /**
     * This method would be invoked if the subclass need to get the intent
     * @param intent
     */
    protected void provideIntent(Intent intent) {
    }

    protected abstract int getActivityLayout();
}
