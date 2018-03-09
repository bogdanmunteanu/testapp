package ro.bogdanmunteanu.testapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import ro.bogdanmunteanu.testapp.R;
import ro.bogdanmunteanu.testapp.helpers.FragmentChangeEvent;
import ro.bogdanmunteanu.testapp.helpers.NumberHelper;
import ro.bogdanmunteanu.testapp.model.Element;

/**
 * Adapter that holds the data in the first fragment
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AdapterHolder>{

    private Context context;
    private ArrayList<Element> elements;
    private HashMap<Integer,String> cache = new HashMap<>();

    public RecyclerAdapter(Context context, ArrayList<Element> elements) {
        this.context = context;
        this.elements = elements;
    }

    @Override
    public AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new RecyclerAdapter.AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterHolder holder, int position) {

        int currentNumber = elements.get(position).getNumber();
        holder.text.setText(currentNumber+"");
        if(NumberHelper.isPrime(currentNumber)) {
            holder.image.setVisibility(View.GONE);
            holder.components.setVisibility(View.VISIBLE);
        }
        else {
            holder.image.setVisibility(View.VISIBLE);
            holder.components.setVisibility(View.GONE);
            Picasso.with(context)
                    .load(elements.get(position).getPictureUrl())
                    .into(holder.image);
        }
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.checkBox.isChecked()) {
                    EventBus.getDefault().post(new FragmentChangeEvent(1));
                }else
                {
                    holder.image.setVisibility(View.VISIBLE);
                    holder.components.setVisibility(View.GONE);
                    Picasso.with(context)
                            .load(R.mipmap.sad_face)
                            .into(holder.image);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }


    public void generateNextFibonaciNumber()
    {
       int nextFibonacci = elements.get(elements.size()-1).getNumber()+elements.get(elements.size()-2).getNumber();
       elements.add(new Element(nextFibonacci,NumberHelper.getRandomPictureUrl()));
       this.notifyDataSetChanged();
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

        @BindView(R.id.components)
        LinearLayout components;

        AdapterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
