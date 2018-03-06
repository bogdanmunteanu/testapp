package ro.bogdanmunteanu.testapp.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Base activity for all stuff
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //here we could do some additional stuff before starting the activity (init crashlytics, firebase etc
    }

    /**
     * Helper method to return different layouts in different activities based on layout id
     * @return
     */
    public abstract int getLayoutId();
}
