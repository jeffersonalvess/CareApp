package edu.depaul.csc595.careapp.main_fragments;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

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

        ViewHolder holder;
        View row = convertView;

        Card card = cardList.PROFILES.get(position);

        if (row == null)
        {
            holder = new ViewHolder();

            switch (card.getType())
            {
                case type_1:
                    row = inflater.inflate(R.layout.list_item_type_1, parent, false);

                    holder.iconRounded = (ImageView) row.findViewById(R.id.imgCardIconRounded);
                    holder.iconSquared = (ImageView) row.findViewById(R.id.imgCardIconSquared);
                    holder.title = (TextView) row.findViewById(R.id.txtCardTitle);
                    holder.contentTitle = (TextView) row.findViewById(R.id.txtContentTitle);
                    holder.line1 = (TextView) row.findViewById(R.id.txtLine1);
                    holder.line2 = (TextView) row.findViewById(R.id.txtLine2);
                    holder.line3 = (TextView) row.findViewById(R.id.txtLine3);
                    holder.progressBar = (ProgressBar) row.findViewById(R.id.progressBar);
                    holder.progressTxt = (TextView) row.findViewById(R.id.txtProgress);

                    break;
                case type_2:
                    row = inflater.inflate(R.layout.list_item_type_2, parent, false);
                    break;
                case type_3:
                    row = inflater.inflate(R.layout.list_item_type_3, parent, false);
                    break;
                case type_4:
                    row = inflater.inflate(R.layout.list_item_type_4, parent, false);
                    break;
                case type_5:
                    row = inflater.inflate(R.layout.list_item_type_5, parent, false);
                    break;
                default:
                    holder = (ViewHolder) row.getTag();
                    break;
            }
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }


        //FirstStep Make AllViews as Visible
        switch (card.getType())
        {
            case type_1:
                holder.iconRounded.setVisibility(View.GONE);
                holder.iconSquared.setVisibility(View.GONE);
                holder.title.setVisibility(View.GONE);
                holder.contentTitle.setVisibility(View.GONE);
                holder.line1.setVisibility(View.GONE);
                holder.line2.setVisibility(View.GONE);
                holder.line3.setVisibility(View.GONE);
                holder.progressBar.setVisibility(View.GONE);
                holder.progressTxt.setVisibility(View.GONE);

                break;
            case type_2:
                row = inflater.inflate(R.layout.list_item_type_2, parent, false);
                break;
            case type_3:
                row = inflater.inflate(R.layout.list_item_type_3, parent, false);
                break;
            case type_4:
                row = inflater.inflate(R.layout.list_item_type_4, parent, false);
                break;
            case type_5:
                row = inflater.inflate(R.layout.list_item_type_5, parent, false);
                break;
            default:
                break;
        }


        //Now choose which elements will be showed and changed

        // INTEGER FIELDS
        if (card.getIcon() != -1)
        {
            if (card.getImgShape() == Card.ImgShape.rounded)
            {
                holder.iconRounded.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), card.getIcon()));
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
            holder.progressTxt.setText(card.getProgressText());
            holder.progressTxt.setVisibility(View.VISIBLE);
            holder.progressBar.setVisibility(View.VISIBLE);
        }

        //STRING FIELDS
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

        return row;
    }

    static class ViewHolder
    {
        TextView title;
        ImageView iconRounded;
        ImageView iconSquared;
        TextView contentTitle;
        TextView line1;
        TextView line2;
        TextView line3;
        ProgressBar progressBar;
        TextView progressTxt;
    }
}