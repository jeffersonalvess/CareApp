package edu.depaul.csc595.careapp.Design;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Miller on 01/03/2016.
 */
public class OurImageView extends ImageView {

    private static final float PADDING = 4;
    private float mPadding;
    private static final float INNER_RADIUS_RATIO = 1.0f;

    public OurImageView(Context context) {
        super(context);

        Resources r = context.getResources();
        float scale = r.getDisplayMetrics().density;
        mPadding = scale * PADDING ;
    }

    public OurImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Resources r = context.getResources();
        float scale = r.getDisplayMetrics().density;
        mPadding = scale * PADDING ;
    }

    public OurImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Resources r = context.getResources();
        float scale = r.getDisplayMetrics().density;
        mPadding = scale * PADDING ;
    }

    public OurImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

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
    }
}
