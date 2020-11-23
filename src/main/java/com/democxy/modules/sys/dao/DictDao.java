package com.democxy.modules.sys.dao;

import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.Dict;
import com.democxy.modules.sys.entity.field.DictField;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictDao extends BaseDao<Dict, DictField> {
}
