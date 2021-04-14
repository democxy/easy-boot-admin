package com.democxy.modules.sys.service;

import com.democxy.common.global.BaseService;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.entity.field.AccountField;
import com.democxy.modules.sys.entity.field.LoginField;

/**
 * @author shiling_deng
 */
public interface AccountService extends BaseService< Account,AccountField> {

    /**
     * 登录
     * @param accountField
     * @return 登录对象
     */
    Account login(LoginField accountField);

}
