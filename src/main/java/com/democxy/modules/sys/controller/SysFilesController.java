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
    @Log(title = "删除文件")
    public ResponeData<String> delById(@PathVariable("id") String id){
        SysFiles byId = service.getById(id);
        // 删除磁盘文件
        FileUtils.deleteFile(projectConfig.getBasepath()+byId.getFilePath());
        // 删除数据库记录
        return super.delById(id);
    }

    @RequestMapping("upload")
    public ResponeData<SysFilesField> upload(@RequestParam("file") MultipartFile file) {
        try {
            Double size = Double.parseDouble(String.valueOf(file.getSize())) / 1024;
            BigDecimal b = new BigDecimal(size);
            // 2表示2位 ROUND_HALF_UP表明四舍五入，此时size就是保留两位小数的浮点数
            size = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 创建新文件名
            String fileId = IdGenUtil.getRandomNumr();
            String newFileName = fileId + suffixName;

            //定义保存数据的路径
            String saveUrl = projectConfig.getFilepath() + DateUtils.getDate() + "/" + newFileName;

            //根据配置文件上传的基路径拼接完整的磁盘路径
            String filePath = projectConfig.getBasepath() + saveUrl;
            //文件真实上传路径filePath  保存数据库的路径为folderName+newFileName
            File dest = new File(filePath);
            // 判断文件父目录是否存在
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            // 保存文件
            file.transferTo(dest);
            //定义接收的文件对象
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