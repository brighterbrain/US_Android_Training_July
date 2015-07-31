package uk.co.theappexperts.modelviewpresenter.view.activity;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import uk.co.theappexperts.modelviewpresenter.R;
import uk.co.theappexperts.modelviewpresenter.model.User;
import uk.co.theappexperts.modelviewpresenter.presenter.LoginPresenter;
import uk.co.theappexperts.modelviewpresenter.presenter.Presenter;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginPresenter.LoginViewContract {

    private Button mLoginButton;
    private EditText mUsername, mPassword;
    private Presenter mPresenter;

    @Override
    protected void createPresenter() {
        mPresenter = new LoginPresenter(LoginActivity.this);
        mPresenter.initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    protected void configViews() {
        mLoginButton = (Button) findViewById(R.id.btnLogin);
        mUsername = (EditText) findViewById(R.id.txtUsername);
        mPassword = (EditText) findViewById(R.id.txtPassword);
        mLoginButton.setOnClickListener(this);
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                mPresenter.login(mUsername.getText().toString(), mPassword.getText().toString());
                break;
            default:
                Toast.makeText(getApplicationContext(), "Widget Id not found!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSuccessLogin(User user) {
        mPresenter.loginSuccess(user);
    }

    @Override
    public void onFailedLogin(String error) {
        Toast.makeText(getApplicationContext(), "Error :: " + error, Toast.LENGTH_LONG).show();
    }

    @Override
    public LoginActivity getActivity() {
        return LoginActivity.this;
    }
}
