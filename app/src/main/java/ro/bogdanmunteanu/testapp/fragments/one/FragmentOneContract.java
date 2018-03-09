package ro.bogdanmunteanu.testapp.fragments.one;

import ro.bogdanmunteanu.testapp.base.BaseNetworkPresenter;

/**
 * First fragment contract - link between view and presenter
 */
public interface FragmentOneContract {
    //link to presenter
    interface Presenter extends BaseNetworkPresenter.BasePresenter<FragmentOneContract.View>
    {

    }

    //link to view
    interface View extends BaseNetworkPresenter.BaseView<String>
    {


    }
}
