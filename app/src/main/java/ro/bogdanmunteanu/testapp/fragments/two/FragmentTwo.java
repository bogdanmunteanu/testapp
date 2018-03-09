package ro.bogdanmunteanu.testapp.fragments.two;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.ButterKnife;
import ro.bogdanmunteanu.testapp.R;
import ro.bogdanmunteanu.testapp.helpers.FragmentChangeEvent;
import ro.bogdanmunteanu.testapp.model.Places;


public class FragmentTwo extends Fragment implements FragmentTwoContract.View {

    private FragmentTwoPresenter presenter =  new FragmentTwoPresenter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two,container,false);
        ButterKnife.bind(this,rootView);
        if (!presenter.isAttached()) {
            presenter.attachPresenter(this);
        }
        presenter.performApiCalls();
        return rootView;
    }


    @Override
    public void onLoadSuccess(ArrayList<Places> result) {
        for(Places place : result)
        {
            Log.d("Place",place.toString());
        }
    }

    @Override
    public void onLoadError(String errorMessage) {

    }

    public static FragmentTwo newInstance()
    {
        FragmentTwo f = new FragmentTwo();
        Bundle b = new Bundle();
        //set additional stuff here if needed
        f.setArguments(b);
        return f;
    }

    public void goToBaseFragment()
    {
        EventBus.getDefault().post(new FragmentChangeEvent(0));
    }
}
