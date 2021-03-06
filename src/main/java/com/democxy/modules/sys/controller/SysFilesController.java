package com.democxy.modules.sys.controller;

import com.democxy.common.annotation.Log;
import com.democxy.common.annotation.PassLogin;
import com.democxy.common.annotation.Permission;
import com.democxy.common.config.ProjectConfig;
import com.democxy.common.enums.ResultEnum;
import com.democxy.common.global.BaseController;
import com.democxy.common.global.ResponeData;
import com.democxy.common.utils.DateUtils;
import com.democxy.common.utils.FileUtils;
import com.democxy.common.utils.IdGenUtil;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.sys.entity.SysFiles;
import com.democxy.modules.sys.entity.field.SysFilesField;
import com.democxy.modules.sys.service.SysFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author shiling_deng
 */
@CrossOrigin
@RestController
@RequestMapping("sys/sysFiles")
public class SysFilesController extends BaseController<SysFilesService, SysFiles, SysFilesField> {

    private final String PREFIX = "sys/";

    @Autowired
    ProjectConfig projectConfig;

    @RequestMapping("")
    @Permission(value = "sys:sysFiles:view")
    private ModelAndView sysFiles() {
        ModelAndView modelAndView = new ModelAndView(PREFIX + "sysFilesList");
        return modelAndView;
    }

    @RequestMapping("form")
    @Permission(value = "sys:sysFiles:add")
    public ModelAndView courseTypeForm(String id) {
        ModelAndView modelAndView = new ModelAndView(PREFIX + "sysFilesForm");
        if (StringUtils.isEmpty(id)) {
            modelAndView.addObject("sysFiles", new SysFiles());
        } else {
            modelAndView.addObject("sysFiles", service.getById(id));
        }
        return modelAndView;
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    @Log(title = "????????????")
    public ResponeData<String> delById(@PathVariable("id") String id){
        SysFiles byId = service.getById(id);
        // ??????????????????
        FileUtils.deleteFile(projectConfig.getBasepath()+byId.getFilePath());
        // ?????????????????????
        return super.delById(id);
    }

    @RequestMapping("upload")
    public ResponeData<SysFilesField> upload(@RequestParam("file") MultipartFile file) {
        try {
            Double size = Double.parseDouble(String.valueOf(file.getSize())) / 1024;
            BigDecimal b = new BigDecimal(size);
            // 2??????2??? ROUND_HALF_UP???????????????????????????size????????????????????????????????????
            size = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            // ???????????????
            String fileName = file.getOriginalFilename();
            // ????????????????????????
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // ??????????????????
            String fileId = IdGenUtil.getRandomNumr();
            String newFileName = fileId + suffixName;

            //???????????????????????????
            String saveUrl = projectConfig.getFilepath() + DateUtils.getDate() + "/" + newFileName;

            //???????????????????????????????????????????????????????????????
            String filePath = projectConfig.getBasepath() + saveUrl;
            //????????????????????????filePath  ???????????????????????????folderName+newFileName
            File dest = new File(filePath);
            // ?????????????????????????????????
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            // ????????????
            file.transferTo(dest);
            //???????????????????????????
            SysFilesField userFiles = new SysFilesField();
            userFiles.setFileNewname(newFileName);
            userFiles.setFileOldName(fileName);
            userFiles.setFilePath(saveUrl);
            userFiles.setFileSize(size);
            userFiles.setFileSuffix(suffixName);
            userFiles.setFileType(FileUtils.getFileType(suffixName));
            userFiles.setRemark("");
            userFiles.setId(fileId);
            userFiles.setUseId("");
            userFiles.setUploadTime(new Date());
            service.insert(userFiles);
            return new ResponeData(userFiles);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponeData(ResultEnum.FAILED);
        }


    }
}