package edu.depaul.csc595.careapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.depaul.csc595.careapp.ListData.Card;
import edu.depaul.csc595.careapp.ListData.ChallengesList;
import edu.depaul.csc595.careapp.ListData.FriendsList;
import edu.depaul.csc595.careapp.main_fragments.CardListAdapter;

public class FriendChallenge extends AppCompatActivity
{
    ListView mList;
    GridView mGrid;
    String friendName;
    int friendPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_challenge);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final CardListAdapter adapterFriends = new CardListAdapter(getApplicationContext(), new FriendsList());
        final CardListAdapter adapterChallenges = new CardListAdapter(getApplicationContext(), new ChallengesList());
        final ViewFlipper flipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        final Context context = this;

        mList = (ListView) findViewById(R.id.friends_list);
        mGrid = (GridView) findViewById(R.id.friends_challenges_grid);

        mList.setAdapter(adapterFriends);
        mGrid.setAdapter(adapterChallenges);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                //TODO: The Challenges Grid View should be done only after the click, because the challenges can change based on the friend selected.
                //TODO: Do not forget to move the code to here for the GridView to here.

                Card friend = (Card) adapterFriends.getItem(position);
                friendName = friend.getContentTitle();
                friendPicture = friend.getIcon();

                flipper.showNext();
            }
        });

        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Card challenge = (Card) adapterChallenges.getItem(position);

                final Dialog d = new Dialog(context);
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.setContentView(R.layout.list_item_type_2);

                TextView title = (TextView) d.findViewById(R.id.txtCardTitle);
                TextView contentTitle = (TextView) d.findViewById(R.id.txtContentTitle);
                TextView challengeDescription = (TextView) d.findViewById(R.id.txtDescription);
                TextView playerLeft = (TextView) d.findViewById(R.id.txtPlayerLeft);
                TextView playerRight = (TextView) d.findViewById(R.id.txtPlayerRight);
                TextView userOption = (TextView) d.findViewById(R.id.lbUserChosenOption);
                CircleImageView imgRoundedLeft = (CircleImageView) d.findViewById(R.id.imgRoundedLeft);
                CircleImageView imgRoundedRight = (CircleImageView) d.findViewById(R.id.imgRoundedRight);
                final Button btnAccept = (Button) d.findViewById(R.id.btnAccept);
                final Button btnReject = (Button) d.findViewById(R.id.btnReject);

                title.setText("Challenge " + friendName);
                contentTitle.setText(challenge.getContentTitle());
                challengeDescription.setText("You are challeging " + friendName + " to the " + challenge.getContentTitle().replace("\n", " ") + " challenge. Good luck!");
                playerLeft.setText("Jefferson Alves");
                playerRight.setText(friendName);

                imgRoundedLeft.setImageResource(R.drawable.ic_profile_jefferson);
                imgRoundedRight.setImageResource(friendPicture);

                btnAccept.setText("CANCEL");
                btnAccept.setTextColor(Color.RED);
                btnAccept.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        d.dismiss();
                    }
                });

                btnReject.setText("CHALLENGE");
                btnReject.setTextColor(getResources().getColor(R.color.colorGold));
                btnReject.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent = new Intent(FriendChallenge.this, MainActivity.class);
                        intent.putExtra("EXTRA_CHALLENGED", true);
                        intent.putExtra("EXTRA_FRIEND_NAME", friendName);
                        startActivity(intent);
                        finish();
                    }
                });

                d.show();
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        final ViewFlipper flipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        if (flipper.getDisplayedChild() == 1)
        {
            flipper.showPrevious();
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        final ViewFlipper flipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        if (item.getItemId() == android.R.id.home)
        {
            if (flipper.getDisplayedChild() == 1)
            {
                flipper.showPrevious();
            } else
            {
                finish();
            }

        }

        return true;
    }
}
