package com.democxy.common.runtime.task;

import org.springframework.stereotype.Component;

/**
 * @author shiling_deng
 */
@Component("demoTask")
public class DemoTask {
    public void taskWithParams(String params) {
        System.out.println("执行有参示例任务：" + params);
    }

    public void taskNoParams() {
        System.out.println("执行无参示例任务");
    }
}
