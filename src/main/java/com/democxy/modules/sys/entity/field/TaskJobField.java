package com.democxy.modules.sys.entity.field;

import com.democxy.common.global.BaseFiled;
import com.democxy.modules.sys.entity.TaskJob;
import lombok.Data;

@Data
public class TaskJobField extends BaseFiled<TaskJobField> {

    private String taskName;

    private String methodName;

    private String methodParams;

    private String cronType;

    private String remark;

    private String taskStatus;

}
