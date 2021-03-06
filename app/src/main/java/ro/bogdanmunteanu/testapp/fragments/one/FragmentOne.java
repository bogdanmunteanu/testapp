package ro.bogdanmunteanu.testapp.fragments.one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ro.bogdanmunteanu.testapp.R;
import ro.bogdanmunteanu.testapp.adapters.RecyclerAdapter;
import ro.bogdanmunteanu.testapp.helpers.NetworkHelper;
import ro.bogdanmunteanu.testapp.helpers.NumberHelper;
import ro.bogdanmunteanu.testapp.model.Element;

/**
 * First fragment implementation
 */
public class FragmentOne extends Fragment implements FragmentOneContract.View {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @BindView(R.id.no_conn_layout)
    RelativeLayout noConnLayout;

    @BindView(R.id.main_layout)
    RelativeLayout mainLayout;

    @BindView(R.id.picture)
    ImageView picture;

    private RecyclerAdapter adapter;
    public boolean isNetworkAvailable;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View rootView = inflater.inflate(R.layout.fragment_one,container,false);
      ButterKnife.bind(this,rootView);


        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //prepare list of elements
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(new Element(0,NumberHelper.getRandomPictureUrl()));
        elements.add(new Element( 1,NumberHelper.getRandomPictureUrl()));


        adapter = new RecyclerAdapter(this.getContext(),elements);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnScrollChangeListener(new RecyclerView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if(!recyclerView.canScrollVertically(1)) {
                    //last item , we should add more numbers
                    for(int index=0;index<5;index++) {
                        adapter.generateNextFibonaciNumber();
                    }
                }
            }
        });

        return rootView;
    }
    @Override
    public void onLoadSuccess(String result) {

    }

    @Override
    public void onLoadError(String errorMessage) {

    }
    public static FragmentOne newInstance()
    {
        FragmentOne f = new FragmentOne();
        Bundle b = new Bundle();
        //set additional stuff here if needed
        f.setArguments(b);
        return f;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onInternetEvent(NetworkHelper.InternetEvent event) {
        if(event.isAvailable)
        {
            isNetworkAvailable=true;
            mainLayout.setVisibility(View.VISIBLE);
            noConnLayout.setVisibility(View.GONE);
        }else{
            isNetworkAvailable=false;
            mainLayout.setVisibility(View.GONE);
            noConnLayout.setVisibility(View.VISIBLE);
            Picasso.with(this.getContext())
                    .load(R.mipmap.sad_face)
                    .into(picture);
        }
    }
}
