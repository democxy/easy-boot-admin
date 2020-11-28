package com.democxy.common.config;

import com.democxy.common.global.SystemCache;
import com.democxy.common.runtime.CronTaskRegistrar;
import com.democxy.common.runtime.SchedulingRunnable;
import com.democxy.modules.sys.entity.Menu;
import com.democxy.modules.sys.entity.Role;
import com.democxy.modules.sys.entity.TaskJob;
import com.democxy.modules.sys.entity.field.RoleField;
import com.democxy.modules.sys.entity.field.TaskJobField;
import com.democxy.modules.sys.service.MenuService;
import com.democxy.modules.sys.service.RoleService;
import com.democxy.modules.sys.service.TaskJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SystemConfig implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(SystemConfig.class);

    @Autowired
    MenuService menuService;
    @Autowired
    RoleService roleService;
    @Autowired
    TaskJobService taskJobService;
    @Autowired
    CronTaskRegistrar cronTaskRegistrar;

    @Override
    public void run(String... args) throws Exception {
        logger.info("初始化RBAC数据......");
        List<Role> roleList = roleService.findList(new RoleField());
        for (Role role : roleList) {
            Set<String> set = menuService.getPermsForRole(Integer.parseInt(role.getId()));
            SystemCache.ROLE_MENU_CACHE.put(role.getId(),set);
        }
        logger.info("初始化RBAC数据完成......");
        logger.info("初始化定时任务......");
        TaskJobField taskJobField = new TaskJobField();
        taskJobField.setTaskStatus("1");
        List<TaskJob> tasks = taskJobService.findList(taskJobField);
        for (TaskJob task : tasks) {
            SchedulingRunnable taskRunnable = new SchedulingRunnable(task.getTaskName(), task.getMethodName(), task.getMethodParams());
            cronTaskRegistrar.addCronTask(taskRunnable, task.getCronType());
            logger.info("定时任务"+task.getTaskName()+"-"+task.getMethodName()+"启动成功...");
        }
        logger.info("定时任务加载完毕......");
    }
}
