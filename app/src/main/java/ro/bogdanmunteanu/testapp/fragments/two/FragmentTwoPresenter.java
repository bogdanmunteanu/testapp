package ro.bogdanmunteanu.testapp.fragments.two;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ro.bogdanmunteanu.testapp.base.BaseNetworkPresenter;
import ro.bogdanmunteanu.testapp.model.Location;
import ro.bogdanmunteanu.testapp.model.Places;
import ro.bogdanmunteanu.testapp.model.Walk;
import ro.bogdanmunteanu.testapp.ws.ApiManager;


public class FragmentTwoPresenter extends BaseNetworkPresenter implements FragmentTwoContract.Presenter {

    private FragmentTwoContract.View view;

    @Override
    public void attachPresenter(FragmentTwoContract.View listener) {
        this.view = listener;
    }

    @Override
    public void detachPresenter() {
        view = null;
    }

    @Override
    public boolean isAttached() {
        return view != null;
    }

    @Override
    public void getLocations() {

        getApi().getLocationObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(locations -> {

                }, throwable -> {

                });


        getApi().getLocations(new ApiManager.Callback<ArrayList<Location>>() {
            @Override
            public void onSuccess(ArrayList<Location> result) {
                for (Location location : result) {
                    Log.d("F2presenter", location.toString());
                }
            }

            @Override
            public void onFailure(String code) {
                Log.d("F2presenter", "Naspa");
            }
        });
    }

    @Override
    public void getWalks() {
        getApi().getWalks(new ApiManager.Callback<ArrayList<Walk>>() {
            @Override
            public void onSuccess(ArrayList<Walk> result) {
                for (Walk walk : result) {
                    Log.d("F2presenter", walk.toString());
                }
            }

            @Override
            public void onFailure(String code) {
                Log.d("F2presenter", "Naspa");
            }
        });
    }

    @Override
    public void performApiCalls() {
        Observable.zip(getApi().getLocationObservable()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()),
                getApi().getWalksObservable()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()),
                (locations, walks) -> {
                    ArrayList<Places> results = new ArrayList<>();
                    //putting them in hashmaps for easy access later
                    HashMap<Integer,Location> hashLocations =  new HashMap<>();
                    HashMap<Integer,Walk> hashWalks = new HashMap<>();
                    for(Location location : locations) {
                        hashLocations.put(Integer.parseInt(location.id),location);
                    }
                    for(Walk walk : walks) {
                        hashWalks.put(Integer.parseInt(walk.id),walk);
                    }
                    //parse call results
                    for(Walk walk :walks)
                    {
                        //id odd
                        if (Integer.parseInt(walk.id)%2!=0)
                        {
                            //get walk locations and map them
                            ArrayList<Integer> places = walk.places;
                            for(Integer place : places) {
                                if (place%2!=0)
                                {
                                    results.add(new Places(hashWalks.get(Integer.parseInt(walk.id)),hashLocations.get(place)));
                                }
                            }
                        }

                    }

                    return results;
                })
                .subscribe(o -> {
                    if(isAttached()) {
                        view.onLoadSuccess(o);
                    }

                }, throwable -> {
                    if(isAttached()) {
                        view.onLoadError(throwable.getLocalizedMessage());
                    }
                });

    }
}





