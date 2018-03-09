package ro.bogdanmunteanu.testapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ro.bogdanmunteanu.testapp.R;
import ro.bogdanmunteanu.testapp.model.Places;

/**
 * Adapter that holds the data in the second fragment
 */
public class DataRecyclerAdapter extends RecyclerView.Adapter<DataRecyclerAdapter.AdapterHolder> {

    private Context context;
    private ArrayList<Places> places;


    public DataRecyclerAdapter(Context context, ArrayList<Places> places) {
        this.context = context;
        this.places = places;
    }

    @Override
    public AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.place_item, parent, false);
        return new DataRecyclerAdapter.AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterHolder holder, int position) {
        Places place = places.get(position);
        Log.d("Holder::::",place.toString());
        holder.walkId.setText(place.getWalk().id);
        holder.walkTitle.setText(place.getWalk().title);
        holder.placeId.setText(place.getLocation().id);
        holder.placeTitle.setText(place.getLocation().title);

    }

    @Override
    public int getItemCount() {
        return places.size();
    }


    static class AdapterHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.walk_id)
        TextView walkId;

        @BindView(R.id.walk_title)
        TextView walkTitle;

        @BindView(R.id.place_id)
        TextView placeId;

        @BindView(R.id.place_title)
        TextView placeTitle;

        AdapterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
