package com.democxy.modules.sys.dao;

import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.Notice;
import com.democxy.modules.sys.entity.field.NoticeField;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeDao extends BaseDao<Notice, NoticeField> {

}