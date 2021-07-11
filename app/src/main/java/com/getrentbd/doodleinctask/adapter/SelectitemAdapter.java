package com.getrentbd.doodleinctask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.getrentbd.doodleinctask.R;
import com.getrentbd.doodleinctask.model.SubCategory;

import java.util.List;


public class SelectitemAdapter extends RecyclerView.Adapter<SelectitemAdapter.MiniViewHolder> {

    Context context;
    List<String> listItem;


    public SelectitemAdapter(Context context, List<String> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    @NonNull
    @Override

    public SelectitemAdapter.MiniViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View view = layoutInflater.inflate(R.layout.select_item_view, viewGroup, false);
        return new MiniViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SelectitemAdapter.MiniViewHolder miniViewHolder, int i) {

        final String sub_cat_name = listItem.get(i);
        miniViewHolder.subCategoryName.setText(sub_cat_name);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }


    public class MiniViewHolder extends RecyclerView.ViewHolder {
        TextView subCategoryName;
        public MiniViewHolder(@NonNull View itemView) {
            super(itemView);
            subCategoryName = itemView.findViewById(R.id.tvSubCategoryName);

        }
    }
}
