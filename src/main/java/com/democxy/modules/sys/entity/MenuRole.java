package com.democxy.modules.sys.entity;

import lombok.Data;

@Data
public class MenuRole {

    private String menuId;

    private String roleId;

    public MenuRole(String menuId, String roleId) {
        this.menuId = menuId;
        this.roleId = roleId;
    }
}
