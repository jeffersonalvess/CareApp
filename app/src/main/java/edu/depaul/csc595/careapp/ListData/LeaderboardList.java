package edu.depaul.csc595.careapp.ListData;
import edu.depaul.csc595.careapp.R;


public class LeaderboardList extends CardList {

    public LeaderboardList(){
        for (int i = 0; i < PROFILES_ARRAY.length; i++) {
            addItem(PROFILES_ARRAY[i]);
        }
    }

    public final Card[] PROFILES_ARRAY = {
            new Card(Card.Type.type_9,
                    R.drawable.ic_profile_renato,
                    "1º",
                    "23450",
                    "Renato Leonel"),

            new Card(Card.Type.type_9,
                    R.drawable.ic_profile_miller,
                    "2º",
                    "22464",
                    "Miller Horvath"),

            new Card(Card.Type.type_9,
                    R.drawable.ic_profile_jefferson,
                    "3º",
                    "10547",
                    "Jefferson Alves"),

            new Card(Card.Type.type_9,
                    R.drawable.ic_profile_matheus,
                    "4º",
                    "7985",
                    "Matheus Zamberlan"),

            new Card(Card.Type.type_9,
                    R.drawable.ic_profile_lucas,
                    "5º",
                    "1",
                    "Lucas Barbosa")
    };
}
