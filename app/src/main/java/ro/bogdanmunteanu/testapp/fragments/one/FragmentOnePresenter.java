package ro.bogdanmunteanu.testapp.fragments.one;

import ro.bogdanmunteanu.testapp.base.BaseNetworkPresenter;

public class FragmentOnePresenter extends BaseNetworkPresenter implements FragmentOneContract.Presenter {

    private FragmentOneContract.View view;

    @Override
    public void attachPresenter(FragmentOneContract.View listener) {
        this.view=listener;
    }

    @Override
    public void detachPresenter() {
        view=null;
    }

    @Override
    public boolean isAttached() {
        return view !=null;
    }
}
