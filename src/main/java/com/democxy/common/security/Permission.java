package com.democxy.common.security;

import com.democxy.common.utils.ServletUtils;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 安全认证许可类
 * @author shiling_deng
 */
@Service("permission")
public class Permission {


    /**
     * 验证是否包含某一权限
     * @param perm
     * @return
     */
    public boolean check(String perm){
        Set<String> allPerms = getAllPerms();
        if (allPerms!=null && allPerms.contains(perm)){
            return true;
        }
        return false;
    }

    /**
     * 从session里面获取当前登录用户所有的按钮权限
     * @return
     */
    private Set<String> getAllPerms(){
        Object perms = ServletUtils.getSession().getAttribute("perms");
        if (perms!=null && perms instanceof  Set){
            Set<String> permsSet = (Set<String>)perms;
            return permsSet;
        }
        return null;
    }
}
