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
import android.widget.ImageView;
import android.widget.TextView;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Lucas on 2/12/2016.
 */
public class LeaderboardList extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new LeaderboardAdapter());
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    class LeaderboardAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        @Override
        public int getCount() { return LEADERBOARDS.length; }

        @Override
        public Object getItem(int position) { return LEADERBOARDS[position]; }

        @Override
        public long getItemId(int position) { return position; }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;

            if(convertView == null) {
                if(inflater == null) {
                    inflater = (LayoutInflater) LeaderboardList.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                } row = inflater.inflate(R.layout.leaderboard_list_item, parent, false);
            }

            TextView textRank = (TextView) row.findViewById(R.id.leaderboardRank);
            ImageView imageProfile = (ImageView) row.findViewById(R.id.leaderboardImage);
            TextView textName = (TextView) row.findViewById(R.id.leaderboardName);
            TextView textPoints = (TextView) row.findViewById(R.id.leaderboardPoints);

            Leaderboard leaderboard = LEADERBOARDS[position];
            textRank.setText(Integer.toString(leaderboard.getRank()));
            textName.setText(leaderboard.getName());
            textPoints.setText(Integer.toString(leaderboard.getPoints()));

            switch (leaderboard.getimageString()) {
                case "LucasPhoto":
                    imageProfile.setImageResource(R.drawable.ic_action_hard_brake);
                break;

                case "RenatoPhoto":
                    imageProfile.setImageResource(R.drawable.ic_action_hard_curve);
                    break;

                case "MillerPhoto":
                    imageProfile.setImageResource(R.drawable.ic_action_speeding);
                    break;
            } return row;
        }
    }

    private Leaderboard[] LEADERBOARDS = {
            new Leaderboard(1, "LucasPhoto", "Lucas Nunes", 2500),
            new Leaderboard(2, "RenatoPhoto", "Renato Leonel", 2000),
            new Leaderboard(3, "MillerPhoto", "Miller Horvath", 1500)
    };
}
