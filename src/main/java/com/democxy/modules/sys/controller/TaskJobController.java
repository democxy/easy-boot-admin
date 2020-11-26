package com.democxy.modules.sys.controller;

import com.democxy.common.global.BaseController;
import com.democxy.common.global.ResponeData;
import com.democxy.common.runtime.CronTaskRegistrar;
import com.democxy.common.runtime.SchedulingRunnable;
import com.democxy.modules.sys.entity.TaskJob;
import com.democxy.modules.sys.entity.field.TaskJobField;
import com.democxy.modules.sys.service.TaskJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/taskJob")
public class TaskJobController extends BaseController<TaskJobService, TaskJob, TaskJobField> {

    private Logger logger = LoggerFactory.getLogger(TaskJobController.class);

    @Autowired
    CronTaskRegistrar cronTaskRegistrar;

    @GetMapping("execTask")
    public ResponeData<String> startOrStop(String id){
        TaskJob taskJob = service.getById(id);
        if ("1".equals(taskJob.getTaskStatus())) {
            // 停止
            SchedulingRunnable task = new SchedulingRunnable(taskJob.getTaskName(), taskJob.getMethodName(), taskJob.getMethodParams());
            cronTaskRegistrar.removeCronTask(task);
            logger.info("定时任务"+taskJob.getTaskName()+"-"+taskJob.getMethodName()+"停止执行...");
            taskJob.setTaskStatus("0");
            service.update(getField(taskJob));
            return new ResponeData<>("任务已停止！");
        } else {
            // 启动
            SchedulingRunnable task = new SchedulingRunnable(taskJob.getTaskName(), taskJob.getMethodName(), taskJob.getMethodParams());
            cronTaskRegistrar.addCronTask(task, taskJob.getCronType());
            logger.info("定时任务"+taskJob.getTaskName()+"-"+taskJob.getMethodName()+"启动成功...");
            taskJob.setTaskStatus("1");
            service.update(getField(taskJob));
            return new ResponeData<>("任务已启用！");
        }
    }

    private TaskJobField getField(TaskJob taskJob) {
        TaskJobField taskJobField = new TaskJobField();
        taskJobField.setId(taskJob.getId());
        taskJobField.setTaskName(taskJob.getTaskName());
        taskJobField.setMethodName(taskJob.getMethodName());
        taskJobField.setMethodParams(taskJob.getMethodParams());
        taskJobField.setCronType(taskJob.getCronType());
        taskJobField.setRemark(taskJob.getRemark());
        taskJobField.setTaskStatus(taskJob.getTaskStatus());
        return taskJobField;
    }
}
