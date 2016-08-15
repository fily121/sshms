package com.skynet.collection.vo;

public class Permission {
    private String perId;

    private String perName;

    private String parentPerId;

    private String perUrl;

    public String getPerId() {
        return perId;
    }

    public void setPerId(String perId) {
        this.perId = perId == null ? null : perId.trim();
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName == null ? null : perName.trim();
    }

    public String getParentPerId() {
        return parentPerId;
    }

    public void setParentPerId(String parentPerId) {
        this.parentPerId = parentPerId == null ? null : parentPerId.trim();
    }

    public String getPerUrl() {
        return perUrl;
    }

    public void setPerUrl(String perUrl) {
        this.perUrl = perUrl == null ? null : perUrl.trim();
    }
}