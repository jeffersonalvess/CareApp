package edu.depaul.csc595.careapp.main_fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import edu.depaul.csc595.careapp.ListData.AchievementsList;
import edu.depaul.csc595.careapp.ListData.ProfileList;
import edu.depaul.csc595.careapp.R;


public class AchievementsFragment extends Fragment {

    private GridView mGrid;
    private View view;

    public AchievementsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_achievements, container, false);

        mGrid = (GridView) view.findViewById(R.id.achievements_grid);

        CardListAdapter adapter = new CardListAdapter(getContext(), new AchievementsList());

        mGrid.setAdapter(adapter);

        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
                Snackbar.make(view, "I'm so proud of you.", Snackbar.LENGTH_SHORT).show();
            }
        });

        return view;

    }
}
