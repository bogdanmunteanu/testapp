package ro.bogdanmunteanu.testapp.ws;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import ro.bogdanmunteanu.testapp.model.Location;

/**
 * Webservices implemementation
 * All baseUrls must end with slash and contain protocol and port if necessary.
 * All endpoints shouldn't end in slash
 */

public interface ServiceManager {
    String baseUrl = "https://private-0c3260-ropa.apiary-mock.com";

    @GET("/locations")
    Call<ArrayList<Location>> getLocations();

    //locations and API2: /walks
}
