package edu.depaul.csc595.careapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import edu.depaul.csc595.careapp.ListData.Leaderboard;

public class LeaderboardListActivity extends AppCompatActivity {

    private ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        LeaderboardAdapter adapter = new LeaderboardAdapter();

        mList = (ListView) findViewById(R.id.leaderboard_list);
        mList.setAdapter(adapter);
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
                    inflater = (LayoutInflater) LeaderboardListActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                } row = inflater.inflate(R.layout.leaderboard_list_item, parent, false);
            }

            TextView textRank = (TextView) row.findViewById(R.id.leaderboardRank);
            //ImageView imageTrophy = (ImageView) row.findViewById(R.id.reward);
            ImageView imageProfile = (ImageView) row.findViewById(R.id.leaderboardImage);
            TextView textName = (TextView) row.findViewById(R.id.leaderboardName);
            TextView textPoints = (TextView) row.findViewById(R.id.leaderboardPoints);

            Leaderboard leaderboard = LEADERBOARDS[position];
            textRank.setText(Integer.toString(leaderboard.getRank()));
            textName.setText(leaderboard.getName());
            textPoints.setText(Integer.toString(leaderboard.getPoints()));
            //imageTrophy.setImageResource(R.drawable.ic_action_trophy);


            switch (leaderboard.getimageString()) {
                case "LucasPhoto":
                    //imageProfile.setImageResource(R.drawable.ic_action_hard_brake);
                    break;

                case "RenatoPhoto":
                    // imageProfile.setImageResource(R.drawable.ic_action_hard_curve);
                    break;

                case "MillerPhoto":
                    //imageProfile.setImageResource(R.drawable.ic_action_speeding);
                    break;
            } return row;
        }
    }

    private Leaderboard[] LEADERBOARDS = {
            new Leaderboard(1, "MillerPhoto", "Miller Horvath", 28350),
            new Leaderboard(2, "LucasPhoto", "Lucas Nunes", 2500),
            new Leaderboard(3, "RenatoPhoto", "Renato Leonel", 2000)
    };

}
