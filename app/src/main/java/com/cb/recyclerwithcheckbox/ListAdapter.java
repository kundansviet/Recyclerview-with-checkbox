package com.cb.recyclerwithcheckbox;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kundan on 1/14/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {
    private HashMap<Integer, Boolean> isChecked = new HashMap<>();
    private Context context_1;
    private LayoutInflater inflater;
    private List<String> product_list;


    public ListAdapter(Context context, List<String> p_list) {
        this.context_1 = context;
        this.product_list = p_list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View convertview = inflater.inflate(R.layout.single_row_with_check, parent, false);
        ListHolder holder = new ListHolder(convertview);
        return holder;
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {

        holder.cb_product.setText(product_list.get(position));

        if (isChecked.containsKey(position)) {
            holder.cb_product.setChecked(isChecked.get(position));

        } else {
            holder.cb_product.setChecked(false);
        }


    }

    @Override
    public int getItemCount() {
        return product_list.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder {
        CheckBox cb_product;

        public ListHolder(View itemView) {
            super(itemView);
            cb_product = (CheckBox) itemView.findViewById(R.id.cb_product);

            cb_product.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    isChecked.put(getAdapterPosition(), b);


                }
            });

        }

    }

}
