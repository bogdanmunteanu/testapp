package ro.bogdanmunteanu.testapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Walk {
    @SerializedName("id")
    public String id;

    @SerializedName("title")
    public String title;

    @SerializedName("places")
    ArrayList<String> places;

    public Walk(String id, String title, ArrayList<String> places) {
        this.id = id;
        this.title = title;
        this.places = places;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Walk{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", places=").append(places);
        sb.append('}');
        return sb.toString();
    }
}
