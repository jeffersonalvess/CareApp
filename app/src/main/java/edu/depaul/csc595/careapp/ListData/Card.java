package edu.depaul.csc595.careapp.ListData;

import android.graphics.drawable.Icon;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Miller on 12/02/2016.
 */
public class Card {

    public enum Type {type_1, type_2, type_3, type_4, type_5, type_6, type_7, type_8, type_9, undefined}

    public enum ImgShape {rounded, squared, undefined}

    private Type type;
    private ImgShape imgShape;

    private int icon; //v
    private int progress; //v
    private int imgRoundedLeft; //v
    private int imgRoundedRight; //v
    private int imgSquaredLeft; //v
    private int imgSquaredRight; //v

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
    private String rewardStatus;

    private boolean btnAccept; //v
    private boolean btnReject; //v
    private boolean btnSaveOffer;
    private boolean btnGetOffer;

    /**
     * This constructor should be used when the card type is type_1
     * */


    Card(){
        this.type = Type.undefined;
        this.imgShape = ImgShape.undefined;

        this.icon = -1;
        this.progress = -1;

        this.title = "";
        this.contentTitle = "";
        this.line1 = "";
        this.line2 = "";
        this.line3 = "";
        this.progressText = "";

        this.imgRoundedLeft = -1;
        this.imgRoundedRight = -1;
        this.imgSquaredLeft = -1;
        this.imgSquaredRight = -1;

        this.challengeDescription = "";
        this.playerLeft = "";
        this.playerRight = "";
        this.userOption = "";
        this.rewardStatus = "";

        this.btnAccept = false;
        this.btnReject = false;
        this.btnSaveOffer = false;
        this.btnGetOffer = false;
    }

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
        this.imgSquaredLeft = -1;
        this.imgSquaredRight = -1;

        this.challengeDescription = "";
        this.playerLeft = "";
        this.playerRight = "";
        this.userOption = "";
        this.rewardStatus = "";

        this.btnAccept = false;
        this.btnReject = false;
        this.btnSaveOffer = false;
        this.btnGetOffer = false;

    }

    /**
     * This constructor should be used when the card type is type_2
     * */
    public Card(Type type, int imgRoundedLeft, int imgRoundedRight, String title, String contentTitle, String challengeDescription,
                String playerLeft, String playerRight, String userOption, boolean btnAccept, boolean btnReject )
    {
        this.type = type;
        this.imgShape = ImgShape.undefined;

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

        this.icon = -1;
        this.progress = -1;
        this.imgSquaredLeft = -1;
        this.imgSquaredRight = -1;

        this.line1 = "";
        this.line2 = "";
        this.line3 = "";
        this.progressText = "";
        this.rewardStatus = "";

        this.btnSaveOffer = false;
        this.btnGetOffer = false;

    }

    /**
     * This constructor should be used with type_3 card
     * */
    public Card(Type type, int imgSquaredLeft, int imgSquaredRight, String title, String contentTitle, String line1, String line2, String line3)
    {
        this.type = type;
        this.imgSquaredLeft = imgSquaredLeft;
        this.imgSquaredRight = imgSquaredRight;
        this.title = title;
        this.contentTitle = contentTitle;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;

        this.type = type;
        this.imgShape = ImgShape.undefined;

        this.imgRoundedLeft = -1;
        this.imgRoundedRight = -1;
        this.icon = -1;
        this.progress = -1;

        this.challengeDescription = "";
        this.playerLeft = "";
        this.playerRight = "";
        this.userOption = "";
        this.progressText = "";
        this.rewardStatus = "";

        this.btnAccept = false;
        this.btnReject = false;
        this.btnSaveOffer = false;
        this.btnGetOffer = false;
    }

    /**
     * This constructor should be used with type_4 card
     * */
    public Card(Type type, ImgShape imgShape, int icon, String title, String contentTitle, String line1)
    {
        this.type = type;
        this.imgShape = imgShape;
        this.icon = icon;
        this.title = title;
        this.contentTitle = contentTitle;
        this.line1 = line1;

        this.imgSquaredLeft = -1;
        this.imgSquaredRight = -1;
        this.line2 = "";
        this.line3 = "";
        this.rewardStatus = "";

        this.imgRoundedLeft = -1;
        this.imgRoundedRight = -1;

        this.progress = -1;

        this.challengeDescription = "";
        this.playerLeft = "";
        this.playerRight = "";
        this.userOption = "";
        this.progressText = "";

        this.btnAccept = false;
        this.btnReject = false;
        this.btnSaveOffer = false;
        this.btnGetOffer = false;

    }

    /**
     * This constructor should be used with type_5*/
    public Card(Type type, int icon, String title, String contentTitle, String line1, int progress, String progressText, String rewardStatus, boolean btnSaveOffer, boolean btnGetOffer)
    {
        this.type = type;
        this.icon = icon;
        this.contentTitle = contentTitle;
        this.line1 = line1;
        this.progressText = progressText;
        this.progress = progress;
        this.rewardStatus = rewardStatus;
        this.btnSaveOffer = btnSaveOffer;
        this.btnGetOffer = btnGetOffer;
        this.title = title;
        this.imgShape = ImgShape.squared;

        this.imgSquaredLeft = -1;
        this.imgSquaredRight = -1;
        this.line2 = "";
        this.line3 = "";

        this.imgRoundedLeft = -1;
        this.imgRoundedRight = -1;

        this.challengeDescription = "";
        this.playerLeft = "";
        this.playerRight = "";
        this.userOption = "";

        this.btnSaveOffer = btnSaveOffer;
        this.btnGetOffer = btnGetOffer;

    }

    /**
     * This constructor should be used with type_6 card
     * */
    public Card(Type type, ImgShape imgShape, int icon, String contentTitle, String line1)
    {
        this.type = type;
        this.imgShape = imgShape;
        this.icon = icon;
        this.line1 = line1;
        this.contentTitle = contentTitle;

        this.imgSquaredLeft = -1;
        this.imgSquaredRight = -1;
        this.line2 = "";
        this.line3 = "";
        this.rewardStatus = "";

        this.imgRoundedLeft = -1;
        this.imgRoundedRight = -1;

        this.progress = -1;

        this.challengeDescription = "";
        this.playerLeft = "";
        this.playerRight = "";
        this.userOption = "";
        this.progressText = "";

        this.title = "";

        this.btnAccept = false;
        this.btnReject = false;
        this.btnSaveOffer = false;
        this.btnGetOffer = false;

    }

    /**
     * This constructor should be used with type_7 card
     * */
    public Card(Type type, ImgShape imgShape, int icon, String contentTitle)
    {
        this.type = type;
        this.imgShape = imgShape;
        this.line1 = "";
        this.icon = icon;
        this.contentTitle = contentTitle;

        this.imgSquaredLeft = -1;
        this.imgSquaredRight = -1;
        this.line2 = "";
        this.line3 = "";
        this.rewardStatus = "";

        this.imgRoundedLeft = -1;
        this.imgRoundedRight = -1;

        this.progress = -1;

        this.challengeDescription = "";
        this.playerLeft = "";
        this.playerRight = "";
        this.userOption = "";
        this.progressText = "";

        this.title = "";

        this.btnAccept = false;
        this.btnReject = false;
        this.btnSaveOffer = false;
        this.btnGetOffer = false;

    }

    /**
     * This constructor should be used with type_8 card
     * */
    public Card(Type type, int imageIcon, String contentTitle, String line1)
    {
        this.type = type;
        this.icon = imageIcon;
        this.line1 = line1;
        this.contentTitle = contentTitle;
        this.imgShape = ImgShape.squared;


        this.imgRoundedLeft = -1;
        this.line2 = "";
        this.imgSquaredLeft = -1;
        this.imgSquaredRight = -1;
        this.line3 = "";
        this.rewardStatus = "";


        this.imgRoundedRight = -1;
        this.progress = -1;

        this.challengeDescription = "";
        this.playerLeft = "";
        this.playerRight = "";
        this.userOption = "";
        this.progressText = "";

        this.title = "";

        this.btnAccept = false;
        this.btnReject = false;
        this.btnSaveOffer = false;
        this.btnGetOffer = false;
    }

    /**
     * This constructor should be used with type_9 card
     * */
    public Card(Type type, int imgRoundedLeft, String line1, String line2, String contentTitle)
    {
        this.type = type;
        this.imgRoundedLeft = imgRoundedLeft;
        this.line1 = line1;
        this.line2 = line2;
        this.contentTitle = contentTitle;


        this.imgShape = ImgShape.undefined;
        this.icon = -1;
        this.imgSquaredLeft = -1;
        this.imgSquaredRight = -1;
        this.line3 = "";
        this.rewardStatus = "";


        this.imgRoundedRight = -1;
        this.progress = -1;

        this.challengeDescription = "";
        this.playerLeft = "";
        this.playerRight = "";
        this.userOption = "";
        this.progressText = "";

        this.title = "";

        this.btnAccept = false;
        this.btnReject = false;
        this.btnSaveOffer = false;
        this.btnGetOffer = false;
    }


    public String getRewardStatus()
    {
        return rewardStatus;
    }

    public void setRewardStatus(String rewardStatus)
    {
        this.rewardStatus = rewardStatus;
    }

    public boolean isBtnSaveOffer()
    {
        return btnSaveOffer;
    }

    public void setBtnSaveOffer(boolean btnSaveOffer)
    {
        this.btnSaveOffer = btnSaveOffer;
    }

    public boolean isBtnGetOffer()
    {
        return btnGetOffer;
    }

    public void setBtnGetOffer(boolean btnGetOffer)
    {
        this.btnGetOffer = btnGetOffer;
    }

    public int getImgSquaredLeft()
    {
        return imgSquaredLeft;
    }

    public void setImgSquaredLeft(int imgSquaredLeft)
    {
        this.imgSquaredLeft = imgSquaredLeft;
    }

    public int getImgSquaredRight()
    {
        return imgSquaredRight;
    }

    public void setImgSquaredRight(int imgSquaredRight)
    {
        this.imgSquaredRight = imgSquaredRight;
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
