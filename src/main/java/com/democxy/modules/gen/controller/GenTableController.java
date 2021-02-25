package com.democxy.modules.gen.controller;

import com.democxy.common.annotation.LoginRequired;
import com.democxy.common.annotation.Permission;
import com.democxy.common.enums.ResultEnum;
import com.democxy.common.global.BaseController;
import com.democxy.common.global.ResponeData;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.gen.entity.GenTable;
import com.democxy.modules.gen.entity.GenTableColumn;
import com.democxy.modules.gen.entity.field.GenTableColumnField;
import com.democxy.modules.gen.entity.field.GenTableField;
import com.democxy.modules.gen.service.GenTableColumnService;
import com.democxy.modules.gen.service.GenTableService;
import com.democxy.modules.gen.utils.GenCodeUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @RequestMapping(value = "gen/{id}",method = RequestMethod.GET)
    @LoginRequired
    public ResponeData<String> gen(@PathVariable("id") String id){
        GenTable genTable = service.getById(id);
        GenTableColumnField query = new GenTableColumnField();
        query.setGenTableId(id);
        List<GenTableColumn> list = genTableColumnService.findList(query);
        genTable.setColumnList(list);
        // 引用列表
        List<String> importList = Lists.newArrayList();
        for (GenTableColumn genTableColumn : list) {
            // 导入类型依赖包， 如果类型中包含“.”，则需要导入引用。
            if (StringUtils.indexOf(genTableColumn.getJavaType(), ".") != -1 && !importList.contains(genTableColumn.getJavaType())){
                importList.add(genTableColumn.getJavaType());
                genTableColumn.setJavaType(genTableColumn.getJavaType().substring(genTableColumn.getJavaType().lastIndexOf(".") + 1));
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("packageName", genTable.getPackageName());
        map.put("moduleName", genTable.getModelName());
        map.put("ClassName", genTable.getClassName());
        map.put("className", StringUtils.toLowerForFistChar(genTable.getClassName()));
        map.put("columnList", list);
        map.put("table", genTable);
        map.put("importList", importList);
        String filePath = "F://gencode/" + genTable.getPackageName() + "/" + genTable.getModelName() ;
        genCodeUtil.genCode("codetemp/entity.ftl",map,filePath+ "/entity/" +genTable.getClassName()+ ".java");
        genCodeUtil.genCode("codetemp/filed.ftl",map,filePath+ "/entity/field/" +genTable.getClassName()+ "Filed.java");
        genCodeUtil.genCode("codetemp/service.ftl",map,filePath+ "/service/" +genTable.getClassName()+ "Service.java");
        genCodeUtil.genCode("codetemp/serviceImp.ftl",map,filePath+ "/service/impl/" +genTable.getClassName()+ "ServiceImp.java");
        genCodeUtil.genCode("codetemp/dao.ftl",map,filePath+ "/dao/" +genTable.getClassName()+ "Dao.java");
        genCodeUtil.genCode("codetemp/controller.ftl",map,filePath+ "/controller/" +genTable.getClassName()+ "Controller.java");
        genCodeUtil.genCode("codetemp/mapper.ftl",map,filePath+ "/mapper/" +genTable.getClassName()+ "Dao.xml");
        genCodeUtil.genCode("codetemp/viewList.ftl",map,filePath+ "/view/" +genTable.getClassName()+ "List.html");
        genCodeUtil.genCode("codetemp/viewForm.ftl",map,filePath+ "/view/" +genTable.getClassName()+ "Form.html");

        return new ResponeData<>(ResultEnum.SUCCESS,"代码生成成功");
    }
}