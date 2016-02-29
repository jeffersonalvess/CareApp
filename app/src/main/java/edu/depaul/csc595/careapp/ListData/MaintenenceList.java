package edu.depaul.csc595.careapp.ListData;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Lucas on 2/24/2016.
 */
public class MaintenenceList extends CardList {
    public MaintenenceList() {
        addItem(new Card(
                Card.Type.type_8,
                R.mipmap.ic_action_tip,
                "Maintenence",
                "Maintenence Info"));
    }
}