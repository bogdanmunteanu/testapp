package ro.bogdanmunteanu.testapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bogdan on 3/6/2018.
 */

public class LocationLatLng {
    @SerializedName("lat")
    public String lat;

    @SerializedName("long")
    public String lng;
}
