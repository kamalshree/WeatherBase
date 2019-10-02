package tech.whatsupcoders.weatherbase.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {
    private String place;


    public Location() {
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    protected Location(Parcel in) {
        place = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(place);
    }
}
