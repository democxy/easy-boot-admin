package com.democxy.common.global;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BaseService<T> {

    public int insert(T entity);

    public int delete(String id);

    public int update(T entity);

    public T getById(String id);

    public List<T> findList(T entity);

}
