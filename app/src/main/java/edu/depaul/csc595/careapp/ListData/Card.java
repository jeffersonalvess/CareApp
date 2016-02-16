package edu.depaul.csc595.careapp.ListData;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Miller on 12/02/2016.
 */
public class Card {

    public static enum Type {type_1, type_2, type_3, type_4, type_5}

    String name;
    String shortDescription;
    String longDescription;
    Type type;

    public Card(Type type, String name, String shortDescription, String longDescription) {
        this.type = type;
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public Type getType(){ return type; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String toString() {
        return name;
    }

    public static int getIconResource() {
        return R.drawable.com_facebook_profile_picture_blank_square;
    }

}
