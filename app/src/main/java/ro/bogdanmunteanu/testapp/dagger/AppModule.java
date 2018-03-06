package ro.bogdanmunteanu.testapp.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ro.bogdanmunteanu.testapp.ws.ApiManager;

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

    //other declarations here
}
