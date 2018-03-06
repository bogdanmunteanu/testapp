package ro.bogdanmunteanu.testapp.base;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class RetrofitModule {
    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(ServiceManager.baseUrl)
                .client(client)
                .build();

    }
}
