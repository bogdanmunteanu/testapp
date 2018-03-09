package ro.bogdanmunteanu.testapp.dagger;

import android.content.res.Resources;
import android.support.multidex.MultiDexApplication;

/**
 * Base application class with dagger init
 */
public class App extends MultiDexApplication {

    private static App instance;

    private AppComponent appComponent;

    public static Resources getRes() {
        return instance.getResources();
    }

    public static App getInstance() {return instance;}

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);

    }

    public AppComponent getAppComponent() {return appComponent;}
}
