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
                    R.drawable.ic_rewards_psn,
                    "PSN $20 Code",
                    "Redeem this $20 code on PSN store",
                    "Buy extras, PSN membership and much more with this $20 credit",
                    70,
                    "2000/5000",
                    "Saved",
                    false,
                    false),

            new Card(
                    Card.Type.type_5,
                    R.drawable.ic_rewards_bk,
                    "Burger King $10",
                    "Hungry?",
                    "Drive now to Burger King and use your $10 GC.",
                    100,
                    "1000/1000",
                    "",
                    true,
                    true),

            new Card(
                    Card.Type.type_5,
                    R.drawable.ic_rewards_amazon,
                    "Amazon $20 Gift Card",
                    "Choose between hundreds of thousands Amazon's items",
                    "Amazon $50 gift card digital code.",
                    40,
                    "2000/6000",
                    "",
                    true,
                    false),

            new Card(
                    Card.Type.type_5,
                    R.drawable.ic_rewards_xbox,
                    "XBOX Live $25 Code",
                    "Redeem this code on XBOX Live",
                    "Enjoy XBOX Live with credits on your Live account.",
                    70,
                    "2000/5000",
                    "",
                    true,
                    false)
    };
}