package edu.depaul.csc595.careapp.Lucas;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import edu.depaul.csc595.careapp.R;

public class ChallengeList extends ListActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ChallangeAdapter());
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }

    class ChallangeAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        @Override
        public int getCount() {
            return CHALLENGES.length;
        }

        @Override
        public Object getItem(int position) {
            return CHALLENGES[position];
        }


        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;

            if (convertView == null) {
                if (inflater == null) {
                    inflater = (LayoutInflater) ChallengeList.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                }
                row = inflater.inflate(R.layout.list_item_type_5, parent, false);
            }



            TextView txtCardTitle = (TextView) row.findViewById(R.id.txtCardTitle);
            TextView textContentTitle = (TextView) row.findViewById(R.id.txtContentTitle);
            TextView txtLine1 = (TextView) row.findViewById(R.id.txtLine1);
            ImageView imgCardIconSquared = (ImageView) row.findViewById(R.id.imgCardIconSquared);
            ProgressBar progressBar = (ProgressBar) row.findViewById(R.id.progressBar);
            Button btnGetOffer = (Button) row.findViewById((R.id.btnGetOffer));
            Button btnSaveOffer = (Button) row.findViewById((R.id.btnSaveOffer));
            ImageView imgIconRewards = (ImageView) row.findViewById(R.id.imgIconRewards);
            TextView lblStatus = (TextView) row.findViewById(R.id.lblStatus);




            btnGetOffer.setVisibility(View.GONE);
            btnSaveOffer.setVisibility(View.GONE);
            textContentTitle.setVisibility(View.GONE);

            Challenge challenge = CHALLENGES[position];
            txtCardTitle.setText(challenge.getTitle());

            txtLine1.setText(challenge.getDetails());
            progressBar.setMax(100);
            progressBar.setProgress(challenge.getChallengeProgress());

            switch (challenge.getChallengeType()) {
                case HARDBREAK:
                    imgCardIconSquared.setImageResource(R.mipmap.ic_action_hard_break);
                    break;

                case HARDCURVE:
                    imgCardIconSquared.setImageResource(R.mipmap.ic_action_hard_curve);
                    break;

                case MAXSPEED:
                    imgCardIconSquared.setImageResource(R.mipmap.ic_action_speeding);
                    break;
            }
            return row;
        }
    }

    private Challenge[] CHALLENGES = {
            new Challenge(Challenge.ChallengeType.MAXSPEED, "Max Speed", "Details about it", 60),
            new Challenge(Challenge.ChallengeType.HARDBREAK, "Hard Break", "Details about it", 90),
            new Challenge(Challenge.ChallengeType.HARDCURVE, "Hard Curve", "Details about it", 30)
    };
}
