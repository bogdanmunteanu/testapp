package ro.bogdanmunteanu.testapp.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
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
import ro.bogdanmunteanu.testapp.helpers.NetworkHelper;
import ro.bogdanmunteanu.testapp.helpers.ViewPagerAdapter;
import ro.bogdanmunteanu.testapp.transformers.DrawbackTransformer;

/**
 * Main activity implementation that holds the viewpager fragment
 */
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

        if(NetworkHelper.isNetworkAvailable())
        {
            EventBus.getDefault().post(new NetworkHelper.InternetEvent(true));
        }else
        {
            Snackbar snackbar = Snackbar
                    .make(content, "No internet connection", Snackbar.LENGTH_LONG)
                    .setAction("Go to settings", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                            startActivity(intent);
                        }
                    });

            snackbar.show();
            EventBus.getDefault().post(new NetworkHelper.InternetEvent(false));
        }

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentOne());
        fragments.add(new FragmentTwo());

        adapter= new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        pager.setAdapter(adapter);
        pager.setPageTransformer(true,new DrawbackTransformer());

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

    protected void showNoInternetAlert(final String title, final String message, final Context ctx) {

        if (ctx != null) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                public void run() {
                    new AlertDialog.Builder(ctx)
                            .setTitle(title)
                            .setMessage(message)
                            .setPositiveButton(getString(R.string.go_to_settings), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                                    startActivity(intent);
                                }
                            })
                            .setNegativeButton(getString(R.string.cancel), null)
                            .create()
                            .show();
                }
            });
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChangeFragmentEvent(FragmentChangeEvent event) {
      pager.setCurrentItem(event.fragmentToBeChanged);
    }
}
