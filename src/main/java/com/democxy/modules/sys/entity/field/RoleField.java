package com.democxy.modules.sys.entity.field;

import com.democxy.common.global.BaseFiled;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 系统角色实体类
 * @author shiling_deng
 * @version 2020-11-01
 */
@Data
public class RoleField extends BaseFiled<RoleField> {

    // 角色名称
    @NotNull(message = "角色名不能为空")
    private String roleName;

    // 角色表示（及角色英文名称）
    @NotNull( message = "角色标识不能为空")
    @Size(min = 4, max = 8, message = "角色标识必须介于4-8之间")
    private String roleFlag;

    // 校色数据范围（备用字段，暂时无业务作用）
    private String dataScope;

    // 角色状态
    private String status;
}
