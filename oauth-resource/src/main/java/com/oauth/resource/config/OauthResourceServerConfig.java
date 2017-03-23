package com.oauth.resource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableResourceServer
public class OauthResourceServerConfig  extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.exceptionHandling()  
			.authenticationEntryPoint(customAuthenticationEntryPoint)
			.and()
	        .csrf()  
	        .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))  
	        .disable()  
	        .headers()  
	        .frameOptions().disable()
			.and()
			.sessionManagement()  
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
			.and()
			.authorizeRequests()
			.antMatchers("/open/**","/v2/**").permitAll()
			.antMatchers("/secure/**").authenticated();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
	    resources.resourceId("talentpool");
	    
	    RemoteTokenServices tokenService = new RemoteTokenServices();
	    tokenService.setClientId("test-client_id");
	    tokenService.setClientSecret("test-secret");
	    tokenService.setCheckTokenEndpointUrl("http://localhost:8083/oauth/check_token");
	    
	    resources.tokenServices(tokenService);
	    
	}
}
