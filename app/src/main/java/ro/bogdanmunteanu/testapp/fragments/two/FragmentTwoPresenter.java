package ro.bogdanmunteanu.testapp.fragments.two;

import android.app.Application;

import java.util.ArrayList;
import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ro.bogdanmunteanu.testapp.base.BaseNetworkPresenter;
import ro.bogdanmunteanu.testapp.model.Location;
import ro.bogdanmunteanu.testapp.model.Walk;
import ro.bogdanmunteanu.testapp.ws.ApiManager;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by Bogdan on 3/7/2018.
 */

public class FragmentTwoPresenter extends BaseNetworkPresenter implements FragmentTwoContract.Presenter{

    private FragmentTwoContract.View view;

    @Override
    public void attachPresenter(FragmentTwoContract.View listener) {
        this.view =  listener;
    }

    @Override
    public void detachPresenter() {
        view = null;
    }

    @Override
    public boolean isAttached() {
        return view!=null;
    }

    @Override
    public void performApiCalls() {

        getApi().getWalks(new ApiManager.Callback<ArrayList<Walk>>() {
            @Override
            public void onSuccess(ArrayList<Walk> result) {

            }

            @Override
            public void onFailure(String code) {

            }
        });

        getApi().getLocations(new ApiManager.Callback<ArrayList<Location>>() {
            @Override
            public void onSuccess(ArrayList<Location> result) {

            }

            @Override
            public void onFailure(String code) {

            }
        });

    }




}
