package com.democxy.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.modules.sys.dao.NoticeDao;
import com.democxy.modules.sys.entity.Notice;
import com.democxy.modules.sys.entity.field.NoticeField;
import com.democxy.modules.sys.service.NoticeService;

@Service
public class NoticeServiceImp extends BaseServiceImp<NoticeDao, Notice, NoticeField> implements NoticeService {

}