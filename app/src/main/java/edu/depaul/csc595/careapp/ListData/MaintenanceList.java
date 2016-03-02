package edu.depaul.csc595.careapp.ListData;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Lucas on 2/24/2016.
 */
public class MaintenanceList extends CardList {
    public MaintenanceList() {
        addItem(new Card(
                Card.Type.type_8,
                R.mipmap.ic_maintenance_tires_pressure,
                "Tires Preassure",
                "Due in 6 days"));

        addItem(new Card(
                Card.Type.type_8,
                R.mipmap.ic_maintenance_brakes,
                "Brakes Maintenance",
                "Due in 11 months"
        ));
    }
}