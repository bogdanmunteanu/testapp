package ro.bogdanmunteanu.testapp.helpers;

import android.content.Context;
import android.net.ConnectivityManager;

import ro.bogdanmunteanu.testapp.dagger.App;

public class NetworkHelper {
    public static boolean isNetworkAvailable() {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE));
        if (connectivityManager == null) {
            return false;
        }
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    public static class InternetEvent {
        public boolean isAvailable;

        public InternetEvent(boolean isAvailable) {
            this.isAvailable = isAvailable;
        }
    }
}