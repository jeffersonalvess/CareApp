package edu.depaul.csc595.careapp.ListData;

import edu.depaul.csc595.careapp.R;

/**
 * Created by jeffersonalvess on 2/24/16.
 */
public class AchievementsList extends CardList {

    public AchievementsList(){
        for (int i = 0; i < PROFILES_ARRAY.length; i++) {
            addItem(PROFILES_ARRAY[i]);
        }
    }

    public final Card[] PROFILES_ARRAY = {
            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_achievement_seven_days,
                    "Seven Days"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_achievement_social_king,
                    "Social King"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_achievement_the_popular,
                    "The Popular"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_achievement_the_best,
                    "The Best"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_achievement_cash,
                    "Cash"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_achievement_gas_saver,
                    "Gas Saver"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_achievement_a,
                    "A"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_profile_achievement,
                    "Neither Fast\nNeither Slow"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_profile_achievement,
                    "100mi Challenge"),
            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_profile_achievement,
                    "Speed Zen"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_profile_achievement,
                    "Soft Foot"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_profile_achievement,
                    "Neither Fast\nNeither Slow"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_profile_achievement,
                    "100mi Challenge"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_profile_achievement,
                    "Gas Saver"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_profile_achievement,
                    "3 days on 40"),

            new Card(Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_profile_achievement,
                    "Quiz Riddle"),

            new Card(
                    Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_profile_achievement,
                    "50 less"),

            new Card(
                    Card.Type.type_7,
                    Card.ImgShape.squared,
                    R.mipmap.ic_profile_achievement,
                    "Gas Saver")
    };
}
