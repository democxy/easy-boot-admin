package com.democxy.modules.sys.service;

import com.democxy.modules.sys.dao.AccountDao;
import com.democxy.modules.sys.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public Account getById(String accountId) {
        return accountDao.getById(accountId);
    }

    @Override
    public Account login(Account account) {
        return accountDao.login(account);
    }

    @Override
    public List<Account> findList(Account account) {
        return accountDao.findList(account);
    }

    @Override
    public int insert(Account account) {
        return accountDao.insert(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public int delete(String accountId) {
        return accountDao.delete(accountId);
    }
}
