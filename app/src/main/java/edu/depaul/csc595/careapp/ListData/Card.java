package edu.depaul.csc595.careapp.ListData;

import android.graphics.drawable.Icon;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Miller on 12/02/2016.
 */
public class Card {

    public enum Type {type_1, type_2, type_3, type_4, type_5}

    public enum ImgShape {rounded, squared, undefined}

    private Type type;
    private ImgShape imgShape;

    private int icon; //v
    private int progress; //v
    private int imgRoundedLeft; //v
    private int imgRoundedRight; //v

    private String title; //v
    private String contentTitle; //v
    private String line1; //v
    private String line2; //v
    private String line3; //v
    private String progressText; //v
    private String challengeDescription; //v
    private String playerLeft; //v
    private String playerRight; //v
    private String userOption; //v

    private boolean btnAccept; //v
    private boolean btnReject; //v


    /** This constructor should be used when the card type is type_1 */
    public Card(Type type, String title, int icon, String contentTitle, String line1, String line2, String line3, int progress, String progressText, ImgShape imgShape) {

        this.type = type;
        this.imgShape = imgShape;

        this.icon = icon;
        this.progress = progress;

        this.title = title;
        this.contentTitle = contentTitle;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.progressText = progressText;

        this.imgRoundedLeft = -1;
        this.imgRoundedRight = -1;

        this.challengeDescription = "";
        this.playerLeft = "";
        this.playerRight = "";
        this.userOption = "";

        this.btnAccept = false;
        this.btnReject = false;

    }

    /** This constructor should be used when the card type is type_2 */
    public Card(Type type, int imgRoundedLeft, int imgRoundedRight, String title, String contentTitle, String challengeDescription,
                String playerLeft, String playerRight, String userOption, boolean btnAccept, boolean btnReject )
    {
        this.type = type;

        this.imgRoundedLeft = imgRoundedLeft;
        this.imgRoundedRight = imgRoundedRight;

        this.title = title;
        this.contentTitle = contentTitle;
        this.challengeDescription = challengeDescription;
        this.playerLeft = playerLeft;
        this.playerRight = playerRight;
        this.userOption = userOption;

        this.btnAccept = btnAccept;
        this.btnReject = btnReject;

        this.imgShape = ImgShape.undefined;

        this.icon = -1;
        this.progress = -1;

        this.line1 = "";
        this.line2 = "";
        this.line3 = "";
        this.progressText = "";

    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public int getImgRoundedLeft()
    {
        return imgRoundedLeft;
    }

    public void setImgRoundedLeft(int imgRoundedLeft)
    {
        this.imgRoundedLeft = imgRoundedLeft;
    }

    public int getImgRoundedRight()
    {
        return imgRoundedRight;
    }

    public void setImgRoundedRight(int imgRoundedRight)
    {
        this.imgRoundedRight = imgRoundedRight;
    }

    public String getChallengeDescription()
    {
        return challengeDescription;
    }

    public void setChallengeDescription(String challengeChallengeDescription)
    {
        this.challengeDescription = challengeChallengeDescription;
    }

    public String getPlayerLeft()
    {
        return playerLeft;
    }

    public void setPlayerLeft(String playerLeft)
    {
        this.playerLeft = playerLeft;
    }

    public String getPlayerRight()
    {
        return playerRight;
    }

    public void setPlayerRight(String playerRight)
    {
        this.playerRight = playerRight;
    }

    public String getUserOption()
    {
        return userOption;
    }

    public void setUserOption(String userOption)
    {
        this.userOption = userOption;
    }

    public boolean isBtnAccept()
    {
        return btnAccept;
    }

    public void setBtnAccept(boolean btnAccept)
    {
        this.btnAccept = btnAccept;
    }

    public boolean isBtnReject()
    {
        return btnReject;
    }

    public void setBtnReject(boolean btnReject)
    {
        this.btnReject = btnReject;
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
