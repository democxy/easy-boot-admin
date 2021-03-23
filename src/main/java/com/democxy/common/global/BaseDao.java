package com.democxy.common.global;

import java.util.List;

/**
 * @author shiling_deng
 */
public interface BaseDao<T,F extends BaseFiled<F>> {

    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(F entity);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(F entity);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    T getById(String id);

    /**
     * 列表查询
     * @param entity
     * @return
     */
    List<T> findList(F entity);
}
