package com.democxy.modules.sys.dao;

import com.democxy.modules.sys.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountDao {

    public Account getById(String accountId);

    public Account login(Account account);

    public List<Account> findList(Account account);

    public int insert(Account account);

    public int update(Account account);

    public int delete(String accountId);
}
