package edu.depaul.csc595.careapp.ListData;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Miller on 15/02/2016.
 */
public class GamesList extends CardList {


    public GamesList(){
        for (int i = 0; i < PROFILES_ARRAY.length; i++) {
            addItem(PROFILES_ARRAY[i]);
        }
    }

    public final Card[] PROFILES_ARRAY = {
            new Card(
                    Card.Type.type_1,
                    "Current Machine Challenge",
                    R.mipmap.ic_action_hard_break,
                    "Three Days hard break free",
                    "Hard Breaking is dangerous and one of the top accident related issues.",
                    "Try to not hard break for three consecutive days.",
                    "1000 reward points",
                    66,
                    "66%",
                    Card.ImgShape.squared),


            new Card(Card.Type.type_1,
                    "Quizz",
                    R.mipmap.ic_action_quiz,

                    "You have a new quizz",
                    "Answer quizzes to learn more about safe driving and to get more points.",
                    "Each quizz can give you more than 50 points",
                    "",
                    -1,
                    "",
                    Card.ImgShape.squared),


            new Card(Card.Type.type_1,
                    "Statistics",
                    R.mipmap.ic_action_statistics,
                    "",
                    "See your progress in the game and general information about your trips.",
                    "",
                    "",
                    -1,
                    "",
                    Card.ImgShape.squared)
    };
}
