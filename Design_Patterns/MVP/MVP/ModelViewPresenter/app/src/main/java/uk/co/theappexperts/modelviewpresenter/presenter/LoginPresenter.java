package uk.co.theappexperts.modelviewpresenter.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import uk.co.theappexperts.modelviewpresenter.model.User;
import uk.co.theappexperts.modelviewpresenter.view.activity.LoginActivity;
import uk.co.theappexperts.modelviewpresenter.view.activity.MainActivity;

public class LoginPresenter extends Presenter {

    private LoginViewContract mView;
    private User mUser;

    public LoginPresenter(LoginViewContract view) {
        mView = view;
    }

    @Override
    public void initialize() {
        mUser = new User();
    }

    @Override
    public void onResume() {
        //Do Nothing (In case of screen orientation or onRestoreSavedInstance reassign values agai
    }

    @Override
    public void onPause() {
        //Do Nothing
    }

    @Override
    public void onDestroy() {
        //Do Nothing
    }

    @Override
    public void login(String userName, String password) {
        super.login(userName, password);
        if(mUser.getUsername().equals(userName) && mUser.getPassword().equals(password)) {
            mView.onSuccessLogin(mUser);
        }
        else {
            mView.onFailedLogin("Invalid Username or Password! Please try -- > admin admin");
        }
    }

    @Override
    public void loginSuccess(User user) {
        super.loginSuccess(user);
        LoginActivity loginActivity = mView.getActivity();
        Intent intent = new Intent(loginActivity, MainActivity.class);
        intent.putExtra("user", user);
        loginActivity.startActivity(intent);
    }

    public interface LoginViewContract {

        void onSuccessLogin(User user);

        void onFailedLogin(String error);

        LoginActivity getActivity();
    }
}
