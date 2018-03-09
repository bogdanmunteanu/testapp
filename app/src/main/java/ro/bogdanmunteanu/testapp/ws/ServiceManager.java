package ro.bogdanmunteanu.testapp.ws;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import ro.bogdanmunteanu.testapp.model.Location;
import ro.bogdanmunteanu.testapp.model.Walk;

/**
 * Webservices implemementation
 * All baseUrls must end with slash and contain protocol and port if necessary.
 * All endpoints shouldn't end in slash
 */

public interface ServiceManager {
    String baseUrl = "https://private-0c3260-ropa.apiary-mock.com";

    @GET("/locations")
    Call<ArrayList<Location>> getLocations();

    @GET("/walks")
    Call<ArrayList<Walk>> getWalks();

    @GET("/locations")
    Observable<ArrayList<Location>> getLocationsObservable();

    @GET("/walks")
    Observable<ArrayList<Walk>> getWalksObservable();
}
