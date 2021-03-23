package com.democxy.modules.sys.dao;

import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.SysLog;
import com.democxy.modules.sys.entity.field.SysLogField;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shiling_deng
 */
@Mapper
public interface SysLogDao extends BaseDao<SysLog, SysLogField> {
}
