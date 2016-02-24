package edu.depaul.csc595.careapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import edu.depaul.csc595.careapp.ListData.Card;
import edu.depaul.csc595.careapp.ListData.FriendsList;
import edu.depaul.csc595.careapp.main_fragments.CardListAdapter;

public class FriendChallenge extends AppCompatActivity
{
    ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_challenge);

        final CardListAdapter adapter = new CardListAdapter(getApplicationContext(), new FriendsList());

        mList = (ListView) findViewById(R.id.friends_list);
        mList.setAdapter(adapter);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Card c = (Card) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), c.getContentTitle(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
