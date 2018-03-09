package ro.bogdanmunteanu.testapp.fragments.two;

import android.util.Log;

import java.util.ArrayList;

import ro.bogdanmunteanu.testapp.R;
import ro.bogdanmunteanu.testapp.base.BaseNetworkPresenter;
import ro.bogdanmunteanu.testapp.model.Location;
import ro.bogdanmunteanu.testapp.model.Walk;
import ro.bogdanmunteanu.testapp.ws.ApiManager;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;


/**
 * Created by Bogdan on 3/7/2018.
 */

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
                .subscribe(new Action1<ArrayList<Location>>() {
                    @Override
                    public void call(ArrayList<Location> locations) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });


        Observable.zip(getApi().getLocationObservable()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()),
                getApi().getWalksObservable()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()),
                new Func2<ArrayList<Location>, ArrayList<Walk>, Object>() {
                    @Override
                    public Object call(ArrayList<Location> locations, ArrayList<Walk> walks) {
                        return null;
                    }
                })
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object r) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
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


}





