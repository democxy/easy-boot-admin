package com.democxy.modules.sys.service.impl;

import com.democxy.common.config.SystemConstant;
import com.democxy.common.global.BaseServiceImpl;
import com.democxy.common.runtime.CronTaskRegistrar;
import com.democxy.common.runtime.SchedulingRunnable;
import com.democxy.common.utils.IdGenUtil;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.sys.dao.TaskJobDao;
import com.democxy.modules.sys.entity.TaskJob;
import com.democxy.modules.sys.entity.field.TaskJobField;
import com.democxy.modules.sys.service.TaskJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shiling_deng
 */
@Service
public class TaskJobServiceImpl extends BaseServiceImpl<TaskJobDao, TaskJob, TaskJobField> implements TaskJobService {

    @Autowired
    CronTaskRegistrar cronTaskRegistrar;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(TaskJobField entity) {
        int result = 0;
        if (StringUtils.isEmpty(entity.getId())){
            entity.setId(IdGenUtil.getUUID());
            result = dao.insert(entity);
        }else {
            TaskJob taskJob = dao.getById(entity.getId());
            result = dao.update(entity);
            // 先判断之前的任务是否为开启状态 开启的就先移除
            SchedulingRunnable task = new SchedulingRunnable(taskJob.getTaskName(), taskJob.getMethodName(), taskJob.getMethodParams());
            cronTaskRegistrar.removeCronTask(task);
        }
        // 如果是启动状态的 开启定时任务
        if (SystemConstant.TASK_JOB_START.equals(entity.getTaskStatus())) {
            SchedulingRunnable task = new SchedulingRunnable(entity.getTaskName(), entity.getMethodName(), entity.getMethodParams());
            cronTaskRegistrar.addCronTask(task, entity.getCronType());
        }
        return result;
    }
}
