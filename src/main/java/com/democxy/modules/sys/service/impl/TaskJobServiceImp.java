package com.democxy.modules.sys.service.impl;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.modules.sys.dao.TaskJobDao;
import com.democxy.modules.sys.entity.TaskJob;
import com.democxy.modules.sys.entity.field.TaskJobField;
import com.democxy.modules.sys.service.TaskJobService;
import org.springframework.stereotype.Service;

@Service
public class TaskJobServiceImp extends BaseServiceImp<TaskJobDao, TaskJob, TaskJobField> implements TaskJobService {
}
