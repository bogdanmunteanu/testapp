package ro.bogdanmunteanu.testapp.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ro.bogdanmunteanu.testapp.ws.ApiManager;
import ro.bogdanmunteanu.testapp.ws.ServiceManager;

/**
 * Dagger module implementation
 */

@Module
public class AppModule {

    private Application app;

    public AppModule(Application app)
    {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application getApp()
    {
        return app;
    }

    @Provides
    @Singleton
    public ApiManager getApi()
    {
        return new ApiManager();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(ServiceManager.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    @Provides
    @Singleton
    public ServiceManager provideServiceManager(Retrofit retrofit)
    {
      return retrofit.create(ServiceManager.class);
    }
}
