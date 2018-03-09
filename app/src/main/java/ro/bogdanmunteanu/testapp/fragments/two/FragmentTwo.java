package ro.bogdanmunteanu.testapp.fragments.two;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ro.bogdanmunteanu.testapp.R;
import ro.bogdanmunteanu.testapp.adapters.DataRecyclerAdapter;
import ro.bogdanmunteanu.testapp.helpers.FragmentChangeEvent;
import ro.bogdanmunteanu.testapp.helpers.NetworkHelper;
import ro.bogdanmunteanu.testapp.model.Places;

/**
 * Second fragment implementation
 */
public class FragmentTwo extends Fragment implements FragmentTwoContract.View {

    @BindView(R.id.recycler2)
    RecyclerView recyclerView;
    @BindView(R.id.back_button)
    Button backButton;
    private FragmentTwoPresenter presenter = new FragmentTwoPresenter();
    private DataRecyclerAdapter adapter;
    private boolean isNetworkAvailable = false;

    public static FragmentTwo newInstance() {
        FragmentTwo f = new FragmentTwo();
        Bundle b = new Bundle();
        //set additional stuff here if needed
        f.setArguments(b);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);
        ButterKnife.bind(this, rootView);
        if (!presenter.isAttached()) {
            presenter.attachPresenter(this);
        }

        //this should be executed only if internet is available
        if (isNetworkAvailable) {
            presenter.performApiCalls();
        }
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBaseFragment();
            }
        });
        return rootView;
    }

    @Override
    public void onLoadSuccess(ArrayList<Places> result) {
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new DataRecyclerAdapter(this.getContext(), result);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onLoadError(String errorMessage) {

    }

    public void goToBaseFragment() {
        EventBus.getDefault().post(new FragmentChangeEvent(0));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChangeFragmentEvent(NetworkHelper.InternetEvent event) {
        if(event.isAvailable)
        {
            isNetworkAvailable=true;
        }else{
            isNetworkAvailable=false;
        }
    }
}
