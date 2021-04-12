package com.democxy.modules.sys.controller;

import com.democxy.common.global.BaseController;
import com.democxy.common.global.ResponeData;
import com.democxy.common.runtime.CronTaskRegistrar;
import com.democxy.common.runtime.SchedulingRunnable;
import com.democxy.common.utils.DateUtils;
import com.democxy.modules.sys.entity.TaskJob;
import com.democxy.modules.sys.entity.field.TaskJobField;
import com.democxy.modules.sys.service.TaskJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author shiling_deng
 */
@RestController
@RequestMapping("admin/taskJob")
public class TaskJobController extends BaseController<TaskJobService, TaskJob, TaskJobField> {

    private Logger logger = LoggerFactory.getLogger(TaskJobController.class);

    @Autowired
    CronTaskRegistrar cronTaskRegistrar;

    /**
     * 执行停止定时任务
     * @param id
     * @return
     */
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



    /**
     * 获取最近5次执行时间
     * @param cron
     * @return
     */
    @RequestMapping("getLatestExeTime")
    public ResponeData<List> getLatestExeTime(String cron) {
        ArrayList arrayList = new ArrayList();
        Date date = new Date();
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(cron);
        //下次执行时间
        Date time1 = cronSequenceGenerator.next(date);
        arrayList.add(DateUtils.formatDateTime(time1));

        Date time2 = cronSequenceGenerator.next(time1);
        arrayList.add(DateUtils.formatDateTime(time2));

        Date time3 = cronSequenceGenerator.next(time2);
        arrayList.add(DateUtils.formatDateTime(time3));

        Date time4 = cronSequenceGenerator.next(time3);
        arrayList.add(DateUtils.formatDateTime(time4));

        Date time5 = cronSequenceGenerator.next(time4);
        arrayList.add(DateUtils.formatDateTime(time5));
        return new ResponeData<>(arrayList);
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
