package com.getrentbd.doodleinctask.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.getrentbd.doodleinctask.Common;
import com.getrentbd.doodleinctask.R;
import com.getrentbd.doodleinctask.model.CategoryList;
import com.getrentbd.doodleinctask.model.SubCategory;

import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<SubCategory> subCategoryList;

    public SubCategoryAdapter(List<SubCategory> list) {
        this.subCategoryList = list;
    }

    @NonNull
    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sub_category_item_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int i) {
        ViewHolder viewHolder = (ViewHolder) holder;

        final SubCategory list = subCategoryList.get(i);
        final String sub_cat_name = list.getSubCateName();
        final boolean isSelect = list.isSelect();
        viewHolder.subCategoryName.setText(sub_cat_name);

        if (isSelect) {
            viewHolder.ivSubCategory.setImageResource(R.drawable.ic_baseline_check_24);
        } else {
            viewHolder.ivSubCategory.setImageResource(R.drawable.ic_baseline_add_24);
        }

        viewHolder.ivSubCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubCategory subList = list;
                if (!list.isSelect()) {
                    subList.setSelect(true);
                    viewHolder.ivSubCategory.setImageResource(R.drawable.ic_baseline_check_24);
                } else {
                    subList.setSelect(false);
                    viewHolder.ivSubCategory.setImageResource(R.drawable.ic_baseline_add_24);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return subCategoryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subCategoryName;
        ImageView ivSubCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subCategoryName = itemView.findViewById(R.id.tvSubCategoryName);
            ivSubCategory = itemView.findViewById(R.id.ivSubCategory);

        }
    }
}
