package edu.depaul.csc595.careapp.main_fragments;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import edu.depaul.csc595.careapp.ListData.Profile;
import edu.depaul.csc595.careapp.ListData.ProfileList;
import edu.depaul.csc595.careapp.MainActivity;
import edu.depaul.csc595.careapp.R;

public class ProfileFragment extends Fragment {

    private ListView mList;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mList = (ListView) view.findViewById(R.id.profile_list);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GameListAdapter adapter = new GameListAdapter(getActivity());
        mList.setAdapter(adapter);
    }


    // Profile List Custom Adapter
    static class GameListAdapter extends BaseAdapter {

        private LayoutInflater inflater;
        private final Context context;

        public GameListAdapter(Context context) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.context = context;
        }

        @Override
        public int getCount() { return ProfileList.PROFILES.size(); }

        @Override
        public Object getItem(int position) { return ProfileList.PROFILES.get(position); }

        @Override
        public long getItemId(int position) { return position; }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            View row = convertView;
            if (row == null) {
                row = inflater.inflate(R.layout.game_list_item, parent, false);
                holder = new ViewHolder();
                holder.icon = (ImageView) row.findViewById(R.id.image);
                holder.name = (TextView) row.findViewById(R.id.text1);
                holder.description = (TextView) row.findViewById(R.id.text2);
                row.setTag(holder);
            } else {
                holder = (ViewHolder) row.getTag();
            }

            Profile profile = ProfileList.PROFILES.get(position);
            holder.name.setText(profile.getName());
            holder.description.setText(profile.getShortDescription());
            holder.icon.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), Profile.getIconResource()));
            return row;
        }

        static class ViewHolder {
            TextView name;
            TextView description;
            ImageView icon;
        }
    }
}
