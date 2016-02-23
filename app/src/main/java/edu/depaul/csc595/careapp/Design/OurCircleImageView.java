package edu.depaul.csc595.careapp.Design;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Miller on 23/02/2016.
 */
public class OurCircleImageView extends CircleImageView {

    private static final float PADDING = 4;
    private float mPadding;
    private static final float INNER_RADIUS_RATIO = 0.95f;

    public OurCircleImageView(Context context) {
        super(context);

        Resources r = context.getResources();
        float scale = r.getDisplayMetrics().density;
        mPadding = scale * PADDING ;
    }

    public OurCircleImageView(Context context, AttributeSet attrs){
        super(context, attrs);

        Resources r = context.getResources();
        float scale = r.getDisplayMetrics().density;
        mPadding = scale * PADDING ;
    }

    public OurCircleImageView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);

        Resources r = context.getResources();
        float scale = r.getDisplayMetrics().density;
        mPadding = scale * PADDING ;
    }

    @Override
    public void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        width = (int)(width - 2 * mPadding);
        height = (int)(height - 2 * mPadding);

        float size = Math.min(width, height);
        size *= INNER_RADIUS_RATIO;

        setMeasuredDimension((int)size, (int)size);

//        if(width < height){
//            setMeasuredDimension(width, width);
//        }
//        else{
//            setMeasuredDimension(height, height);
//        }
    }
}
