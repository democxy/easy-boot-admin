package com.democxy.modules.sys.service.impl;

import com.democxy.common.exception.CustomException;
import com.democxy.common.global.BaseServiceImp;
import com.democxy.common.utils.IdGenUtil;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.sys.dao.DictDao;
import com.democxy.modules.sys.entity.Dict;
import com.democxy.modules.sys.entity.field.DictField;
import com.democxy.modules.sys.service.DictService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("dict")
public class DictServiceImp extends BaseServiceImp<DictDao, Dict, DictField> implements DictService {
    @Override
    public List<Dict> findDistinct(DictField dictField) {
        return dao.findDistinct(dictField);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(DictField f){
        List<DictField> dictList = f.getDictList();
        if (dictList!=null && dictList.size()>0){
            List<String> delIds = f.getDelIds();
            // 删除待删除数据
            for (String delId : delIds) {
                dao.delete(delId);
            }
            String type = f.getType();
            String description = f.getDescription();
            for (DictField dictField : dictList) {
                dictField.setType(type);
                dictField.setDescription(description);
                if (StringUtils.isEmpty(dictField.getId())){
                    dictField.setId(IdGenUtil.getUUID());
                    dao.insert(dictField);
                }else {
                    dao.update(dictField);
                }
            }
        }else {
            throw new CustomException(500,"至少包含一对键值！");
        }
        return 0;
    }

    public List<Dict> getDictsByType(String type){
        DictField dictField = new DictField();
        dictField.setType(type);
        return dao.findList(dictField);
    }
}
