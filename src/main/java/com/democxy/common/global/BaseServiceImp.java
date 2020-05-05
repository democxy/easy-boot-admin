package com.democxy.common.global;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImp<D extends BaseDao<T>, T> implements BaseService<T> {

    @Autowired
    public D dao;

    @Override
    public int insert(T entity) {
        return dao.insert(entity);
    }

    @Override
    public int delete(String id) {
        return dao.delete(id);
    }

    @Override
    public int update(T entity) {
        return dao.update(entity);
    }

    @Override
    public T getById(String id) {
        return dao.getById(id);
    }

    @Override
    public List<T> findList(T entity) {
        return dao.findList(entity);
    }
}
