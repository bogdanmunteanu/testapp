package ro.bogdanmunteanu.testapp.base;

import android.app.Application;
import android.content.res.Resources;

public class BaseApplication extends Application{

    private static BaseApplication instance;

    private ApplicationComponent baseComponent;

    public static Resources getRes() {
        return instance.getResources();
    }

    public static BaseApplication getInstance() {return instance;}

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        baseComponent = DaggerApplicationComponent.builder().appModule(new ApplicationModule(this)).build();

    }

    public ApplicationComponent getBaseComponent() {return baseComponent;}
}
