package edu.depaul.csc595.careapp.ListData;

import java.util.Random;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Miller on 15/02/2016.
 */
public class ProfileList extends CardList {

    public ProfileList(){
        Random random = new Random();
        for (int i = 0; i < 100; i++) {

            Card.Type type;
            if(random.nextInt() % 2 == 0){
                type = Card.Type.type_1;
            }
            else{
                type = Card.Type.type_2;
            }

            int progress = 10;

            if((random.nextInt() % 4) == 0){
                progress = (random.nextInt() % 101);
            }

            Card.ImgShape imgShape;

            if((random.nextInt() % 2) == 0){
                imgShape = Card.ImgShape.rounded;
            }
            else {
                imgShape = Card.ImgShape.squared;
            }

            addItem(new Card(Card.Type.type_1,
                    "Title " + ((int)i+1),
                    R.drawable.com_facebook_profile_picture_blank_square,
                    "Content Title",
                    "Line 1",
                    "Line 2",
                    "Line 3",
                    progress,
                    imgShape));
        }
    }
}
