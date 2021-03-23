package com.democxy.modules.sys.service.impl;

import com.democxy.common.global.BaseServiceImpl;
import com.democxy.modules.sys.dao.TaskJobDao;
import com.democxy.modules.sys.entity.TaskJob;
import com.democxy.modules.sys.entity.field.TaskJobField;
import com.democxy.modules.sys.service.TaskJobService;
import org.springframework.stereotype.Service;

/**
 * @author shiling_deng
 */
@Service
public class TaskJobServiceImpl extends BaseServiceImpl<TaskJobDao, TaskJob, TaskJobField> implements TaskJobService {
}
