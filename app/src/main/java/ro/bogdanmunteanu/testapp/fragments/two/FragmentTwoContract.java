package ro.bogdanmunteanu.testapp.fragments.two;

import ro.bogdanmunteanu.testapp.base.BaseNetworkPresenter;

/**
 * Created by Bogdan on 3/7/2018.
 */

public interface FragmentTwoContract {

    interface Presenter extends BaseNetworkPresenter.BasePresenter<FragmentTwoContract.View>
    {
        void performApiCalls();


    }

    interface View extends BaseNetworkPresenter.BaseView<String>
    {


    }
}
