package com.democxy.modules.sys.dao;

import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.entity.field.AccountField;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDao extends BaseDao<Account,AccountField> {

    Account login(AccountField accountField);
}
