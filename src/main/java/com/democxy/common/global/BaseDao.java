package com.democxy.common.global;

import java.util.List;

public interface BaseDao<T> {

    int insert(T entity);

    int delete(String id);

    int update(T entity);

    T getById(String id);

    List<T> findList(T entity);
}
