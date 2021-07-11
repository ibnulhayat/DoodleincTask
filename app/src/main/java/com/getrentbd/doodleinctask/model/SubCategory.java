package com.getrentbd.doodleinctask.model;

public class SubCategory {
    private String subCateId;
    private String subCateName;
    private boolean select;

    public SubCategory(String subCateId, String subCateName,boolean select) {
        this.subCateId = subCateId;
        this.subCateName = subCateName;
        this.select = select;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getSubCateId() {
        return subCateId;
    }

    public void setSubCateId(String subCateId) {
        this.subCateId = subCateId;
    }

    public String getSubCateName() {
        return subCateName;
    }

    public void setSubCateName(String subCateName) {
        this.subCateName = subCateName;
    }
}
