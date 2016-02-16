package edu.depaul.csc595.careapp.ListData;

import edu.depaul.csc595.careapp.R;

public class Challenge {
    public enum ChallengeType {MAXSPEED, HARDBREAK, HARDCURVE};
    private String title, details;
    private int challengeProgress;
    private ChallengeType type;

    public  Challenge(ChallengeType type, String title, String details, int challengeProgress) {
        this.type = type;
        this.title = title;
        this.details = details;
        this.challengeProgress = challengeProgress;
    }

    public static int getImageResource(ChallengeType type) {
        switch (type) {
            case MAXSPEED:
                return R.mipmap.ic_action_speeding;

            case HARDBREAK:
                return R.mipmap.ic_hard_brake;

            case HARDCURVE:
                return R.mipmap.ic_action_hard_curve;
        } return -1;
    }

    public ChallengeType getChallengeType() {
        return this.type;
    }

    public void setChallengeType(ChallengeType type) {
        this.type = type;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getChallengeProgress() {
        return this.challengeProgress;
    }

    public void setChallengeProgress(int challengeProgress) {
        this.challengeProgress = challengeProgress;
    }
}