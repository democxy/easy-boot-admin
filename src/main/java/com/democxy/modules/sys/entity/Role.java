package com.democxy.modules.sys.entity;

import lombok.Data;

/**
 * 系统角色实体类
 * @author shiling_deng
 * @version 2020-11-01
 */
@Data
public class Role {

    // 系统ID
    private String id;

    // 角色名称
    private String roleName;

    // 角色表示（及角色英文名称）
    private String roleFlag;

    // 校色数据范围（备用字段，暂时无业务作用）
    private String dataScope;

    // 角色状态
    private String status;
}
