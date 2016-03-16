package edu.depaul.csc595.careapp.ListData;

import java.util.Random;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Miller on 15/02/2016.
 */
public class ProfileList extends CardList {

    public ProfileList()
    {

            addItem(new Card(
                    Card.Type.type_3,
                    -1,
                    R.mipmap.ic_action_tip,
                    "Did you know?",
                    "",
                    "Motor vehicle crashes are the leading cause of death for all 15- to 20-year-olds, " +
                            "according to the most recent data available (2009) from the National Center for " +
                            "Health Statistics.",
                    "",
                    ""));

        addItem(new Card(
                Card.Type.type_1,
                "Current Machine Challenge",
                R.mipmap.ic_action_hard_break,

                "Three Days hard break free",
                "Hard Breaking is dangerous and one of the top accident related issues.",
                "Try not to hard break for three consecutive days.",
                "1000 reward points",
                66,
                "66%",
                Card.ImgShape.squared));

        addItem(new Card(
                Card.Type.type_4,
                Card.ImgShape.rounded,
                R.drawable.ic_profile_lucas,
                "",
                "",
                "Your Facebook friend Lucas Barbosa joined Care."
        ));

        addItem(new Card(
                Card.Type.type_2,
                R.drawable.ic_profile_jefferson,
                R.drawable.ic_profile_renato,
                "Friend Challenge",
                "100 Miles Challenge",
                "Drive 100 miles without hardbreaking.",
                "You",
                "Renato",
                "",
                true,
                true));

            addItem(new Card(
                    Card.Type.type_3,
                    -1,
                    R.mipmap.ic_action_tip,
                    "Did you know?",
                    "",
                    "NHTSA estimates that helmets saved the lives of 1,699 motorcyclists of all ages in 2012, and " +
                            "that if all motorcyclists had worn helmets, an additional 781 lives could have been saved.",
                    "",
                    ""));

        addItem(new Card(
                Card.Type.type_4,
                Card.ImgShape.squared,
                R.mipmap.ic_action_splash_rewards,
                "Rewards",
                "",
                "There are new options available to redeem your rewards points."
        ));

            addItem(new Card(
                    Card.Type.type_4,
                    Card.ImgShape.rounded,
                    R.drawable.ic_profile_miller,
                    "",
                    "",
                    "Your Facebook friend Miller Horvath joined Care."
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
                R.drawable.ic_profile_jefferson,
                R.drawable.ic_profile_matheus,
                "Friend Challenge",
                "Drivewise",
                "Mark 1000 points on Drivewise mode, the first to accomplish the points will be the winner.",
                "You",
                "Matheus",
                "",
                true,
                true));

        addItem(new Card(
                Card.Type.type_5,
                R.mipmap.ic_action_splash_rewards,
                "Rewards Information",
                "Amazon GiftCard",
                "Change your points for an Amazon $50 Gift Card",
                51,
                "1253/2500",
                "",
                true,
                false
        ));
    }
}
