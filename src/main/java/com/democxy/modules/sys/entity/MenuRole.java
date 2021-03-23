package com.democxy.modules.sys.entity;

import lombok.Data;

/**
 * @author shiling_deng
 */
@Data
public class MenuRole {

    private String menuId;

    private String roleId;

    public MenuRole(String menuId, String roleId) {
        this.menuId = menuId;
        this.roleId = roleId;
    }
}
