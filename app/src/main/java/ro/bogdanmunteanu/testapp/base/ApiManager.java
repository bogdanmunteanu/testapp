package ro.bogdanmunteanu.testapp.base;

import javax.inject.Inject;

public class ApiManager {

    @Inject
    ServiceManager serviceManager;

    public ApiManager()
    {
        BaseApplication.getInstance().getBaseComponent().inject(this);
    }



    public interface Callback<R>
    {
        void onSuccess(R result);

        void onFailure(String code);
    }
}
