package com.getrentbd.doodleinctask.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.getrentbd.doodleinctask.Common;
import com.getrentbd.doodleinctask.R;
import com.getrentbd.doodleinctask.model.CategoryList;
import com.getrentbd.doodleinctask.model.SubCategory;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<CategoryList> categoryList;
    SubCategoryAdapter subCategoryAdapter;

    public CategoryListAdapter( List<CategoryList> list) {
        this.categoryList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View view = layoutInflater.inflate(R.layout.category_item_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int i) {

        ViewHolder viewHolder = (ViewHolder) holder;

        final CategoryList cat_list = categoryList.get(i);
        final String cat_name = cat_list.getCategoryName();
        final boolean isSelect = cat_list.isSelect();
        final boolean isExpended = cat_list.isExtended();
        viewHolder.categoryName.setText(cat_name);

        viewHolder.expandableView(cat_list.getSubCategory());

        if (isSelect) {
            viewHolder.ivPlus.setImageResource(R.drawable.ic_baseline_check_24);
        } else {
            viewHolder.ivPlus.setImageResource(R.drawable.ic_baseline_add_24);
        }

        if(!isExpended){
            viewHolder.imageView3.setImageResource(R.drawable.arrow_forward_ios_24);
        }else {
            viewHolder.imageView3.setImageResource(R.drawable.arrow_forward_ios_24);
            viewHolder.imageView3.animate().rotation(90).start();
        }

        viewHolder.extendedLayout.setVisibility(isExpended ? View.VISIBLE : View.GONE);

        viewHolder.ivPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!cat_list.isSelect()) {
                    viewHolder.ivPlus.setImageResource(R.drawable.ic_baseline_check_24);
                    cat_list.setSelect(true);
                    for(int j=0; j < cat_list.getSubCategory().size(); j++){
                        cat_list.getSubCategory().get(j).setSelect(true);
                    }
                    viewHolder.expandableView(cat_list.getSubCategory());
                } else {
                    viewHolder.ivPlus.setImageResource(R.drawable.ic_baseline_add_24);
                    cat_list.setSelect(false);
                    for(int k=0; k < cat_list.getSubCategory().size(); k++){
                        cat_list.getSubCategory().get(k).setSelect(false);
                    }
                    viewHolder.expandableView(cat_list.getSubCategory());
                }

            }
        });

    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout, extendedLayout;
        TextView categoryName;
        ImageView imageView3;
        ImageView ivPlus;
        RecyclerView rvSubCategoryList;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            imageView3 = itemView.findViewById(R.id.imageView3);
            categoryName = itemView.findViewById(R.id.tvSubCategoryName);
            ivPlus = itemView.findViewById(R.id.ivCategory);
            rvSubCategoryList = itemView.findViewById(R.id.rvSubCategoryList);
            extendedLayout = itemView.findViewById(R.id.extendedLayout);

            categoryName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CategoryList list = categoryList.get(getAdapterPosition());
                    list.setExtended(!list.isExtended());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }

        public void expandableView(List<SubCategory> subCategories){
            rvSubCategoryList.setLayoutManager(new LinearLayoutManager(context));
            subCategoryAdapter = new SubCategoryAdapter(subCategories);
            rvSubCategoryList.setAdapter(subCategoryAdapter);
            subCategoryAdapter.notifyDataSetChanged();
        }

    }
}
