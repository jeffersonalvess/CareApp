package edu.depaul.csc595.careapp.ListData;

import edu.depaul.csc595.careapp.R;

/**
 * Created by jeffersonalvess on 2/24/16.
 */
public class ChallengesList extends CardList {

    public ChallengesList(){
        for (int i = 0; i < PROFILES_ARRAY.length; i++) {
            addItem(PROFILES_ARRAY[i]);
        }
    }

    public final Card[] PROFILES_ARRAY = {
            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Speed Zen"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Soft Foot"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Neither Fast\nNeither Slow"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "100mi Challenge"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Speed Zen"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Soft Foot"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Neither Fast\nNeither Slow"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "100mi Challenge"),
            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Speed Zen"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Soft Foot"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Neither Fast\nNeither Slow"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "100mi Challenge"),
            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Speed Zen"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Soft Foot"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Neither Fast\nNeither Slow"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "100mi Challenge"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Gas Saver"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "3 days on 40"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Quiz Riddle"),

            new Card(
                    Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "50 less"),

            new Card(
                    Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.drawable.ic_friends_challenge,
                    "Gas Saver")
    };
}
