package edu.depaul.csc595.careapp.main_fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import edu.depaul.csc595.careapp.ChallengeListActivity;
import edu.depaul.csc595.careapp.LeaderboardListActivity;
import edu.depaul.csc595.careapp.ListData.Card;
import edu.depaul.csc595.careapp.ListData.CardList;
import edu.depaul.csc595.careapp.ListData.GamesList;
import edu.depaul.csc595.careapp.QuizzActivity;
import edu.depaul.csc595.careapp.R;

public class GamesFragment extends Fragment {

    private ListView mList;
    private View view;

    public GamesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_games, container, false);

        mList = (ListView) view.findViewById(R.id.games_list);
        CardListAdapter adapter = new CardListAdapter(getContext(), new GamesList());

        mList.setAdapter(adapter);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(getActivity(), ChallengeListActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getActivity(), QuizzActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getActivity(), LeaderboardListActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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

    private static final Card[] GAME_CARD_ARRAY = {
            new Card(Card.Type.type_1,
                    "Challenge",
                    R.drawable.com_facebook_profile_picture_blank_square,
                    "Hard Curve",
                    "Complete 100 miles without make a hard curve",
                    "",
                    "",
                    30,
                    "30",
                    Card.ImgShape.rounded),

            new Card(Card.Type.type_1,
                    "Quizz",
                    R.drawable.com_facebook_profile_picture_blank_square,
                    "You have a new quizz!!",
                    "",
                    "",
                    "",
                    -1,
                    "",
                    Card.ImgShape.squared),

            new Card(Card.Type.type_1,
                    "Statistics",
                    R.drawable.com_facebook_profile_picture_blank_square,
                    "",
                    "See your progress in the game and general information about your trips.",
                    "",
                    "",
                    -1,
                    "",
                    Card.ImgShape.rounded)
    };
}
