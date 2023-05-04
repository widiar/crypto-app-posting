package com.project.posting.config;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {
	public final org.slf4j.Logger logCrypPost = LoggerFactory.getLogger("crypApi");

}
