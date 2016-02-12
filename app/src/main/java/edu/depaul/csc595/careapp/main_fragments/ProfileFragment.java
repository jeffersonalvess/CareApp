package edu.depaul.csc595.careapp.main_fragments;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import edu.depaul.csc595.careapp.ListData.Card;
import edu.depaul.csc595.careapp.ListData.CardList;
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
        CardListAdapter adapter = new CardListAdapter(getActivity());
        mList.setAdapter(adapter);
    }


    // Card List Custom Adapter
    static class CardListAdapter extends BaseAdapter {

        private LayoutInflater inflater;
        private final Context context;

        public CardListAdapter(Context context) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.context = context;
        }

        @Override
        public int getCount() { return CardList.PROFILES.size(); }

        @Override
        public Object getItem(int position) { return CardList.PROFILES.get(position); }

        @Override
        public long getItemId(int position) { return position; }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            View row = convertView;


            Card card = CardList.PROFILES.get(position);

            if (row == null) {
                if(card.getType() == Card.Type.type_1) {
                    row = inflater.inflate(R.layout.list_item_type_1, parent, false);
                }
                else{
                    row = inflater.inflate(R.layout.list_item_type_2, parent, false);
                }
                holder = new ViewHolder();
                holder.icon = (ImageView) row.findViewById(R.id.imgCardIcon);
                holder.name = (TextView) row.findViewById(R.id.txtCardTitle);
                holder.description = (TextView) row.findViewById(R.id.txtLine1);
                row.setTag(holder);
            } else {
                holder = (ViewHolder) row.getTag();
            }

            holder.name.setText(card.getName());
            holder.description.setText(card.getShortDescription());
            holder.icon.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), Card.getIconResource()));
            return row;
        }

        static class ViewHolder {
            TextView name;
            TextView description;
            ImageView icon;
        }
    }
}
