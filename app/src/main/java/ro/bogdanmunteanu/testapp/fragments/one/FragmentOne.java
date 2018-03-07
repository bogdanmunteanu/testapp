package ro.bogdanmunteanu.testapp.fragments.one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ro.bogdanmunteanu.testapp.R;
import ro.bogdanmunteanu.testapp.base.BaseFragment;

public class FragmentOne extends BaseFragment implements FragmentOneContract.View {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View rootView = inflater.inflate(R.layout.fragment_one,container,false);
      ButterKnife.bind(this,rootView);

      return rootView;
    }

    @Override
    public void onLoadSuccess(String result) {

    }

    @Override
    public void onLoadError(String errorMessage) {

    }
}
