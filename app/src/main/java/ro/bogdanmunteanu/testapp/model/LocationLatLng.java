package ro.bogdanmunteanu.testapp.model;

import com.google.gson.annotations.SerializedName;

public class LocationLatLng {
    @SerializedName("lat")
    public String lat;

    @SerializedName("lng")
    public String lng;

    public LocationLatLng(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LocationLatLng{");
        sb.append("lat='").append(lat).append('\'');
        sb.append(", lng='").append(lng).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
