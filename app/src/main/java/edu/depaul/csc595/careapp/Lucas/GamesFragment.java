package edu.depaul.csc595.careapp.Lucas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import edu.depaul.csc595.careapp.R;
import edu.depaul.csc595.careapp.TestActivity;

public class GamesFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_games, container, false);

        Button buttonQuizScreen = (Button) view.findViewById(R.id.buttonQuizScreen);
        buttonQuizScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuestionsViewer.class);
                startActivity(intent);
            }
        });

        Button buttonChallengeScreen = (Button) view.findViewById(R.id.buttonChallengeScreen);
        buttonChallengeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChallengeList.class);
                startActivity(intent);
            }
        });

        Button buttonLeaderboardScreen = (Button) view.findViewById(R.id.buttonLeaderboardScreen);
        buttonLeaderboardScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LeaderboardList.class);
                startActivity(intent);
            }
        });

        Button buttonTestActivity = (Button) view.findViewById(R.id.buttonTestActivity);
        buttonTestActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TestActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}