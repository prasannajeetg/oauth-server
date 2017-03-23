package com.oauth.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;

@Configuration
public class DatabaseConfig {

	@Value("${datasource.jndi.enabled}")
	private boolean jndiEnabled;
	
	@Value("${datasource.jndi.name}")
	private String dbLookupJndi;
	
	
	@Bean(name="datasource")
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() throws NamingException {
		if (jndiEnabled) {
			JndiTemplate jndiTemplate = new JndiTemplate();
			return (DataSource) jndiTemplate.lookup(dbLookupJndi);
		} else {
			return new DriverManagerDataSource();
		}
	}
}
