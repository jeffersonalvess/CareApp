package edu.depaul.csc595.careapp.ListData;

import edu.depaul.csc595.careapp.R;

/**
 * Created by Lucas on 3/2/2016.
 */
public class MaintenanceAddTypeList extends CardList {
    public MaintenanceAddTypeList() {
        addItem(new Card(
            Card.Type.type_6,
            Card.ImgShape.squared,
            R.mipmap.ic_maintenance_air_filter,
            "Air Filter",
            ""));

        addItem(new Card(
                Card.Type.type_6,
                Card.ImgShape.squared,
                R.mipmap.ic_maintenance_brakes,
                "Brakes",
                ""));

        addItem(new Card(
                Card.Type.type_6,
                Card.ImgShape.squared,
                R.mipmap.ic_maintenance_fuel_filter,
                "Fuel Filter",
                ""));

        addItem(new Card(
                Card.Type.type_6,
                Card.ImgShape.squared,
                R.mipmap.ic_maintenance_tires,
                "Tires",
                ""));
        addItem(new Card(
            Card.Type.type_6,
            Card.ImgShape.squared,
            R.mipmap.ic_maintenance_tires_pressure,
            "Tires Pressure",
            ""));
    }
}
