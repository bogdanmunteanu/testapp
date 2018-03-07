package ro.bogdanmunteanu.testapp.fragments.one;

import ro.bogdanmunteanu.testapp.base.BaseNetworkPresenter;

public interface FragmentOneContract extends BaseNetworkPresenter.BasePresenter<String> {
    //link to presenter
    interface Presenter
    {

    }

    //link to view
    interface View extends BaseNetworkPresenter.BaseVIew<String>
    {


    }
}
