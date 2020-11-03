package com.democxy.common.global;

import com.democxy.modules.sys.entity.Menu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Layui树形控件对应实体类
 * @author shilingdeng
 * @version 20201103
 */
@Data
public class TreeEntity {

    private String id = "";

    private String title = "";

    private String field = "";

    private List<TreeEntity> children = new ArrayList<>();

    private String href = "";

    private String spread = "";

    private String checked = "";

    private String disabled = "";


    public List<TreeEntity> sortMenuList(List<Menu> menuList) {
        List<TreeEntity> list = new ArrayList<>();
        for (Menu menu : menuList) {
            TreeEntity treeEntity = new TreeEntity();
            treeEntity.setId(menu.getId());
            treeEntity.setTitle(menu.getMenuName());
            List<Menu> children = menu.getChildren();
            if (children!=null && children.size()>0){
                List<TreeEntity> list1 = sortMenuList(children);
                treeEntity.setChildren(list1);
            }
            list.add(treeEntity);
        }
        return list;
    }
}
