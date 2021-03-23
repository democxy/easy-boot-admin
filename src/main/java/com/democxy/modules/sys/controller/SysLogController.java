package com.democxy.modules.sys.controller;

import com.democxy.common.global.BaseController;
import com.democxy.modules.sys.entity.SysLog;
import com.democxy.modules.sys.entity.field.SysLogField;
import com.democxy.modules.sys.service.SysLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiling_deng
 */
@RestController
@RequestMapping("/admin/sysLog")
public class SysLogController extends BaseController<SysLogService, SysLog, SysLogField> {
}
