package ro.bogdanmunteanu.testapp.base;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;
import ro.bogdanmunteanu.testapp.MainActivity;

@Singleton
@Component(modules = {ApplicationModule.class,RetrofitModule.class})
public interface ApplicationComponent {

    void inject(Retrofit o);
    void inject(ServiceManager o);
    void inject(ApiManager o);
}
