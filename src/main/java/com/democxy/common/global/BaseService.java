package com.democxy.common.global;

import java.util.List;

/**
 * @author shiling_deng
 */
public interface BaseService<T,F extends BaseFiled<F>> {

    /**
     * 添加更新
     * @param entity
     * @return
     */
    int save(F entity);

    /**
     * 新增
     * @param entity
     * @return
     */
    int insert(F entity);

    /**
     * 根据ID删除
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
