package com.democxy.modules.sys.entity.field;

import com.democxy.common.global.BaseFiled;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shiling_deng
 */
@Data
public class MenuField extends BaseFiled<MenuField> {

    /**
     * 权限字段标识
     */
    private String permission = "sys:menu";

    /**
     * 菜单名称
     */
    @NotNull(message = "角色名不能为空")
    private String menuName;

    /**
     * 父菜单名称
     */
    private String parentName;

    /**
     * 父菜单ID
     */
    private String parentId;

    /**
     * 显示顺序
     */
    private String orderNum;

    /**
     * 菜单URL
     */
    private String href;

    /**
     * 打开方式：menuItem页签 menuBlank新窗口
     */
    private String target;

    /**
     * 类型:0目录,1菜单,2按钮
     */
    private String menuType;

    /**
     * 菜单状态:0显示,1隐藏
     */
    private String visible;

    /**
     * 权限字符串
     */
    private String perms;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 子菜单
     */
    private List<MenuField> children = new ArrayList<MenuField>();
}
