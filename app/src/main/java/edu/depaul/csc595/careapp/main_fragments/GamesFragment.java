package edu.depaul.csc595.careapp.main_fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import edu.depaul.csc595.careapp.ListData.GamesList;
import edu.depaul.csc595.careapp.R;
import edu.depaul.csc595.careapp.StatisticsActivity;
import edu.depaul.csc595.careapp.TestActivity;

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

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent intent;
                switch (position) {
                    case 1:
                        //intent = new Intent(getActivity(), QuizActivity.class);
                        intent = new Intent(getActivity(), TestActivity.class);
                        startActivityForResult(intent, 0);
                        break;
                    case 2:
                        intent = new Intent(getActivity(), StatisticsActivity.class);
                        startActivityForResult(intent, 0);
                        break;
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {
        if (requestCode == 0) {
            if (resultCode == 1) {
                Snackbar.make(view, "Quiz successfully answered!!", Snackbar.LENGTH_SHORT).show();
            }
        }
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
}
