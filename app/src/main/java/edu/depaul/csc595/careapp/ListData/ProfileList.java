package edu.depaul.csc595.careapp.ListData;

import java.util.Random;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Miller on 15/02/2016.
 */
public class ProfileList extends CardList {

    public ProfileList()
    {
        Random random = new Random();

            addItem(new Card(
                    Card.Type.type_3,
                    -1,
                    R.mipmap.ic_action_speeding,
                    "Did you know?",
                    "",
                    "70% of the of the righways accidents with fatal victms are cause by speeding excess.",
                    "You don't wanna be remembred by those statistics. Right?",
                    ""));

        addItem(new Card(
                Card.Type.type_1,
                "Current Machine Challenge",
                R.mipmap.ic_action_hard_break,
                "Three Days hard break free",
                "Hard Breaking is dangerous and one of the top accident related issues.",
                "Try to not hard break for three consecutive days.",
                "1000 reward points",
                66,
                Card.ImgShape.squared));

        addItem(new Card(
                Card.Type.type_4,
                Card.ImgShape.squared,
                R.drawable.com_facebook_profile_picture_blank_square,
                "",
                "",
                "Your Facebook friend Lucas Barbosa joined Care."
        ));

        addItem(new Card(
                Card.Type.type_2,
                R.drawable.com_facebook_profile_picture_blank_square,
                R.drawable.com_facebook_profile_picture_blank_square,
                "Friend Challenge",
                "100 Miles Challenge",
                "Drive 100 miles without hardbreaking.",
                "You",
                "Renato",
                "",
                true,
                true));

        addItem(new Card(
                Card.Type.type_4,
                Card.ImgShape.squared,
                R.mipmap.ic_action_hard_curve,
                "Rewards",
                "",
                "There are new options available to redeem your rewards points."
        ));

        addItem(new Card(
                Card.Type.type_4,
                Card.ImgShape.squared,
                R.mipmap.ic_hard_brake,
                "",
                "",
                "Green, yellow, STOP. A car crash can cause irreparable damages to your car."
        ));

        addItem(new Card(
                Card.Type.type_2,
                R.drawable.com_facebook_profile_picture_blank_square,
                R.drawable.com_facebook_profile_picture_blank_square,
                "Friend Challenge",
                "Drivewise",
                "Mark 1000 points on Drivewise mode, the first to accomplish the points wil be the winner.",
                "You",
                "Matheus",
                "",
                true,
                true));
    }
}
