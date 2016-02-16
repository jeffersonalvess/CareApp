package edu.depaul.csc595.careapp.ListData;

/**
 * Created by Lucas on 2/12/2016.
 */
public class Leaderboard {
    private int rank;
    private String imageString;
    private String name;
    private int points;

    public Leaderboard(int rank, String imageString, String name, int points) {
        this.rank = rank;
        this.imageString = imageString;
        this.name = name;
        this.points = points;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getimageString() {
        return this.imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
