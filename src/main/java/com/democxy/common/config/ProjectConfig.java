package com.democxy.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目基础信息配置类（获取配置文件application.yml的属性值）
 * @author democxy
 *
 */
@Component
@ConfigurationProperties(prefix = "project")
@Data
public class ProjectConfig {
	
	private String name;
	
	private String version;
	
	private String filepath;
	
	private String basepath;

}
