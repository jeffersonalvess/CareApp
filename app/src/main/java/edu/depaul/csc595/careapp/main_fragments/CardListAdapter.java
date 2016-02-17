package edu.depaul.csc595.careapp.main_fragments;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.depaul.csc595.careapp.ListData.Card;
import edu.depaul.csc595.careapp.ListData.CardList;
import edu.depaul.csc595.careapp.R;

// Card List Custom Adapter
public class CardListAdapter extends BaseAdapter
{

    private LayoutInflater inflater;
    private final Context context;
    CardList cardList;

    public CardListAdapter(Context context, CardList cardList)
    {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.cardList = cardList;
    }

    @Override
    public int getCount()
    {
        return cardList.PROFILES.size();
    }

    @Override
    public Object getItem(int position)
    {
        return cardList.PROFILES.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public int getViewTypeCount()
    {
        return 2;
    }

    @Override
    public int getItemViewType(int position)
    {
        return cardList.PROFILES.get(position).getType().ordinal();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> BEFORE EDIT THIS METHOD PLESE READ THIS <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        // There is a lot of code here, so I'll try to clarify the sections:
        // First I declare the variables that will be used inside this methods, please declare everything on the beginning
        // Second theres a switch statement which prepare the objects for each type of cards. Now there are 5 types.
        // Then I initialize all objects as gone to clean the list item and avoid errors later
        // Then there are a huge section with IF statements, this section looks if an element is not empty on the card list
        // If an item is not empty it will be filled on the list item

        // This can be problematic in the future once that some cards doesn't have the same elements neither the same pattern
        // Needs to test better to certify that it is working properly

        // In the if section notice that first we do all the int comparisons and them the strings ones
        // Please maintain this organization in the future to improve readability.

        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        ViewHolder holder = null;
        View row = convertView;

        Card card = cardList.PROFILES.get(position);

        if (row == null)
        {

            if (getItemViewType(position) == Card.Type.type_1.ordinal())
            {
                row = inflater.inflate(R.layout.list_item_type_1, parent, false);

                holder = new ViewHolder();

                holder.iconRounded = (CircleImageView) row.findViewById(R.id.imgCardIconRounded);
                holder.iconSquared = (ImageView) row.findViewById(R.id.imgCardIconSquared);
                holder.title = (TextView) row.findViewById(R.id.txtCardTitle);
                holder.contentTitle = (TextView) row.findViewById(R.id.txtContentTitle);
                holder.line1 = (TextView) row.findViewById(R.id.txtLine1);
                holder.line2 = (TextView) row.findViewById(R.id.txtLine2);
                holder.line3 = (TextView) row.findViewById(R.id.txtLine3);
                holder.progressBar = (ProgressBar) row.findViewById(R.id.progressBar);
                holder.progressTxt = (TextView) row.findViewById(R.id.txtProgress);
            }
             else if (getItemViewType(position) == Card.Type.type_2.ordinal())
            {
                row = inflater.inflate(R.layout.list_item_type_2, parent, false);

                holder = new ViewHolder();

                holder.title = (TextView) row.findViewById(R.id.txtCardTitle);
                holder.contentTitle = (TextView) row.findViewById(R.id.txtContentTitle);
                holder.challengeDescription = (TextView) row.findViewById(R.id.txtDescription);
                holder.playerLeft = (TextView) row.findViewById(R.id.txtPlayerLeft);
                holder.playerRight = (TextView) row.findViewById(R.id.txtPlayerRight);
                holder.userOption = (TextView) row.findViewById(R.id.lbUserChosenOption);
                holder.imgRoundedLeft = (CircleImageView) row.findViewById(R.id.imgRoundedLeft);
                holder.imgRoundedRight = (CircleImageView) row.findViewById(R.id.imgRoundedRight);
                holder.btnAccept = (Button) row.findViewById(R.id.btnAccept);
                holder.btnReject = (Button) row.findViewById(R.id.btnReject);

            }

            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }


        //FirstStep Make AllViews as Visible
        if (card.getType() == Card.Type.type_1)
        {
            holder.iconRounded.setVisibility(View.GONE);
            holder.iconSquared.setVisibility(View.GONE);
            holder.title.setVisibility(View.GONE);
            holder.contentTitle.setVisibility(View.GONE);
            holder.line1.setVisibility(View.GONE);
            holder.line2.setVisibility(View.GONE);
            holder.line3.setVisibility(View.GONE);
            holder.progressBar.setVisibility(View.GONE);
            holder.progressTxt.setVisibility(View.GONE);

        }
        else if (card.getType() == Card.Type.type_2)
        {
            holder.title.setVisibility(View.GONE);
            holder.contentTitle.setVisibility(View.GONE);
            holder.challengeDescription.setVisibility(View.GONE);
            holder.playerLeft.setVisibility(View.GONE);
            holder.playerRight.setVisibility(View.GONE);
            holder.userOption.setVisibility(View.GONE);
            holder.imgRoundedLeft.setVisibility(View.GONE);
            holder.imgRoundedRight.setVisibility(View.GONE);
            holder.btnAccept.setVisibility(View.GONE);
            holder.btnReject.setVisibility(View.GONE);
        }

        //Now choose which elements will be showed and changed

        // INTEGER FIELDS
        if (card.getIcon() != -1)
        {
            if (card.getImgShape() == Card.ImgShape.rounded)
            {
                holder.iconRounded.setImageResource(card.getIcon());
                holder.iconRounded.setVisibility(View.VISIBLE);
            }
            else
            {
                holder.iconSquared.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), card.getIcon()));
                holder.iconSquared.setVisibility(View.VISIBLE);
            }
        }

        if (card.getProgress() != -1)
        {
            holder.progressBar.setProgress(card.getProgress());
            holder.progressTxt.setText(Integer.toString(card.getProgress()).concat("%"));
            holder.progressTxt.setVisibility(View.VISIBLE);
            holder.progressBar.setVisibility(View.VISIBLE);
        }

        if (card.getImgRoundedLeft() != -1)
        {
            holder.imgRoundedLeft.setImageResource(card.getIcon());
            holder.imgRoundedLeft.setVisibility(View.VISIBLE);
        }

        if (card.getImgRoundedRight() != -1)
        {
            holder.imgRoundedRight.setImageResource(card.getIcon());
            holder.imgRoundedRight.setVisibility(View.VISIBLE);
        }

        // BOOLEAN FIELDS
        if (card.isBtnAccept() && card.isBtnReject())
        {
            holder.btnAccept.setVisibility(View.VISIBLE);
            holder.btnReject.setVisibility(View.VISIBLE);

            //TODO: Implement button actions
        }

        // STRING FIELDS
        if (!card.getTitle().matches(""))
        {
            holder.title.setVisibility(View.VISIBLE);
            holder.title.setText(card.getTitle());
        }

        if (!card.getContentTitle().matches(""))
        {
            holder.contentTitle.setVisibility(View.VISIBLE);
            holder.contentTitle.setText(card.getContentTitle());
        }

        if (!card.getLine1().matches(""))
        {
            holder.line1.setVisibility(View.VISIBLE);
            holder.line1.setText(card.getLine1());
        }

        if (!card.getLine2().matches(""))
        {
            holder.line2.setVisibility(View.VISIBLE);
            holder.line2.setText(card.getLine2());
        }

        if (!card.getLine3().matches(""))
        {
            holder.line3.setVisibility(View.VISIBLE);
            holder.line3.setText(card.getLine3());
        }

        if (!card.getChallengeDescription().matches(""))
        {
            holder.challengeDescription.setVisibility(View.VISIBLE);
            holder.challengeDescription.setText(card.getChallengeDescription());
        }

        if (!card.getPlayerLeft().matches(""))
        {
            holder.playerLeft.setVisibility(View.VISIBLE);
            holder.playerLeft.setText(card.getPlayerLeft());
        }

        if (!card.getPlayerRight().matches(""))
        {
            holder.playerRight.setVisibility(View.VISIBLE);
            holder.playerRight.setText(card.getPlayerRight());
        }

        if (!card.getUserOption().matches("") && !(card.isBtnAccept() && card.isBtnReject()))
        {
            holder.userOption.setVisibility(View.VISIBLE);
            holder.userOption.setText(card.getUserOption());
        }

        return row;
    }

    static class ViewHolder
    {
        Button btnAccept;
        Button btnReject;

        TextView title;
        TextView playerLeft;
        TextView playerRight;
        TextView userOption;
        TextView contentTitle;
        TextView challengeDescription;
        TextView line1;
        TextView line2;
        TextView line3;
        TextView progressTxt;

        CircleImageView iconRounded;
        CircleImageView imgRoundedLeft;
        CircleImageView imgRoundedRight;

        ImageView iconSquared;

        ProgressBar progressBar;
    }
}