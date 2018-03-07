package ro.bogdanmunteanu.testapp.main;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import ro.bogdanmunteanu.testapp.R;
import ro.bogdanmunteanu.testapp.base.BaseActivity;
import ro.bogdanmunteanu.testapp.dagger.App;
import ro.bogdanmunteanu.testapp.fragments.one.FragmentOne;

public class MainActivity extends BaseActivity {

    private FragmentOne firstFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ButterKnife.bind(this);

        setFirstFragment();
    }

    private void setFirstFragment() {
        if(firstFragment!=null)
        {
            firstFragment = new FragmentOne();
        }
        changeFragmentWithHistory(firstFragment);

    }
}
