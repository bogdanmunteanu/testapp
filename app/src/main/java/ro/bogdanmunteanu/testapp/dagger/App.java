package ro.bogdanmunteanu.testapp.dagger;

import android.app.Application;
import android.content.res.Resources;

/**
 * Base application class with dagger init
 */
public class App extends Application{

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
