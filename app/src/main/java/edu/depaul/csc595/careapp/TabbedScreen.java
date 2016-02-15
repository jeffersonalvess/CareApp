package edu.depaul.csc595.careapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.viewpagerindicator.CirclePageIndicator;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TabbedScreen extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    public static final String FACEBOOK_PREFS = "FacebookPreferences";
    private AccessTokenTracker accessTokenTracker;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    public static String userName;
    public static String userID;

    private LoginButton loginButton;

    //private CallbackManager mCallBackManager;
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        SharedPreferences settings = getSharedPreferences(FACEBOOK_PREFS, 0);

//        if (settings.getBoolean("loginSucessful", false)) {
//            //Intent intent = new Intent();
//            //intent.setClass(WelcomeScreen.this, Splashscreen.class);
//            //intent.setClass(WelcomeScreen.this, GoogleMapsTest.class);
//            //intent.putExtra("REQ", 1);
//            //startActivity(intent);
//            finish();
//        }

//        accessTokenTracker = new AccessTokenTracker() {
//            @Override
//            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken,
//                                                       AccessToken currentAccessToken) {
//                if (currentAccessToken != null) {
//                    //showFragment(SELECTION, false);
//                } else {
//                    //showFragment(SPLASH, false);
//                    finish();
//                }
//                //}
//            }
//        };

        setContentView(R.layout.activity_tabbed_screen);

        loginButton = (LoginButton) findViewById(R.id.fb_login_button);
        System.out.println("uhuuuuuuuR");


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {

                //info.setText("Login Successful!");
                //Method to get Facebook information
//                GraphRequest request;
//                request = GraphRequest.newMeRequest(
//                        AccessToken.getCurrentAccessToken(),
//                        new GraphRequest.GraphJSONObjectCallback() {
//                            @Override
//                            public void onCompleted(JSONObject object, GraphResponse response) {
//
//                                try {
//                                    //userLocation = object.getJSONObject("user_location").getString("name");
//                                    saveProfileInformation(object.getString("first_name") + " " + object.getString("last_name"), object.getString("id"));
//
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        });


                Bundle parameters = new Bundle();
                parameters.putString("fields", "id, location, last_name, first_name");
                //request.setParameters(parameters);
                //request.executeAsync();

                SharedPreferences settings = getSharedPreferences(FACEBOOK_PREFS, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("loginSucessful", false);
                editor.commit();

                Intent intent = new Intent(TabbedScreen.this, MainActivity.class);
                intent.putExtra("REQ", 1);
                startActivity(intent);
                //finish();
                //getActivity().finish();
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException e) {
            }
        });

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //CirclePageIndicator circlePageIndicator = (CirclePageIndicator) findViewById(R.id.pagerIndicator);
        //circlePageIndicator.setViewPager(mViewPager);

        CirclePageIndicator mIndicator = (CirclePageIndicator) findViewById(R.id.pagerIndicator);
        mIndicator.setViewPager(mViewPager);

        final float density = getResources().getDisplayMetrics().density;
        mIndicator.setRadius(5 * density);
        mIndicator.setPageColor(0x00FFFFFF);
        mIndicator.setFillColor(0x880000FF);
        mIndicator.setStrokeColor(0xFF000000);
        mIndicator.setStrokeWidth(1 * density);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabbed_screen, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        //private LoginButton loginButton;
        //private CallbackManager mCallBackManager;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

//        private FacebookCallback<LoginResult> mCallback = new FacebookCallback<LoginResult>() {
//
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                AccessToken accessToken = loginResult.getAccessToken();
//                Profile profile = Profile.getCurrentProfile();
//
//                if (profile != null) {
//                    //Do something with data obtained
//
//                }
//
//
//                GraphRequest request;
//                request = GraphRequest.newMeRequest(
//                        AccessToken.getCurrentAccessToken(),
//                        new GraphRequest.GraphJSONObjectCallback() {
//                            @Override
//                            public void onCompleted(JSONObject object, GraphResponse response) {
//
//                                try {
//                                    //userLocation = object.getJSONObject("user_location").getString("name");
//                                    saveProfileInformation(object.getString("first_name") + " " + object.getString("last_name"), object.getString("id"));
//
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        });
//
//                Bundle parameters = new Bundle();
//                parameters.putString("fields", "id, location, last_name, first_name");
//                request.setParameters(parameters);
//                request.executeAsync();
//
//                SharedPreferences settings = getContext().getSharedPreferences(FACEBOOK_PREFS, 0); // 0 - for private mode
//                SharedPreferences.Editor editor = settings.edit();
//                editor.putBoolean("loginSucessful", false);
//                editor.commit();
//
//
//                Intent intent = new Intent(getActivity(), MainActivity.class);
//                intent.putExtra("REQ", 1);
//                startActivity(intent);
//
//                //getActivity().finish();
//
//
//
//
//                //Intent intent = new Intent(getActivity(), Splashscreen.class);
//                //intent.putExtra("REQ", 1);
//                //startActivity(intent);
//                //getActivity().finish();
//
//                // System.out.println("Facebook Login Successful!");
//                // System.out.println("Logged in user Details : ");
//                // System.out.println("--------------------------");
//                // System.out.println("User ID  : " + loginResult.getAccessToken().getUserId());
//                // System.out.println("Authentication Token : " + loginResult.getAccessToken().getToken());
//            }
//
//            @Override
//            public void onCancel() {
//                System.out.println("Facebook Login failed!!");
//
//            }
//
//            @Override
//            public void onError(FacebookException e) {
//                System.out.println("Facebook Login failed!!");
//            }
//        };



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_tabbed_screen, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.txtWelcome4);
            ImageView facebookLogo = (ImageView) rootView.findViewById(R.id.logoFace);

            //LoginButton loginButton2= (LoginButton) rootView.findViewById(R.id.fb_login_button2);
            //loginButton = (LoginButton) findViewById(R.id.fb_login_button2);




            //mCallBackManager = CallbackManager.Factory.create();
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            //loginButton.setFragment(this);
            //loginButton.registerCallback(mCallBackManager, mCallback);

            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    textView.setText("SCREEN 1");
                    //textView.setVisibility(View.INVISIBLE);
                    facebookLogo.setVisibility(View.INVISIBLE);
                    //loginButton.setVisibility(View.INVISIBLE);
                    break;
                case 2:
                    textView.setText("SCREEN 2");
                    //textView.setVisibility(View.INVISIBLE);
                    facebookLogo.setVisibility(View.INVISIBLE);
                    //loginButton.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    //textView.setText("");
                    textView.setVisibility(View.VISIBLE);
                    facebookLogo.setVisibility(View.VISIBLE);
                    //loginButton.setVisibility(View.INVISIBLE);
                    break;
            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
    public static void saveProfileInformation(String name, String id) throws IOException {

        userName = name;
        userID = id;
        //setInformationToView();
    }

    public static void setInformationToView() throws IOException {

        //TextView Line1 = (TextView) findViewById(R.id.txtWelcome4);

        //ImageView imagem1 = (ImageView) findViewById(R.id.logoFace);

        //Line1.setText(userName);

        //new ImageLoadTask("https://graph.facebook.com/" + userID + "/picture?type=large", imagem1).execute();
        System.out.println("https://graph.facebook.com/" + userID + "/picture?type=large");

    }
}



class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {


    private String url;
    private ImageView imageView;

    public ImageLoadTask(String url, ImageView imageView) {
        this.url = url;
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(Void... params) {
        try {
            URL urlConnection = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlConnection.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        imageView.setImageBitmap(result);
        imageView.setScaleX(5);
        imageView.setScaleY(5);
    }
}
