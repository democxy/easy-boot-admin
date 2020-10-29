package com.democxy.modules.sys.service;

import com.democxy.common.global.BaseService;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.entity.AccountField;

public interface AccountService extends BaseService< Account,AccountField> {

    Account login(AccountField accountField);

}
