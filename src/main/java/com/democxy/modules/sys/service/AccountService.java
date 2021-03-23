package com.democxy.modules.sys.service;

import com.democxy.common.global.BaseService;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.entity.field.AccountField;

/**
 * @author shiling_deng
 */
public interface AccountService extends BaseService< Account,AccountField> {

    /**
     * 登录
     * @param accountField
     * @return 登录对象
     */
    Account login(AccountField accountField);

}
