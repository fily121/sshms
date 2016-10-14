/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.vo.relate;

import cn.com.sinoi.zyqyh.vo.Permission;
import cn.com.sinoi.zyqyh.vo.Role;
import java.util.List;

/**
 *
 */
public class RolePermission {

    private Role role;
    private List<Permission> permissions;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}
