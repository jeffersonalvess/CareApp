package edu.depaul.csc595.careapp.Helpers;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;

public class FacebookUserInfo
{
    String userID;
    String userName;
    Bitmap userPicture;
    ArrayList<FacebookUserInfo> userFriends;

    public FacebookUserInfo()
    {
        userFriends = new ArrayList<>();
    }

    public void addUserFriends(FacebookUserInfo f)
    {
        userFriends.add(f);
    }

    public String getUserID()
    {
        return userID;
    }

    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Bitmap getUserPicture()
    {
        return userPicture;
    }

    public void setUserPicture(Bitmap userPicture)
    {
        this.userPicture = userPicture;
    }

    public ArrayList<FacebookUserInfo> getUserFriends()
    {
        return userFriends;
    }

    public void setUserFriends(ArrayList<FacebookUserInfo> userFriends)
    {
        this.userFriends = userFriends;
    }
}
