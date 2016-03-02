package edu.depaul.csc595.careapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;

import java.util.concurrent.ExecutionException;

import edu.depaul.csc595.careapp.Helpers.FacebookUserInfo;
import edu.depaul.csc595.careapp.Helpers.FacebookUserProfileInfo;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashScreen extends AppCompatActivity {

    private LoginButton loginButton;
    public CallbackManager mCallbackManager;
    public static final String FACEBOOK_PREFS = "FacebookPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        FacebookSdk.sdkInitialize(getApplicationContext());
        SharedPreferences settings = getSharedPreferences(FACEBOOK_PREFS, 0);

        if (settings.getBoolean("loginSucessful", true)) {

            Intent intent = new Intent();
            intent.setClass(this, TabbedScreen.class);
            intent.putExtra("REQ", 1);
            startActivity(intent);
            finish();
        }
        else
        {
            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);

            intent.putExtra("REQ", 1);
            startActivity(intent);
            finish();
        }


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }
}
