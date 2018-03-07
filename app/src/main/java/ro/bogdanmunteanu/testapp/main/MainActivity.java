package ro.bogdanmunteanu.testapp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


import ro.bogdanmunteanu.testapp.R;
import ro.bogdanmunteanu.testapp.fragments.one.FragmentOne;
import ro.bogdanmunteanu.testapp.fragments.two.FragmentTwo;
import ro.bogdanmunteanu.testapp.helpers.FragmentListener;
import ro.bogdanmunteanu.testapp.helpers.ViewPagerAdapter;
import ro.bogdanmunteanu.testapp.transformers.DrawbackTransformer;

public class MainActivity extends AppCompatActivity implements FragmentListener{

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

    }


    @Override
    public void goToDetailsFragment() {

    }
}
