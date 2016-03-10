package edu.depaul.csc595.careapp.main_fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import edu.depaul.csc595.careapp.Design.OurCircleImageView;
import edu.depaul.csc595.careapp.MainActivity;
import edu.depaul.csc595.careapp.R;


public class StatsFragment extends Fragment {


    private ListView mList;
    private View view;
    Bitmap fbPicture = null;


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


        view = inflater.inflate(R.layout.fragment_stats, container, false);

        final OurCircleImageView profilePicture = (OurCircleImageView) view.findViewById(R.id.userProfilePicture);
        final TextView profileName = (TextView) view.findViewById(R.id.profileName);

        //FacebookUserInfo f = new FacebookUserProfileInfo(getContext(), AccessToken.getCurrentAccessToken()).execute().get();

        fbPicture = MainActivity.f.getUserPicture();
        profileName.setText(MainActivity.f.getUserName());
        profilePicture.setImageBitmap(fbPicture);

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
}


