package com.skynet.collection.vo;

public class RolePersKey {
	
    private String roleId;

    private String perId;

	public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPerId() {
        return perId;
    }

	public void setPerId(String perId) {
        this.perId = perId == null ? null : perId.trim();
    }
}