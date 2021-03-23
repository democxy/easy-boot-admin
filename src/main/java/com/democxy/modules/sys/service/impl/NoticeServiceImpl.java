package com.democxy.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import com.democxy.common.global.BaseServiceImpl;
import com.democxy.modules.sys.dao.NoticeDao;
import com.democxy.modules.sys.entity.Notice;
import com.democxy.modules.sys.entity.field.NoticeField;
import com.democxy.modules.sys.service.NoticeService;

/**
 * @author shiling_deng
 */
@Service
public class NoticeServiceImpl extends BaseServiceImpl<NoticeDao, Notice, NoticeField> implements NoticeService {

}