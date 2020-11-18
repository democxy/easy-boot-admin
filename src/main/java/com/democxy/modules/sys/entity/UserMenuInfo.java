package com.democxy.modules.sys.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 对应框架初始化菜单数据实体模型
 */
@Data
public class UserMenuInfo {

    private String title;
    private String href;
    private String  icon;
    private String target;
    private List<UserMenuInfo> child;

    public List<UserMenuInfo> sortMenuList(List<Menu> menuList) {
        List<UserMenuInfo> list = new ArrayList<>();
        for (Menu menu : menuList) {
            UserMenuInfo userMenuInfo = new UserMenuInfo();
            userMenuInfo.setTitle(menu.getMenuName());
            userMenuInfo.setHref(menu.getHref());
            userMenuInfo.setIcon(menu.getIcon());
            userMenuInfo.setTarget(menu.getTarget());
            List<Menu> children = menu.getChildren();
            if (children!=null && children.size()>0){
                List<UserMenuInfo> list1 = sortMenuList(children);
                userMenuInfo.setChild(list1);
            }
            list.add(userMenuInfo);
        }
        return list;
    }
}
