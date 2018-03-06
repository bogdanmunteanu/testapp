package ro.bogdanmunteanu.testapp.main;

import android.view.View;

import butterknife.BindView;
import ro.bogdanmunteanu.testapp.R;
import ro.bogdanmunteanu.testapp.base.BaseActivity;
import ro.bogdanmunteanu.testapp.dagger.App;

/**
 * Created by Bogdan on 3/6/2018.
 */

public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

}
