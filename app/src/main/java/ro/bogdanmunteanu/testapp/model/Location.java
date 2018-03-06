package ro.bogdanmunteanu.testapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Bogdan on 3/6/2018.
 */

public class Location {

    @SerializedName("id")
    public String id;

    @SerializedName("title")
    public String title;

    @SerializedName("location")
    public LocationLatLng location;

    @SerializedName("url")
    public String url;

    @SerializedName("category")
    public String category;

    @SerializedName("address")
    public String address;

    @SerializedName("details")
    public String details;

    @SerializedName("name")
    public String name;

    @SerializedName("bio")
    public String bio;

    @SerializedName("audio_url")
    public String audioUrl;

    @SerializedName("pictures")
    public ArrayList<String> pictures;
}
