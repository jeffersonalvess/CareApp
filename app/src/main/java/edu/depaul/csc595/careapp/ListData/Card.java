package edu.depaul.csc595.careapp.ListData;

import android.graphics.drawable.Icon;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Miller on 12/02/2016.
 */
public class Card {

    public enum Type {type_1, type_2, type_3, type_4, type_5}

    public enum ImgShape {rounded, squared}

    private Type type;
    private String title;
    private int icon;
    private String contentTitle;
    private String line1;
    private String line2;
    private String line3;
    private int progress;
    private String progressText;
    private ImgShape imgShape;

    public Card(Type type, String title, int icon, String contentTitle, String line1, String line2, String line3, int progress, String progressText, ImgShape imgShape) {
        this.type = type;
        this.title = title;
        this.icon = icon;
        this.contentTitle = contentTitle;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.progress = progress;
        this.progressText = progressText;
        this.imgShape = imgShape;
    }

    public Type getType(){ return type; }

    public String getTitle(){return title;}

    public void setTitle(String title){this.title = title;}

    public int getIcon(){return icon;}

    public void setIcon(int icon){this.icon = icon;}

    public String getContentTitle(){return contentTitle;}

    public void setContentTitle(String contentTitle){this.contentTitle = contentTitle;}

    public String getLine1(){return line1;}

    public void setLine1(String line1){this.line1 = line1;}

    public String getLine2(){return line2;}

    public void setLine2(String line2){this.line2 = line2;}

    public String getLine3(){return line3;}

    public void setLine3(String title){this.line3 = line3;}

    public int getProgress(){return progress;}

    public void setProgress(int progress){this.progress = progress;}

    public void setProgressText(String progressText){this.progressText = progressText;}

    public String getProgressText(){return progressText;}

    public ImgShape getImgShape(){return imgShape;}

    public void setImgShape(ImgShape imgShape){this.imgShape = imgShape;}

    public String toString() {
        return title;
    }
}
