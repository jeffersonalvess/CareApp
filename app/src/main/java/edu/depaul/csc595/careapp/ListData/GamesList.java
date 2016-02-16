package edu.depaul.csc595.careapp.ListData;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Miller on 15/02/2016.
 */
public class GamesList extends CardList {


    public GamesList(){
        for (Card card : PROFILES_ARRAY) {
            addItem(card);
        }
    }

    public static final Card[] PROFILES_ARRAY = {
            new Card(Card.Type.type_1,
                    "Challenge",
                    R.drawable.com_facebook_profile_picture_blank_square,
                    "Hard Curve",
                    "Complete 100 miles without make a hard curve",
                    "",
                    "",
                    30,
                    Card.ImgShape.rounded),

            new Card(Card.Type.type_1,
                    "Challenge",
                    R.drawable.com_facebook_profile_picture_blank_square,
                    "Hard Curve",
                    "Complete 100 miles without make a hard curve",
                    "",
                    "",
                    30,
                    Card.ImgShape.rounded),

            new Card(Card.Type.type_1,
                    "Quizz",
                    R.drawable.com_facebook_profile_picture_blank_square,
                    "You have a new quizz!!",
                    "",
                    "",
                    "",
                    -1,
                    Card.ImgShape.squared),

            new Card(Card.Type.type_1,
                    "Statistics",
                    R.drawable.com_facebook_profile_picture_blank_square,
                    "",
                    "See your progress in the game and general information about your trips.",
                    "",
                    "",
                    -1,
                    Card.ImgShape.rounded)
    };
}
