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

import edu.depaul.csc595.careapp.ListData.Card;
import edu.depaul.csc595.careapp.ListData.CardList;
import edu.depaul.csc595.careapp.R;

// Card List Custom Adapter
public class CardListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private final Context context;
    CardList cardList;

    public CardListAdapter(Context context, CardList cardList) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.cardList = cardList;
    }

    @Override
    public int getCount() { return cardList.PROFILES.size(); }

    @Override
    public Object getItem(int position) { return cardList.PROFILES.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View row = convertView;

        Card card = cardList.PROFILES.get(position);

        if (row == null) {
            if(card.getType() == Card.Type.type_1) {
                row = inflater.inflate(R.layout.list_item_type_1, parent, false);
            }
            else{
                row = inflater.inflate(R.layout.list_item_type_2, parent, false);
            }

            holder = new ViewHolder();

            if(card.getType() == Card.Type.type_1){
                holder.iconRounded = (ImageView) row.findViewById(R.id.imgCardIconRounded);
                holder.iconSquared = (ImageView) row.findViewById(R.id.imgCardIconSquared);
                holder.title = (TextView) row.findViewById(R.id.txtCardTitle);
                holder.contentTitle = (TextView) row.findViewById(R.id.txtContentTitle);
                holder.line1 = (TextView) row.findViewById(R.id.txtLine1);
                holder.line2 = (TextView) row.findViewById(R.id.txtLine2);
                holder.line3 = (TextView) row.findViewById(R.id.txtLine3);
                holder.progressBar = (ProgressBar) row.findViewById(R.id.progressBar);
                holder.progressTxt = (TextView) row.findViewById(R.id.txtProgress);
            }

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        if(card.getIcon() != -1) {
            if(card.getImgShape() == Card.ImgShape.rounded) {
                holder.iconRounded.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), card.getIcon()));
            }
            else{
                holder.iconSquared.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), card.getIcon()));
                holder.iconRounded.setVisibility(View.GONE);
                holder.iconSquared.setVisibility(View.VISIBLE);
            }
        }
        else{
            holder.iconRounded.setVisibility(View.GONE);
            holder.iconSquared.setVisibility(View.GONE);
        }

        holder.title.setText(card.getTitle());

        if(card.getContentTitle().matches("")){
            holder.contentTitle.setVisibility(View.GONE);
        }
        else{
            holder.contentTitle.setText(card.getContentTitle());
        }

        if(card.getLine1().matches("")){
            holder.line1.setVisibility(View.GONE);
        }
        else{
            holder.line1.setText(card.getLine1());
        }

        if(card.getLine2().matches("")){
            holder.line2.setVisibility(View.GONE);
        }
        else{
            holder.line2.setText(card.getLine2());
        }

        if(card.getLine3().matches("")){
            holder.line3.setVisibility(View.GONE);
        }
        else{
            holder.line3.setText(card.getLine3());
        }

        if(card.getProgress() != -1){
            holder.progressBar.setProgress(card.getProgress());
            holder.progressTxt.setText(card.getProgress() + "%");
        }
        else{
            holder.progressTxt.setVisibility(View.GONE);
            holder.progressBar.setVisibility(View.GONE);
        }

        return row;
    }

    static class ViewHolder {
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