package edu.depaul.csc595.careapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.depaul.csc595.careapp.Design.*;

public class RideActivity extends AppCompatActivity {

    private View mProfile;
    private View mProgress;
    private int mLongAnimationDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CircularProgressBar tempCircularProgressBar;
        OurImageView tempOurImageView;
        TextView tempTextView;

        findViewById(R.id.space_profile_1).setVisibility(View.GONE);
        findViewById(R.id.space_profile_2).setVisibility(View.GONE);
        findViewById(R.id.space_profile_3).setVisibility(View.GONE);


        mProfile = (LinearLayout) findViewById(R.id.ride_profile_view);
        mProgress = (LinearLayout) findViewById(R.id.ride_profile_wait);

        mProgress.setVisibility(View.GONE);

        mLongAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);


        // Tinting icons and setting TextViews text color based on the progress bars value.
        tempCircularProgressBar = (CircularProgressBar) findViewById(R.id.ride_cpBar1);
        tempOurImageView = (OurImageView) findViewById(R.id.ride_icon1);
        tempCircularProgressBar.setProgress(85.0f);
        tempOurImageView.setColorFilter(tempCircularProgressBar.getBackgroundColor());
        tempTextView = (TextView) findViewById(R.id.ride_num1);
        tempTextView.setTextColor(tempCircularProgressBar.getBackgroundColor());

        tempCircularProgressBar = (CircularProgressBar) findViewById(R.id.ride_cpBar2);
        tempOurImageView = (OurImageView) findViewById(R.id.ride_icon2);
        tempCircularProgressBar.setProgress(20.0f);
        tempOurImageView.setColorFilter(tempCircularProgressBar.getBackgroundColor());
        tempTextView = (TextView) findViewById(R.id.ride_num2);
        tempTextView.setTextColor(tempCircularProgressBar.getBackgroundColor());

        tempCircularProgressBar = (CircularProgressBar) findViewById(R.id.ride_cpBar3);
        tempOurImageView = (OurImageView) findViewById(R.id.ride_icon3);
        tempCircularProgressBar.setProgress(60.0f);
        tempOurImageView.setColorFilter(tempCircularProgressBar.getBackgroundColor());
        tempTextView = (TextView) findViewById(R.id.ride_num3);
        tempTextView.setTextColor(tempCircularProgressBar.getBackgroundColor());

        tempCircularProgressBar = (CircularProgressBar) findViewById(R.id.ride_cpBar4);
        tempOurImageView = (OurImageView) findViewById(R.id.ride_icon4);
        tempCircularProgressBar.setProgress(30.0f);
        tempOurImageView.setColorFilter(tempCircularProgressBar.getBackgroundColor());
        tempTextView = (TextView) findViewById(R.id.ride_num4);
        tempTextView.setTextColor(tempCircularProgressBar.getBackgroundColor());

        FloatingActionButton fabRefuse = (FloatingActionButton) findViewById(R.id.ride_btRefuse);
        FloatingActionButton fabAccept = (FloatingActionButton) findViewById(R.id.ride_btAccept);
        FloatingActionButton fabInfo = (FloatingActionButton) findViewById(R.id.ride_btInfo);

        fabAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crossfadeA();

                crossfadeB();
            }
        });

        fabRefuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crossfadeA();
            }
        });

        fabInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RideActivity.this, RideInfo.class));
            }
        });
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

    private void loadNewUser(int index)
    {

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
