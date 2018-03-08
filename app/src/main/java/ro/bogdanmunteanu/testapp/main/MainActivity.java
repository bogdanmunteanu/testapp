package ro.bogdanmunteanu.testapp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


import ro.bogdanmunteanu.testapp.R;
import ro.bogdanmunteanu.testapp.fragments.one.FragmentOne;
import ro.bogdanmunteanu.testapp.fragments.two.FragmentTwo;
import ro.bogdanmunteanu.testapp.helpers.FragmentChangeEvent;
import ro.bogdanmunteanu.testapp.helpers.ViewPagerAdapter;
import ro.bogdanmunteanu.testapp.transformers.DrawbackTransformer;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.content)
    FrameLayout content;

    @BindView(R.id.loading_layout)
    LinearLayout loadingLayout;

    @BindView(R.id.main_layout)
    LinearLayout mainLayout;

    @BindView(R.id.view_pager)
    ViewPager pager;

    private ViewPagerAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentOne());
        fragments.add(new FragmentTwo());

        adapter= new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        pager.setAdapter(adapter);
        pager.setPageTransformer(true,new DrawbackTransformer());
        pager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChangeFragmentEvent(FragmentChangeEvent event) {
      pager.setCurrentItem(event.fragmentToBeChanged);
    }
}
