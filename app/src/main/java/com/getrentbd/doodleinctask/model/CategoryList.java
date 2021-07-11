package com.getrentbd.doodleinctask.model;

import java.util.List;

public class CategoryList {

    private String categoryId;
    private String categoryName;
    private List<SubCategory> subCategory;
    private boolean extended;
    private boolean select;

    public CategoryList(String categoryId, String categoryName, List<SubCategory> subCategory) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.subCategory = subCategory;
        this.extended = false;
        this.select = false;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isExtended() {
        return extended;
    }

    public void setExtended(boolean extended) {
        this.extended = extended;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<SubCategory> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(List<SubCategory> subCategory) {
        this.subCategory = subCategory;
    }
}
