package com.democxy.modules.gen.service.impl;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.modules.gen.dao.TemplateInfoDao;
import com.democxy.modules.gen.entity.TemplateInfo;
import com.democxy.modules.gen.entity.field.TemplateInfoField;
import com.democxy.modules.gen.service.TemplateInfoService;
import org.springframework.stereotype.Service;

@Service
public class TemplateInfoServiceImp extends BaseServiceImp<TemplateInfoDao, TemplateInfo, TemplateInfoField> implements TemplateInfoService {

}