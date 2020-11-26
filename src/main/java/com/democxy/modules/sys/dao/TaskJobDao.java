package com.democxy.modules.sys.dao;

import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.TaskJob;
import com.democxy.modules.sys.entity.field.TaskJobField;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskJobDao extends BaseDao<TaskJob, TaskJobField> {
}
