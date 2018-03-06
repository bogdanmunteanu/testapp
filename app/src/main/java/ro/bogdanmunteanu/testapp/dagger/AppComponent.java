package ro.bogdanmunteanu.testapp.dagger;


import javax.inject.Singleton;

import dagger.Component;
import ro.bogdanmunteanu.testapp.base.BaseNetworkPresenter;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(App application);
    void inject(BaseNetworkPresenter presenter);

}
