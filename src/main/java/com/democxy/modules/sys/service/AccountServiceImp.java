package com.democxy.modules.sys.service;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.modules.sys.dao.AccountDao;
import com.democxy.modules.sys.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp extends BaseServiceImp<AccountDao,Account>  implements AccountService {

    @Override
    public Account login(Account account) {
        return dao.login(account);
    }
}
