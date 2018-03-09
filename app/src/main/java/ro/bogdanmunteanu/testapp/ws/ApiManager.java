package ro.bogdanmunteanu.testapp.ws;

import java.util.ArrayList;

import javax.inject.Inject;

import ro.bogdanmunteanu.testapp.dagger.App;
import ro.bogdanmunteanu.testapp.model.Location;
import ro.bogdanmunteanu.testapp.model.Walk;
import rx.Observable;

/**
 * Public interface for calling web service
 */
public class ApiManager {

    @Inject
    ServiceManager serviceManager;

    public ApiManager() {
        App.getInstance().getAppComponent().inject(this);
    }

    /**
     * Callback for passing the response from Retrofit call
     * @param <R> generic type of response
     */
    public interface Callback<R> {
        void onSuccess(R result);

        void onFailure(String code);
    }
    public void getLocations(final Callback<ArrayList<Location>> callback){
        serviceManager.getLocations().enqueue(new ApiRequestCallback<>(callback));
    }

    public void getWalks(final Callback<ArrayList<Walk>> callback) {
        serviceManager.getWalks().enqueue(new ApiRequestCallback<>(callback));
    }

    public Observable<ArrayList<Location>> getLocationObservable(){
        return serviceManager.getLocationsObservable();
    }

    public Observable<ArrayList<Walk>> getWalksObservable(){
        return serviceManager.getWalksObservable();
    }
}
