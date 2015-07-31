package uk.co.theappexperts.modelviewpresenter.presenter;

import uk.co.theappexperts.modelviewpresenter.model.User;

public abstract class Presenter {

    public abstract void initialize();

    public abstract void onResume();

    public abstract void onPause();

    public abstract void onDestroy();

    public void login(String userName, String password) {

    }
    public void loginSuccess(User user) {
    }
}
