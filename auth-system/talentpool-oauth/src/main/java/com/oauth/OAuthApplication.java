package com.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = { "com.oauth" })
@PropertySource(value = { "classpath:/application.properties",
		"file:${oauth.config.dir}/application.properties" }, ignoreResourceNotFound = true)
@EnableConfigurationProperties
@EnableAutoConfiguration
public class OAuthApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OAuthApplication.class, args);
	}

}
