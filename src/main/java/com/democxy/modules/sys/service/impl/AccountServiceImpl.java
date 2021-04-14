package com.democxy.modules.sys.service.impl;

import com.democxy.common.global.BaseServiceImpl;
import com.democxy.modules.sys.dao.AccountDao;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.entity.field.AccountField;
import com.democxy.modules.sys.entity.field.LoginField;
import com.democxy.modules.sys.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author shiling_deng
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<AccountDao, Account, AccountField> implements AccountService {

    @Override
    public Account login(LoginField accountField) {
        return dao.login(accountField);
    }
}
