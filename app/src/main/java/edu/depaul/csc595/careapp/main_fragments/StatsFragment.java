package edu.depaul.csc595.careapp.main_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import edu.depaul.csc595.careapp.R;

public class StatsFragment extends Fragment {


    private ListView mList;
    private View view;

    public StatsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats, container, false);
//        view = inflater.inflate(R.layout.fragment_stats, container, fals//e//);
//
//        mList = (ListView) view.findViewById(R.id.stats_lis//t//);
//
//        CardListAdapter adapter = new CardListAdapter(getContext(), new StatsList(//)//);
//
//        mList.setAdapter(adapte//r//);
//
//        mList.setOnItemClickListener(new AdapterView.OnItemClickListener(//)// {
//
//            @Override public void onItemClick(AdapterView<?> arg0, View arg1,int position, long ar//g3)
//          //  {
//                Snackbar.make(view, "I can feel your finger on card " + position + ".", Snackbar.LENGTH_SHORT).show//();
//          //  }
//        //}//);
//
//        return view;
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


