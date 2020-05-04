package com.democxy.modules.sys.service;

import com.democxy.modules.sys.entity.Account;

import java.util.List;

public interface AccountService {


    public Account getById(String accountId);

    public Account login(Account account);

    public List<Account> findList(Account account);

    public int insert(Account account);

    public int update(Account account);

    public int delete(String accountId);
}
