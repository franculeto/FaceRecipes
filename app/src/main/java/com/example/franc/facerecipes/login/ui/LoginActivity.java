package com.example.franc.facerecipes.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.example.franc.facerecipes.R;
import com.example.franc.facerecipes.RecipeMainActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btnLogin)
    LoginButton btnLogin;
    @BindView(R.id.loginContainer)
    RelativeLayout container;
    private CallbackManager callbackManager;
    LoginButton log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        log = (LoginButton) findViewById(R.id.btnLogin);

        if (AccessToken.getCurrentAccessToken() != null) {
            navigateToMainScreen();
        }

        setCallbackManager();
    }

    private void setCallbackManager() {
        callbackManager = CallbackManager.Factory.create();
        log.setPublishPermissions(Arrays.asList("publish_actions"));
        log.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                navigateToMainScreen();
            }

            @Override
            public void onCancel() {
                Snackbar.make(container, R.string.login_cancel_error, Snackbar.LENGTH_SHORT);
            }

            @Override
            public void onError(FacebookException error) {
                String msgError = String.format(getString(R.string.login_error), error);
                Snackbar.make(container, msgError, Snackbar.LENGTH_SHORT);

            }
        });
    }

    private void navigateToMainScreen() {

        Intent intent = new Intent(this, RecipeMainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //AppEventsLogger.activateApp(getApplicationContext());
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }
}
