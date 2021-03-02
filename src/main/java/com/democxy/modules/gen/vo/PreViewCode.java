package com.democxy.modules.gen.vo;

import lombok.Data;

/**
 * @author shiling_deng
 * @version 2021/3/1
 */
@Data
public class PreViewCode {

    private String filePath;

    private String fileName;

    private String code;

    public PreViewCode(String filePath, String fileName, String code) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.code = code;
    }
}
