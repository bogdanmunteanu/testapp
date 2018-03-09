package ro.bogdanmunteanu.testapp.dagger;


import javax.inject.Singleton;

import dagger.Component;
import ro.bogdanmunteanu.testapp.base.BaseNetworkPresenter;
import ro.bogdanmunteanu.testapp.ws.ApiManager;
import ro.bogdanmunteanu.testapp.ws.ServiceManager;

/**
 * Dagger module definition interface
 *
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(App application);
    void inject(BaseNetworkPresenter presenter);
    void inject(ApiManager apiManager);

}
