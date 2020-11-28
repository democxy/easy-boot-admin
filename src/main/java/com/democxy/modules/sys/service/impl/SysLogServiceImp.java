package com.democxy.modules.sys.service.impl;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.modules.sys.dao.SysLogDao;
import com.democxy.modules.sys.entity.SysLog;
import com.democxy.modules.sys.entity.field.SysLogField;
import com.democxy.modules.sys.service.SysLogService;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImp extends BaseServiceImp<SysLogDao,SysLog, SysLogField> implements SysLogService {
}
