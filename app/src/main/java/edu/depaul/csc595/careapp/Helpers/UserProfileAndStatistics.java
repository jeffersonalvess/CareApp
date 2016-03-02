package edu.depaul.csc595.careapp.Helpers;

import android.graphics.Bitmap;

import java.util.concurrent.ExecutionException;

/**
 * Created by jeffersonalvess on 3/2/16.
 */
public class UserProfileAndStatistics
{
    //TODO: Fix this class to support real values and the main achievements.

    String fbID;
    String fbName;
    Bitmap fbPicture;

    String averageSpeed;
    String averageInfractionsPerTrip;
    String averageInfractions100mi;
    String averageInfractions24h;

    String points;
    String friendChallenges;
    String achievements;
    String drivenMiles;
    String drivenTime;
    String quiz;

    public UserProfileAndStatistics(String fbID, String fbName, String averageSpeed, String averageInfractionsPerTrip, String averageInfractions100mi, String averageInfractions24h, String points, String friendChallenges, String achievements, String drivenMiles, String drivenTime, String quiz) throws ExecutionException, InterruptedException
    {

        fbPicture = new FacebookImageLoadTask(fbID).execute().get();
        this.fbID = fbID;
        this.fbName = fbName;
        this.averageSpeed = averageSpeed;
        this.averageInfractionsPerTrip = averageInfractionsPerTrip;
        this.averageInfractions100mi = averageInfractions100mi;
        this.averageInfractions24h = averageInfractions24h;
        this.points = points;
        this.friendChallenges = friendChallenges;
        this.achievements = achievements;
        this.drivenMiles = drivenMiles;
        this.drivenTime = drivenTime;
        this.quiz = quiz;
    }

    public String getFbID()
    {
        return fbID;
    }

    public void setFbID(String fbID)
    {
        this.fbID = fbID;
    }

    public String getFbName()
    {
        return fbName;
    }

    public void setFbName(String fbName)
    {
        this.fbName = fbName;
    }

    public Bitmap getFbPicture()
    {
        return fbPicture;
    }

    public void setFbPicture(Bitmap fbPicture)
    {
        this.fbPicture = fbPicture;
    }

    public String getAverageSpeed()
    {
        return averageSpeed;
    }

    public void setAverageSpeed(String averageSpeed)
    {
        this.averageSpeed = averageSpeed;
    }

    public String getAverageInfractionsPerTrip()
    {
        return averageInfractionsPerTrip;
    }

    public void setAverageInfractionsPerTrip(String averageInfractionsPerTrip)
    {
        this.averageInfractionsPerTrip = averageInfractionsPerTrip;
    }

    public String getAverageInfractions100mi()
    {
        return averageInfractions100mi;
    }

    public void setAverageInfractions100mi(String averageInfractions100mi)
    {
        this.averageInfractions100mi = averageInfractions100mi;
    }

    public String getAverageInfractions24h()
    {
        return averageInfractions24h;
    }

    public void setAverageInfractions24h(String averageInfractions24h)
    {
        this.averageInfractions24h = averageInfractions24h;
    }

    public String getPoints()
    {
        return points;
    }

    public void setPoints(String points)
    {
        this.points = points;
    }

    public String getFriendChallenges()
    {
        return friendChallenges;
    }

    public void setFriendChallenges(String friendChallenges)
    {
        this.friendChallenges = friendChallenges;
    }

    public String getAchievements()
    {
        return achievements;
    }

    public void setAchievements(String achievements)
    {
        this.achievements = achievements;
    }

    public String getDrivenMiles()
    {
        return drivenMiles;
    }

    public void setDrivenMiles(String drivenMiles)
    {
        this.drivenMiles = drivenMiles;
    }

    public String getDrivenTime()
    {
        return drivenTime;
    }

    public void setDrivenTime(String drivenTime)
    {
        this.drivenTime = drivenTime;
    }

    public String getQuiz()
    {
        return quiz;
    }

    public void setQuiz(String quiz)
    {
        this.quiz = quiz;
    }
}
