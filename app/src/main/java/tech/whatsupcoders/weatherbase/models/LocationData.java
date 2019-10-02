package tech.whatsupcoders.weatherbase.models;

import java.util.ArrayList;

public class LocationData {

    public static String[] data = new String[]{
            "Chicago, IL,USA",
            "Orlando, FL,USA",
            "NewYork, NY,USA",
    };

    public static ArrayList<Location> getListData() {
        Location location;
        ArrayList<Location> list = new ArrayList<>();

        for (String mData : data) {
            location = new Location();
            location.setPlace(mData);
            list.add(location);
        }

        return list;
    }
}
