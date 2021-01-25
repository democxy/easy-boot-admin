package com.democxy.modules.gen.controller;

import com.democxy.common.annotation.Permission;
import com.democxy.common.global.BaseController;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.gen.entity.GenTable;
import com.democxy.modules.gen.entity.GenTableColumn;
import com.democxy.modules.gen.entity.field.GenTableColumnField;
import com.democxy.modules.gen.entity.field.GenTableField;
import com.democxy.modules.gen.service.GenTableColumnService;
import com.democxy.modules.gen.service.GenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("gen/genTable")
public class GenTableController extends BaseController<GenTableService, GenTable, GenTableField> {

    private final String PREFIX = "gen/";

    @Autowired
    GenTableColumnService genTableColumnService;

    @RequestMapping("")
    @Permission(value = "gen:genTable:view")
    private ModelAndView genTable() {
        ModelAndView modelAndView = new ModelAndView(PREFIX + "genTableList");
        return modelAndView;
    }

    @RequestMapping("form")
    @Permission(value = "gen:genTable:add")
    public ModelAndView courseTypeForm(String id) {
        ModelAndView modelAndView = new ModelAndView(PREFIX + "genTableForm");
        if (StringUtils.isEmpty(id)) {
            GenTable genTable = new GenTable();
            genTable.setColumnList(new ArrayList<>());
            modelAndView.addObject("genTable", genTable);
        } else {
            GenTableColumnField query = new GenTableColumnField();
            query.setGenTableId(id);
            List<GenTableColumn> list = genTableColumnService.findList(query);
            GenTable genTable = service.getById(id);
            genTable.setColumnList(list);
            modelAndView.addObject("genTable", genTable);
        }
        return modelAndView;
    }
}