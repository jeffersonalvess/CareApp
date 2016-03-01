package edu.depaul.csc595.careapp.Design;


import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Miller on 22/02/2016.
 */

/**
 * Class used to show a determinate progress indicator.
 * Two display modes are supported "wheel" and "pie"
 */
public class CircularProgressBar extends View {
    private final RectF mRect = new RectF();
    private final RectF mRectInner = new RectF();
    private final Paint mPaintForeground = new Paint();
    private final Paint mPaintBackground = new Paint();
    private final Paint mPaintErase = new Paint();
    private static final Xfermode PORTER_DUFF_CLEAR = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    private int mColorForeground = ContextCompat.getColor(getContext(), R.color.background_material_light);
    private int mColorBackground;
    private final int []COLORS = {
            ContextCompat.getColor(getContext(), R.color.RED),
            ContextCompat.getColor(getContext(), R.color.YELLOW),
            ContextCompat.getColor(getContext(), R.color.GREEN)
    };
    private float mValue;
    private boolean mPieStyle;
    /**
     * Value which makes our custom drawn indicator have roughly the same size
     * as the built-in ProgressBar indicator. Unit: dp
     */
    private static final float PADDING = 4;
    private float mPadding;
    private Bitmap mBitmap;
    /**
     * Value which makes our custom drawn indicator have roughly the same
     * thickness as the built-in ProgressBar indicator. Expressed as the ration
     * between the inner and outer radiuses
     */
    private static final float INNER_RADIUS_RATIO = 0.84f;

    public CircularProgressBar(Context context) {
        this(context, null);
    }

    @Override
    public void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        if(width < height){
            setMeasuredDimension(width, width);
        }
        else{
            setMeasuredDimension(height, height);
        }
    }

    public CircularProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        Resources r = context.getResources();

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CircularProgressBar);
        mValue = ta.getFloat(R.styleable.CircularProgressBar_progress, 50.0f);

        if(mValue < 33.33f){
            mColorBackground = COLORS[2];
        }
        else if(mValue < 66.66f){
            mColorBackground = COLORS[1];
        }
        else{
            mColorBackground = COLORS[0];
        }

        float scale = r.getDisplayMetrics().density;
        mPadding = scale * PADDING ;
        mPaintForeground.setColor(mColorForeground);
        mPaintForeground.setAntiAlias(true);
        mPaintBackground.setColor(mColorBackground);
        mPaintBackground.setAntiAlias(true);
        mPaintErase.setXfermode(PORTER_DUFF_CLEAR);
        mPaintErase.setAntiAlias(true);


        //mValue = 50;
    }

    /**
     * Set the style of this indicator.The two supported styles are "wheel" and "pie"
     * @param style One of {@link STYLE_WHEEL} or {@link STYLE_PIE}
     */
    public void setPieStyle(boolean pieStyle) {
        if (mPieStyle == pieStyle) {
            return;
        }
        mPieStyle = pieStyle;
        updateBitmap();
    }

    /**
     * Return the current style of this indicator.
     * @return <tt>True</tt> if the indicator has the "pie" style
     */
    public boolean getIsPieStyle() {
        return mPieStyle;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, getWidth() / 2 - mBitmap.getWidth() / 2,
                getHeight() / 2 - mBitmap.getHeight() / 2, null);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        float bitmapWidth = w - 2 * mPadding;
        float bitmapHeight = h - 2 * mPadding;
        float radius = Math.min(bitmapWidth / 2, bitmapHeight / 2);
        mRect.set(0, 0, bitmapWidth, bitmapHeight);
        radius *= INNER_RADIUS_RATIO;
        mRectInner.set(bitmapWidth / 2f - radius, bitmapHeight / 2f - radius, bitmapWidth / 2f + radius, bitmapHeight / 2f + radius);
        updateBitmap();
    }

    /**
     * Set the foreground color for this indicator. The foreground is the part
     * of the indicator that shows the actual progress
     */
    public void setForegroundColor(int color) {
        this.mColorForeground = color;
        mPaintForeground.setColor(color);
        invalidate();
    }

    /**
     * Set the background color for this indicator. The background is a dim and subtle
     * part of the indicator that appears below the actual progress
     */
    public void setBackgroundColor(int color) {
        this.mColorBackground = color;
        mPaintBackground.setColor(color);
        invalidate();
    }

    public int getBackgroundColor() {
        return this.mColorBackground;
    }

    /**
     * @param progress A number between 0 and 1
     */
    public synchronized void setProgress(float progress) {
        if(progress < 0.0f){
            progress = 0.0f;
        }
        else if(progress > 100.0f){
            progress = 100.0f;
        }
        else {
            mValue = progress;

            if(mValue < 33.33f){
                setBackgroundColor(COLORS[2]);
            }
            else if(mValue < 66.66f){
                setBackgroundColor(COLORS[1]);
            }
            else{
                setBackgroundColor(COLORS[0]);
            }
        }
        updateBitmap();
    }

    public float getProgress(){return mValue;}

    private void updateBitmap() {
        if (mRect == null || mRect.width() == 0) {
            return;
        }

        mBitmap = Bitmap.createBitmap((int) mRect.width(), (int) mRect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mBitmap);
        canvas.drawArc(mRect, 0, 270, true, mPaintBackground);
        if (mValue < 0.01f) {
            canvas.drawLine(mRect.width() / 2, mRect.height() / 2, mRect.width() / 2, 0, mPaintForeground);
        }
        float angle = (1 - mValue / 100) * 270;
        canvas.drawArc(mRect, 270, -angle, true, mPaintForeground);
        if (!mPieStyle) {
            canvas.drawArc(mRectInner, 0, 360, true, mPaintErase);
        }
        postInvalidate();
    }
}
