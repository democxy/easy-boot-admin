package com.democxy.modules.sys.service.impl;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.modules.sys.dao.SysFilesDao;
import com.democxy.modules.sys.entity.SysFiles;
import com.democxy.modules.sys.entity.field.SysFilesField;
import com.democxy.modules.sys.service.SysFilesService;
import org.springframework.stereotype.Service;

@Service
public class SysFilesServiceImp extends BaseServiceImp<SysFilesDao, SysFiles, SysFilesField> implements SysFilesService {

}