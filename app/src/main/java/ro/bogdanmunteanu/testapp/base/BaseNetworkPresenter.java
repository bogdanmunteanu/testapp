package ro.bogdanmunteanu.testapp.base;

import javax.inject.Inject;

import ro.bogdanmunteanu.testapp.dagger.App;
import ro.bogdanmunteanu.testapp.ws.ApiManager;

/**
 * Simple class that provides network object injection into  presenter
 */

public abstract class BaseNetworkPresenter {

    private ApiManager api;

    public BaseNetworkPresenter(){
        App.getInstance().getAppComponent().inject(this);
    }

    /**
     *  Network api injection
     * @return the network interface
     */
    protected ApiManager getApi()
    {
        return api;
    }

    @Inject
    final void setApi(ApiManager api){
        this.api= api;
    }

    /**
     * Presenter interface that provides basic functionality
     *
     */
    public interface BasePresenter<T>
    {
        /**
         * attaches the view to the presenter
         *
         * @param listener the view that is handled by the presenter
         */
        void attachPresenter(T listener);
        /**
         * detaches the presenter from the view
         */
        void detachPresenter();

        /**
         * checks if the presenter is attached to a view
         *
         * @return the presence of a view attached to the current presenter
         */
        boolean isAttached();
    }
    /**
     * provides the basic functions a view should provide
     *
     * @param <T> the type of object the presenter should handle
     */
    public interface BaseVIew<T>
    {
        /**
         * callback for the view to handle the data loaded by the presenter
         *
         * @param result the loaded data
         */
        void onLoadSuccess(T result);

        /**
         * callback for the view to handle errors in the data loading
         *
         * @param errorMessage the error message that should be displayed to the user
         */
        void onLoadError(String errorMessage);

    }

}
