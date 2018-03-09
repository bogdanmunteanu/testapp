package ro.bogdanmunteanu.testapp.fragments.two;

import java.util.ArrayList;

import ro.bogdanmunteanu.testapp.base.BaseNetworkPresenter;
import ro.bogdanmunteanu.testapp.model.Places;

public interface FragmentTwoContract {

    interface Presenter extends BaseNetworkPresenter.BasePresenter<FragmentTwoContract.View>
    {
        void getLocations();

        void getWalks();

        void performApiCalls();


    }

    interface View extends BaseNetworkPresenter.BaseView<ArrayList<Places>>
    {


    }
}
