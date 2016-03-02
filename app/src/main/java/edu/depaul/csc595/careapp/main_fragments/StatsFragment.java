package edu.depaul.csc595.careapp.main_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.AccessToken;

import java.util.concurrent.ExecutionException;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.depaul.csc595.careapp.Design.OurCircleImageView;
import edu.depaul.csc595.careapp.Helpers.FacebookImageLoadTask;
import edu.depaul.csc595.careapp.Helpers.FacebookUserProfileInfo;
import edu.depaul.csc595.careapp.Helpers.FacebookUserInfo;
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


        view = inflater.inflate(R.layout.fragment_stats, container, false);

        final OurCircleImageView profilePicture = (OurCircleImageView) view.findViewById(R.id.userProfilePicture);
        final TextView profileName = (TextView) view.findViewById(R.id.profileName);

        try
        {
            FacebookUserInfo f = new FacebookUserProfileInfo(getContext(), AccessToken.getCurrentAccessToken()).execute().get();

            profileName.setText(f.getUserName());
            profilePicture.setImageBitmap(f.getUserPicture());

        } catch (ExecutionException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }


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


