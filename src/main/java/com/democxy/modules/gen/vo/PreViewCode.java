package com.democxy.modules.gen.vo;

import lombok.Data;

/**
 * @author shiling_deng
 * @version 2021/3/1
 */
@Data
public class PreViewCode {

    private String fileName;

    private String code;

    public PreViewCode(String fileName, String code) {
        this.fileName = fileName;
        this.code = code;
    }
}
