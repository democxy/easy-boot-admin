package com.democxy.modules.sys.dao;

import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.entity.field.AccountField;
import com.democxy.modules.sys.entity.field.LoginField;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shiling_deng
 */
@Mapper
public interface AccountDao extends BaseDao<Account,AccountField> {

    /**
     * 登录验证
     * @param accountField
     * @return 登录对象
     */
    Account login(LoginField accountField);
}
