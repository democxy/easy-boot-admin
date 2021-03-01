package com.democxy.modules.gen.utils;

import com.democxy.common.config.ProjectConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author shiling_deng
 * @version 2021/02/04
 */
@Component
public class GenCodeUtil {
    @Autowired
    FreeMarkerConfig freeMarkerConfig;
    @Autowired
    ProjectConfig projectConfig;

    /**
     * 向本地磁盘输出文件
     * @param tempPath 模板文件相对路径
     * @param data 数据模型
     * @param outPath 输出文件路径
     * @return 生成的文件路径
     */
    public String genCode(String tempPath, Map<String,Object> data, String outPath){
        try {
            Configuration configuration = freeMarkerConfig.getConfiguration();
            // 设置freemarker 模板的加载路径
//            configuration.setDirectoryForTemplateLoading(new File(projectConfig.getBasepath()));
            // 加载模板文件
            Template template1 = configuration.getTemplate(tempPath, "utf-8");
            // 填充数据
            String string1 = FreeMarkerTemplateUtils.processTemplateIntoString(template1, data);
            // 写入文件
            FileUtils.writeStringToFile(new File(outPath),string1,"UTF-8");
            return outPath;
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 预览代码
     * @param tempPath
     * @param data
     * @return
     */
    public String preViewCode(String tempPath, Map<String,Object> data){
        try {
            Configuration configuration = freeMarkerConfig.getConfiguration();
            // 设置freemarker 模板的加载路径
//            configuration.setDirectoryForTemplateLoading(new File(projectConfig.getBasepath()));
            // 加载模板文件
            Template template1 = configuration.getTemplate(tempPath, "utf-8");
            // 填充数据
            String string1 = FreeMarkerTemplateUtils.processTemplateIntoString(template1, data);
            // 写入文件
            return string1;
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

}
