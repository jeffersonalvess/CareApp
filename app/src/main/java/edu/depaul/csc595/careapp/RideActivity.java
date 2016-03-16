package edu.depaul.csc595.careapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.depaul.csc595.careapp.Design.*;
import edu.depaul.csc595.careapp.Helpers.FacebookUserInfo;
import edu.depaul.csc595.careapp.Helpers.UserProfileAndStatistics;

public class RideActivity extends AppCompatActivity {

    private View mProfile;
    private View mProgress;
    private int mLongAnimationDuration;
    private ArrayList<UserProfileAndStatistics> users;
    private int indexCount;

    private TextView txtTimer;
    private ProgressBar pbTimer;

    private RelativeLayout layBts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.space_profile_1).setVisibility(View.GONE);
        findViewById(R.id.space_profile_2).setVisibility(View.GONE);
        findViewById(R.id.space_profile_3).setVisibility(View.GONE);

        mProfile = (LinearLayout) findViewById(R.id.ride_profile_view);
        mProgress = (LinearLayout) findViewById(R.id.ride_profile_wait);

        mProgress.setVisibility(View.GONE);

        mLongAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);

        FloatingActionButton fabRefuse = (FloatingActionButton) findViewById(R.id.ride_btRefuse);
        FloatingActionButton fabAccept = (FloatingActionButton) findViewById(R.id.ride_btAccept);
        FloatingActionButton fabInfo = (FloatingActionButton) findViewById(R.id.ride_btInfo);


        try
        {
            createGambiarraList();
            loadNewUser(indexCount);
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

       layBts = (RelativeLayout) findViewById(R.id.ride_layBt);

        fabAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTransition();
//                Toast.makeText(getApplicationContext(), "You would take a ride with this driver :)", Toast.LENGTH_SHORT).show();
                layBts.setVisibility(View.INVISIBLE);
            }
        });

        fabRefuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTransition();
//                Toast.makeText(getApplicationContext(), "You would take a ride with this driver :)", Toast.LENGTH_SHORT).show();
                layBts.setVisibility(View.INVISIBLE);
            }
        });

        fabInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RideActivity.this, RideInfo.class));
            }
        });

        txtTimer = (TextView) findViewById(R.id.ride_txtTimer);
        pbTimer = (ProgressBar) findViewById(R.id.ride_pbTimer);

        txtTimer.setVisibility(View.GONE);
        pbTimer.setVisibility(View.GONE);
    }

    private void userTransition(){
        crossfadeA();

        txtTimer.setVisibility(View.VISIBLE);
        pbTimer.setVisibility(View.VISIBLE);

        pbTimer.setProgress(0);

        new CountDownTimer(5200, 100) {

            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished > 201)
                    txtTimer.setText(Integer.toString((int) (millisUntilFinished - 200) / 1000 + 1));
                else
                    txtTimer.setText("0");
            }

            public void onFinish() {
                txtTimer.setVisibility(View.GONE);
                pbTimer.setVisibility(View.GONE);
                loadNewUser(indexCount);
                layBts.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }

        return true;
    }

    public Intent getFBIntent(PackageManager pm, String facebookId) {
        facebookId = "https://www.facebook.com/" + facebookId;
        Uri uri = Uri.parse(facebookId);

        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {
                uri = Uri.parse("fb://facewebmodal/f?href=" + facebookId);
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return new Intent(Intent.ACTION_VIEW, uri);
    }

    private void loadNewUser(int index)
    {
        CircularProgressBar tempCircularProgressBar;
        OurImageView tempOurImageView;
        TextView tempTextView;

        final UserProfileAndStatistics u = users.get(index);

        tempCircularProgressBar = (CircularProgressBar) findViewById(R.id.ride_cpBar1);
        tempOurImageView = (OurImageView) findViewById(R.id.ride_icon1);
        tempCircularProgressBar.setProgress(Float.parseFloat(u.getAverageSpeed()));
        tempOurImageView.setColorFilter(tempCircularProgressBar.getBackgroundColor());
        tempTextView = (TextView) findViewById(R.id.ride_num1);
        tempTextView.setTextColor(tempCircularProgressBar.getBackgroundColor());

        tempCircularProgressBar = (CircularProgressBar) findViewById(R.id.ride_cpBar2);
        tempOurImageView = (OurImageView) findViewById(R.id.ride_icon2);
        tempCircularProgressBar.setProgress(Float.parseFloat(u.getAverageInfractionsPerTrip()) * 10);
        tempOurImageView.setColorFilter(tempCircularProgressBar.getBackgroundColor());
        tempTextView = (TextView) findViewById(R.id.ride_num2);
        tempTextView.setTextColor(tempCircularProgressBar.getBackgroundColor());

        tempCircularProgressBar = (CircularProgressBar) findViewById(R.id.ride_cpBar3);
        tempOurImageView = (OurImageView) findViewById(R.id.ride_icon3);
        tempCircularProgressBar.setProgress(Float.parseFloat(u.getAverageInfractions100mi()) * 10);
        tempOurImageView.setColorFilter(tempCircularProgressBar.getBackgroundColor());
        tempTextView = (TextView) findViewById(R.id.ride_num3);
        tempTextView.setTextColor(tempCircularProgressBar.getBackgroundColor());

        tempCircularProgressBar = (CircularProgressBar) findViewById(R.id.ride_cpBar4);
        tempOurImageView = (OurImageView) findViewById(R.id.ride_icon4);
        tempCircularProgressBar.setProgress(Float.parseFloat(u.getAverageInfractions24h()) * 10);
        tempOurImageView.setColorFilter(tempCircularProgressBar.getBackgroundColor());
        tempTextView = (TextView) findViewById(R.id.ride_num4);
        tempTextView.setTextColor(tempCircularProgressBar.getBackgroundColor());

        TextView a = (TextView) findViewById(R.id.ride_points);
        TextView b = (TextView) findViewById(R.id.ride_dist_driven);
        TextView c = (TextView) findViewById(R.id.ride_kd_challenge);
        TextView d = (TextView) findViewById(R.id.ride_hours_driven);
        TextView e = (TextView) findViewById(R.id.ride_challenges);
        TextView f = (TextView) findViewById(R.id.ride_quizes_stats);
        TextView g = (TextView) findViewById(R.id.profileName);
        TextView h = (TextView) findViewById(R.id.ride_num1);
        TextView i = (TextView) findViewById(R.id.ride_num2);
        TextView j = (TextView) findViewById(R.id.ride_num3);
        TextView k = (TextView) findViewById(R.id.ride_num4);

        CircleImageView l = (CircleImageView) findViewById(R.id.userProfilePicture);
        CircleImageView m = (CircleImageView) findViewById(R.id.userProfilePicture2);

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebookIntent = getFBIntent(getApplicationContext().getPackageManager(), u.getFbID());

                startActivity(facebookIntent);
            }
        });

        a.setText(u.getPoints());
        b.setText(u.getDrivenMiles());
        c.setText(u.getFriendChallenges());
        d.setText(u.getDrivenTime());
        e.setText(u.getAchievements());
        f.setText(u.getQuiz());
        g.setText(u.getFbName());
        h.setText(u.getAverageSpeed());
        i.setText(u.getAverageInfractionsPerTrip());
        j.setText(u.getAverageInfractions100mi());
        k.setText(u.getAverageInfractions24h());
        l.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.com_facebook_profile_picture_blank_square));

        indexCount = (indexCount <= 0) ? users.size() - 1 : indexCount - 1;

        crossfadeB();
        m.setImageBitmap(u.getFbPicture());
    }

    private void createGambiarraList() throws ExecutionException, InterruptedException
    {
        users = new ArrayList<>();

        users.add(new UserProfileAndStatistics(
                "10154650092913009",
                "Lucas",
                "30",
                "2",
                "3",
                "4",
                "23000",
                "975/0",
                "3",
                "200 miles",
                "0.5 hours",
                "78%"
        ));

        users.add(new UserProfileAndStatistics(
                "988159154611919",
                "Matheus",
                "60",
                "7",
                "2",
                "1",
                "27000",
                "500/0",
                "10",
                "150 miles",
                "2 hours",
                "90%"
        ));

        users.add(new UserProfileAndStatistics(
                "10204521347753539",
                "Jefferson",
                "130",
                "2.5",
                "2.5",
                "2.5",
                "23000",
                "975/0",
                "3",
                "1000 miles",
                "0.5 hours",
                "90%"
        ));

        users.add(new UserProfileAndStatistics(
                "903567903084504",
                "Renato",
                "90",
                "5",
                "10",
                "2",
                "2300",
                "50/0",
                "2",
                "350 miles",
                "10 hours",
                "56%"
        ));

        users.add(new UserProfileAndStatistics(
                "970064856419280",
                "Miller",
                "100",
                "7",
                "10",
                "9",
                "100",
                "10/0",
                "10",
                "500 miles",
                "20 hours",
                "100%"
        ));

        indexCount = users.size() - 1;
    }

    private void crossfadeA() {

        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        mProgress.setAlpha(0f);
        mProgress.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        mProgress.animate()
                .alpha(1f)
                .setDuration(mLongAnimationDuration)
                .setListener(null);

        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step (it won't
        // participate in layout passes, etc.)
        mProfile.animate()
                .alpha(0f)
                .setDuration(mLongAnimationDuration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mProfile.setVisibility(View.GONE);
                    }
                });
    }

    private void crossfadeB() {

        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        mProfile.setAlpha(0f);
        mProfile.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        mProfile.animate()
                .alpha(1f)
                .setDuration(mLongAnimationDuration)
                .setListener(null);

        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step (it won't
        // participate in layout passes, etc.)
        mProgress.animate()
                .alpha(0f)
                .setDuration(mLongAnimationDuration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mProgress.setVisibility(View.GONE);
                    }
                });
    }



}
