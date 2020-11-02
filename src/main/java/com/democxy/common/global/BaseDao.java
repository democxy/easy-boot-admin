package com.democxy.common.global;

import java.util.List;

public interface BaseDao<T,F extends BaseFiled<F>> {

    int insert(F entity);

    int delete(String id);

    int update(F entity);

    T getById(String id);

    List<T> findList(F entity);
}
