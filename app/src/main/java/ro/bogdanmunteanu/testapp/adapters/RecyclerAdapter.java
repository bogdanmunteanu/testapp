package ro.bogdanmunteanu.testapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ro.bogdanmunteanu.testapp.R;

/**
 * Created by Bogdan on 3/7/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AdapterHolder>{

    private Context context;
    private List<Integer> numbers;

    public RecyclerAdapter(Context context, List<Integer> numbers) {
        this.context = context;
        this.numbers = numbers;
    }

    @Override
    public AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new RecyclerAdapter.AdapterHolder(view);


    }

    @Override
    public void onBindViewHolder(AdapterHolder holder, int position) {

        holder.text.setText(numbers.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class AdapterHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textView)
        TextView text;

        @BindView(R.id.checkBox)
        CheckBox checkBox;

        @BindView(R.id.button)
        Button button;

        @BindView(R.id.imageView)
        ImageView image;

        AdapterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
