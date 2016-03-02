package edu.depaul.csc595.careapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;

import edu.depaul.csc595.careapp.Design.*;

public class RideActivity extends AppCompatActivity {

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
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

        fabRefuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
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



}
