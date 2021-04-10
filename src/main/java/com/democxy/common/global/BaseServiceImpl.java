package com.democxy.common.global;

import com.democxy.common.utils.IdGenUtil;
import com.democxy.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author shiling_deng
 */
public class BaseServiceImpl<D extends BaseDao<T,F>, T,F extends BaseFiled<F>> implements BaseService<T,F> {

    @Autowired
    public D dao;

    @Override
    public int save(F entity){
        if (StringUtils.isEmpty(entity.getId())){
            entity.setId(IdGenUtil.getUUID());
            dao.insert(entity);
        }else {
            dao.update(entity);
        }
        return 0;
    }

    @Override
    public int insert(F entity) {
        return dao.insert(entity);
    }

    @Override
    public int delete(String id) {
        return dao.delete(id);
    }

    @Override
    public int update(F entity) {
        return dao.update(entity);
    }

    @Override
    public T getById(String id) {
        return dao.getById(id);
    }

    @Override
    public List<T> findList(F entity) {
        return dao.findList(entity);
    }

    @Override
    public int deleteBatch(List<String> ids){
        return dao.deleteBatch(ids);
    }
}
