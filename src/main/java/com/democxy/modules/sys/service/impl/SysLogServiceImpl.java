package com.democxy.modules.sys.service.impl;

import com.democxy.common.global.BaseServiceImpl;
import com.democxy.modules.sys.dao.SysLogDao;
import com.democxy.modules.sys.entity.SysLog;
import com.democxy.modules.sys.entity.field.SysLogField;
import com.democxy.modules.sys.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * @author shiling_deng
 */
@Service
public class SysLogServiceImpl extends BaseServiceImpl<SysLogDao,SysLog, SysLogField> implements SysLogService {
}
