package com.democxy.common.global;

import com.democxy.modules.sys.entity.Menu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    private boolean spread ;

    private boolean checked;

    private boolean disabled ;


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

    /**
     * 复选框回显
     * @param menuList
     * @param checks
     * @return
     */
    public List<TreeEntity> sortMenuList(List<Menu> menuList, Set<String> checks) {
        List<TreeEntity> list = new ArrayList<>();
        for (Menu menu : menuList) {
            TreeEntity treeEntity = new TreeEntity();
            treeEntity.setId(menu.getId());
            treeEntity.setTitle(menu.getMenuName());

            List<Menu> children = menu.getChildren();
            if (children!=null && children.size()>0){
                treeEntity.setSpread(true); //默认展开
                checks.remove(menu.getId()); //移除父节点的勾选
                List<TreeEntity> list1 = sortMenuList(children,checks); //递归处理子集
                treeEntity.setChildren(list1);
            }
            if (checks.contains(menu.getId())){
                treeEntity.setChecked(true); //设置选中
            }
            list.add(treeEntity);
        }
        return list;
    }
}
