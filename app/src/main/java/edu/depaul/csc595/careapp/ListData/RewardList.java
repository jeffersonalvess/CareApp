package edu.depaul.csc595.careapp.ListData;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Miller on 17/02/2016.
 */
public class RewardList extends CardList {


    public RewardList(){
        for (int i = 0; i < PROFILES_ARRAY.length; i++) {
            addItem(PROFILES_ARRAY[i]);
        }
    }

    public final Card[] PROFILES_ARRAY = {
            new Card(
                    Card.Type.type_5,
                    R.mipmap.ic_action_splash_rewards,
                    "Reward 1",
                    "??? Subtitle 1 ???",
                    "Vai que ta quase",
                    97,
                    "97/100",
                    "",
                    false,
                    false),

            new Card(
                    Card.Type.type_5,
                    R.mipmap.ic_action_splash_rewards,
                    "Reward 2",
                    "??? Subtitle 2 ???",
                    "Boa, garotinho!",
                    100,
                    "1/1",
                    "",
                    false,
                    true),

            new Card(
                    Card.Type.type_5,
                    R.mipmap.ic_action_splash_rewards,
                    "Reward 3",
                    "??? Subtitle 3 ???",
                    "Aeewwww !!!",
                    100,
                    "999999999/999999999",
                    "Pra que serve isso?",
                    true,
                    false),

            new Card(
                    Card.Type.type_5,
                    R.mipmap.ic_action_splash_rewards,
                    "Reward 4",
                    "??? Subtitle 4 ???",
                    "Shiiii... Ta longe. :(",
                    10,
                    "1/10",
                    "Ahh... Entendi. :)",
                    true,
                    true)
    };
}