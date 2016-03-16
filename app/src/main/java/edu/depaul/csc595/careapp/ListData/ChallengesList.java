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
                    R.mipmap.ic_challenge_keep_calm,
                    "Keep Calm"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_action_hard_break,
                    "Soft Break"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_achievement_a,
                    "'A' Grade"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_achievement_the_best,
                    "The Best"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_achievement_cash,
                    "Cash"),

            new Card(
                    Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_achievement_gas_saver,
                    "Gas Saver")
    };
}
