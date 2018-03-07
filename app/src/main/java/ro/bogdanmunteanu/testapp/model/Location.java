package ro.bogdanmunteanu.testapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

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

    public Location(String id, String title, LocationLatLng location, String url, String category, String address, String details, String name, String bio, String audioUrl, ArrayList<String> pictures) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.url = url;
        this.category = category;
        this.address = address;
        this.details = details;
        this.name = name;
        this.bio = bio;
        this.audioUrl = audioUrl;
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Location{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", location=").append(location);
        sb.append(", url='").append(url).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", details='").append(details).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", bio='").append(bio).append('\'');
        sb.append(", audioUrl='").append(audioUrl).append('\'');
        sb.append(", pictures=").append(pictures);
        sb.append('}');
        return sb.toString();
    }
}
