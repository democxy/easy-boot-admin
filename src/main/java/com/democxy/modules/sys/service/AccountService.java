package com.democxy.modules.sys.service;

import com.democxy.common.global.BaseService;
import com.democxy.modules.sys.entity.Account;

public interface AccountService extends BaseService<Account> {

    Account login(Account account);

}
