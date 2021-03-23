package com.democxy.modules.gen.controller;

import com.democxy.common.annotation.PassLogin;
import com.democxy.common.annotation.Permission;
import com.democxy.common.enums.ResultEnum;
import com.democxy.common.global.BaseController;
import com.democxy.common.global.BasePageQuery;
import com.democxy.common.global.ResponeData;
import com.democxy.common.utils.FileUtils;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.gen.entity.GenTable;
import com.democxy.modules.gen.entity.GenTableColumn;
import com.democxy.modules.gen.entity.field.GenTableColumnField;
import com.democxy.modules.gen.entity.field.GenTableField;
import com.democxy.modules.gen.service.GenTableColumnService;
import com.democxy.modules.gen.service.GenTableService;
import com.democxy.modules.gen.utils.GenCodeUtil;
import com.democxy.modules.gen.vo.PreViewCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shiling_deng
 */
@CrossOrigin
@RestController
@RequestMapping("gen/genTable")
public class GenTableController extends BaseController<GenTableService, GenTable, GenTableField> {

    private final String PREFIX = "gen/";

    @Autowired
    GenTableColumnService genTableColumnService;
    @Autowired
    GenCodeUtil genCodeUtil;

    @RequestMapping("")
    @Permission(value = "gen:genTable:view")
    @PassLogin
    private ModelAndView genTable() {
        ModelAndView modelAndView = new ModelAndView(PREFIX + "genTableList");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "findAllTableForDatabase",method = RequestMethod.POST)
    public ResponeData<PageInfo> findAllTableForDatabase(@RequestBody BasePageQuery<GenTableField> basePageQuery){
        //调用业务逻辑，处理业务
        PageHelper.startPage(basePageQuery.getPageNum(), basePageQuery.getPageSize());
        List<GenTable> list = service.selectAllTableForDatabase();
        PageInfo<GenTable> pageInfo = new PageInfo<GenTable>(list,5);
        return new ResponeData<>(ResultEnum.SUCCESS, pageInfo);
    }

    @GetMapping("importTable")
    @Permission(value = "gen:genTable:view")
    @PassLogin
    private ModelAndView importTable() {
        ModelAndView modelAndView = new ModelAndView(PREFIX + "genTableImport");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping(value = "importTable")
    public ResponeData<String> addGenTableForTableName(@RequestBody List<String> tableNames ){
        //调用业务逻辑，处理业务
        service.addGenTableForTableName(tableNames);
        return new ResponeData<>("导入表成功");
    }

    @RequestMapping("form")
    @Permission(value = "gen:genTable:add")
    @PassLogin
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



    @ResponseBody
    @RequestMapping(value = "gen/{id}",method = RequestMethod.GET)
    public ResponeData<String> gen(@PathVariable("id") String id){
        List<PreViewCode> preViewCodes = service.preViewCode(id);
        try {
            for (PreViewCode preViewCode : preViewCodes) {
                FileUtils.writeStringToFile(new File(preViewCode.getFilePath() + "/" + preViewCode.getFileName()),
                        preViewCode.getCode(), "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponeData<>(ResultEnum.SUCCESS,"代码生成成功");
    }
}