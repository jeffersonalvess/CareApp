package edu.depaul.csc595.careapp.ListData;

import java.util.Random;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Miller on 15/02/2016.
 */
public class ProfileList extends CardList {

    public ProfileList(){
        Random random = new Random();

        addItem(new Card(Card.Type.type_1,
                "Title  Teste 1",
                R.drawable.com_facebook_profile_picture_blank_square,
                "Content Title Teste 1",
                "Line 1 Teste 1",
                "Line 2 Teste 1",
                "Line 3 Teste 1",
                10,
                Card.ImgShape.rounded));

        addItem(new Card(Card.Type.type_1,
                "Title  Teste 2",
                R.drawable.com_facebook_profile_picture_blank_square,
                "Content Title Teste 2",
                "Line 1 Teste 2",
                "Line 2 Teste 2",
                "Line 3 Teste 2",
                20,
                Card.ImgShape.rounded));

        addItem(new Card(Card.Type.type_1,
                "Title  Teste 3",
                R.drawable.com_facebook_profile_picture_blank_square,
                "Content Title Teste 3",
                "Line 1 Teste 3",
                "Line 2 Teste 3",
                "Line 3 Teste 3",
                -1,
                Card.ImgShape.squared));

        addItem(new Card(Card.Type.type_1,
                "Title  Teste 4",
                R.drawable.com_facebook_profile_picture_blank_square,
                "Content Title Teste 4",
                "Line 1 Teste 4",
                "Line 2 Teste 4",
                "Line 3 Teste 4",
                40,
                Card.ImgShape.rounded));

        addItem(new Card(Card.Type.type_1,
                "Title  Teste 5",
                R.drawable.com_facebook_profile_picture_blank_square,
                "Content Title Teste 5",
                "Line 1 Teste 5",
                "Line 2 Teste 5",
                "Line 3 Teste 5",
                100,
                Card.ImgShape.rounded));

        for (int i = 0; i < 95; i++) {

            Card.Type type;
            if(Math.abs(random.nextInt()) % 2 == 0){
                type = Card.Type.type_1;
            }
            else{
                type = Card.Type.type_2;
            }

            int progress = 10;

            if((Math.abs(random.nextInt()) % 4) == 0){
                progress = (Math.abs(random.nextInt()) % 101);
            }

            Card.ImgShape imgShape;

            if((Math.abs(random.nextInt()) % 2) == 0){
                imgShape = Card.ImgShape.rounded;
            }
            else {
                imgShape = Card.ImgShape.squared;
            }

            addItem(new Card(Card.Type.type_1,
                    "Title " + ((int)i+6),
                    R.drawable.com_facebook_profile_picture_blank_square,
                    "Content Title" + ((int)i+6),
                    "Line 1" + ((int)i+6),
                    "Line 2" + ((int)i+6),
                    "Line 3" + ((int)i+6),
                    progress,
                    imgShape));
        }
    }
}
