package ro.bogdanmunteanu.testapp.base;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private BaseApplication baseApplication;

    public ApplicationModule(BaseApplication baseApplication){
        this.baseApplication = baseApplication;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext()
    {
        return baseApplication;
    }
}
