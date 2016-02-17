package edu.depaul.csc595.careapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.depaul.csc595.careapp.main_fragments.GamesFragment;
import edu.depaul.csc595.careapp.main_fragments.MyCarFragment;
import edu.depaul.csc595.careapp.main_fragments.ProfileFragment;
import edu.depaul.csc595.careapp.main_fragments.RewardsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    MenuItem facelogout;
    private static String userName;
    private static String userID;
    NavigationView navView;

    private FloatingActionButton fbLeft;
    private FloatingActionButton fbCenter;
    private FloatingActionButton fbRight;

    private SparseArray<View.OnClickListener> floatingActionButtonOnClickListeners;



    //This method is part of facebook implementation
    private void saveProfileInformation(String name, String id) throws IOException {

        userName = name;
        userID = id;
        setInformationToView();
    }

    //This method is part of facebook implementation
    private void setInformationToView() throws IOException {

        TextView txtUserName = (TextView) navView.findViewById(R.id.username);
        CircleImageView imagem1 = (CircleImageView) navView.findViewById(R.id.imgRoundedRight);

        txtUserName.setText(userName);
        new ImageLoadTask("https://graph.facebook.com/" + userID + "/picture?type=large", imagem1).execute();

    }

    //This method is part of facebook implementation
    private class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {

        private String url;
        private CircleImageView imageView;

        public ImageLoadTask(String url, CircleImageView imageView) {
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
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar support code
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_icons_toolbar);
        setSupportActionBar(toolbar);


        navView = (NavigationView) findViewById(R.id.nav_view);

        fbLeft = (FloatingActionButton) findViewById(R.id.buttonLeft);
        fbCenter = (FloatingActionButton) findViewById(R.id.buttonCenter);
        fbRight = (FloatingActionButton) findViewById(R.id.buttonRight);

        //TODO: Criar isso aqui dentro de uma classe com metodos para retorno dos valores, assim fica mais facil acessa isso de qualquer do codigo.
        //Method to get Facebook information
        GraphRequest request;
        request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {

                        try {
                            //userLocation = object.getJSONObject("user_location").getString("name");
                            saveProfileInformation(object.getString("first_name") + " " + object.getString("last_name"), object.getString("id"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id, location, last_name, first_name");
        request.setParameters(parameters);
        request.executeAsync();
        // Facebook end.

        //Sidebar Menu
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        facelogout = (MenuItem) findViewById(R.id.face_logout);


//        //Floating Button <<temporary?>>
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Jefferson Gordo
//            }
//        });


        // TabView Elements
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.main_tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    //region SIDEMENU
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here. bunda
        int id = item.getItemId();

        if (id == R.id.face_logout) {
            // TODO: Acrescentar FacebookLogoutActivity ou Ação de logout.
            //Toast.makeText(MainActivity.this, "Replace with your own action", Toast.LENGTH_SHORT).show();
            LoginManager.getInstance().logOut();

            SharedPreferences settings = getSharedPreferences(TabbedScreen.FACEBOOK_PREFS, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("loginSucessful", true);
            editor.commit();


            Intent intent = new Intent();
            intent.setClass(MainActivity.this, TabbedScreen.class);
            intent.putExtra("REQ", 1);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //endregion

    //region TAB_VIEW
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_timer_profile_24dp);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_steering_wheel);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_directions_car);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_attach_money_24dp);
    }

    /**
     * Adding fragments to ViewPager
     * @param viewPager
     */

    private void setupViewPager(final ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new ProfileFragment(), "PROFILE");
        adapter.addFrag(new GamesFragment(), "GAME");
        adapter.addFrag(new MyCarFragment(), "MY CAR");
        adapter.addFrag(new RewardsFragment(), "REWARDS");
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if(position == 0) {
                    fbLeft.show();
                    fbCenter.show();
                    fbRight.show();
                }
                else{
                    fbLeft.hide();
                    fbCenter.hide();
                    fbRight.hide();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                viewPager.getCurrentItem();

                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        if(viewPager.getCurrentItem() != 0) {
                            fbLeft.hide();
                            fbCenter.hide();
                            fbRight.hide();
                        }
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        if(viewPager.getCurrentItem() == 0) {
                            fbLeft.show();
                            fbCenter.show();
                            fbRight.show();
                        }
                }
            }
        });
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) { return null; }
    }
    //endregion
}
