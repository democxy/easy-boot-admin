package com.democxy.modules.sys.entity.field;

import java.util.Date;

import lombok.Data;

import com.democxy.common.global.BaseFiled;

/**
 * @author shiling_deng
 */
@Data
public class NoticeField extends BaseFiled<NoticeField> {

    /**
     * 标题
     */
    private String title;
    /**
     * 类型
     */
    private String type;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    private Date createTime;
    /**
     * 发布人
     */
    private String createBy;

}