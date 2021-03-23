package com.democxy.modules.sys.dao;

import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.Dict;
import com.democxy.modules.sys.entity.field.DictField;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shiling_deng
 */
@Mapper
public interface DictDao extends BaseDao<Dict, DictField> {

    /**
     * 查询字典类型列表
     * @param dictField
     * @return 字典类型列表
     */
    List<Dict> findDistinct (DictField dictField);
}
