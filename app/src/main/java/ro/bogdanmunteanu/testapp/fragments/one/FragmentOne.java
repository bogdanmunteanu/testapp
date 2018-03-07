package ro.bogdanmunteanu.testapp.fragments.one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import ro.bogdanmunteanu.testapp.R;
import ro.bogdanmunteanu.testapp.adapters.RecyclerAdapter;
import ro.bogdanmunteanu.testapp.helpers.NumberHelper;

public class FragmentOne extends Fragment implements FragmentOneContract.View {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    private RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View rootView = inflater.inflate(R.layout.fragment_one,container,false);
      ButterKnife.bind(this,rootView);
      LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
      llm.setOrientation(LinearLayoutManager.VERTICAL);
      adapter = new RecyclerAdapter(this.getContext(), NumberHelper.generateFibonacciList(30));
      recyclerView.setLayoutManager(llm);
      recyclerView.setAdapter(adapter);

      return rootView;
    }

    @Override
    public void onLoadSuccess(String result) {

    }

    @Override
    public void onLoadError(String errorMessage) {

    }
}
