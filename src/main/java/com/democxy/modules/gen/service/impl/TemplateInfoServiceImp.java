package com.democxy.modules.gen.service.impl;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.common.utils.FileUtils;
import com.democxy.modules.gen.dao.TemplateInfoDao;
import com.democxy.modules.gen.entity.TemplateInfo;
import com.democxy.modules.gen.entity.field.TemplateInfoField;
import com.democxy.modules.gen.service.TemplateInfoService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Service
public class TemplateInfoServiceImp extends BaseServiceImp<TemplateInfoDao, TemplateInfo, TemplateInfoField> implements TemplateInfoService {

    @Override
    public int save(TemplateInfoField entity) {

        try {
            String content = URLDecoder.decode(URLDecoder.decode( entity.getContent(), "UTF-8"), "UTF-8");
            FileUtils.writeStringToFile(new File("F://test.ftl"),content,"UTF-8");
            System.out.println(content);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.save(entity);
    }
}