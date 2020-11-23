package com.democxy.modules.sys.controller;

import com.democxy.common.global.BaseController;
import com.democxy.modules.sys.entity.Dict;
import com.democxy.modules.sys.entity.field.DictField;
import com.democxy.modules.sys.service.DictService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/dict")
public class DictController extends BaseController<DictService, Dict, DictField> {
}
