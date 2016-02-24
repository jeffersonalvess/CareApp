package edu.depaul.csc595.careapp.ListData;
import edu.depaul.csc595.careapp.R;

public class FriendsList extends CardList {

    public FriendsList(){
        for (int i = 0; i < PROFILES_ARRAY.length; i++) {
            addItem(PROFILES_ARRAY[i]);
        }
    }

    public final Card[] PROFILES_ARRAY = {
            new Card(
                    Card.Type.type_6,
                    Card.ImgShape.rounded,
                    R.drawable.ic_profile_lucas,
                    "Lucas Barbosa",
                    ""),

            new Card(
                    Card.Type.type_6,
                    Card.ImgShape.rounded,
                    R.drawable.ic_profile_matheus,
                    "Matheus Zamberlan",
                    ""),

            new Card(
                    Card.Type.type_6,
                    Card.ImgShape.rounded,
                    R.drawable.ic_profile_miller,
                    "Miller Horvath",
                    ""),

            new Card(
                    Card.Type.type_6,
                    Card.ImgShape.rounded,
                    R.drawable.ic_profile_renato,
                    "Renato Leonel",
                    ""),

            new Card(
                    Card.Type.type_6,
                    Card.ImgShape.rounded,
                    R.drawable.ic_profile_lucas,
                    "Lucas Barbosa",
                    ""),

            new Card(
                    Card.Type.type_6,
                    Card.ImgShape.rounded,
                    R.drawable.ic_profile_matheus,
                    "Matheus Zamberlan",
                    ""),

            new Card(
                    Card.Type.type_6,
                    Card.ImgShape.rounded,
                    R.drawable.ic_profile_miller,
                    "Miller Horvath",
                    ""),

            new Card(
                    Card.Type.type_6,
                    Card.ImgShape.rounded,
                    R.drawable.ic_profile_renato,
                    "Renato Leonel",
                    ""),

            new Card(
                    Card.Type.type_6,
                    Card.ImgShape.rounded,
                    R.drawable.ic_profile_lucas,
                    "Lucas Barbosa",
                    ""),

            new Card(
                    Card.Type.type_6,
                    Card.ImgShape.rounded,
                    R.drawable.ic_profile_matheus,
                    "Matheus Zamberlan",
                    ""),

            new Card(
                    Card.Type.type_6,
                    Card.ImgShape.rounded,
                    R.drawable.ic_profile_miller,
                    "Miller Horvath",
                    ""),

            new Card(
                    Card.Type.type_6,
                    Card.ImgShape.rounded,
                    R.drawable.ic_profile_renato,
                    "Renato Leonel",
                    "")
    };
}
