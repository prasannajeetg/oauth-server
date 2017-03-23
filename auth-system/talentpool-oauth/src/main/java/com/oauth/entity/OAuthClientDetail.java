package com.oauth.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_client_details")
public class OAuthClientDetail implements Serializable {

	private static final long serialVersionUID = 923299843699209655L;

	@Id
	private String clientId;
	private String clientSecret;
	private String resourceIds;
	private String scope;
	private String authorizedGrantTypes;
	private String webServerRedirectUri;
	private String authorities;
	private String additionalInformation;
	private boolean autoApprove;
	private Integer accessTokenValidity;
	private Integer refreshTokenValidity;

	public OAuthClientDetail() {
	}

	public OAuthClientDetail(String clientId, String clientSecret,
			String resourceIds, String scope, String authorizedGrantTypes) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.resourceIds = resourceIds;
		this.scope = scope;
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public OAuthClientDetail(String clientId, String clientSecret,
			String resourceIds, String scope, String authorizedGrantTypes,
			String additionalInformation) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.resourceIds = resourceIds;
		this.scope = scope;
		this.authorizedGrantTypes = authorizedGrantTypes;
		this.additionalInformation = additionalInformation;
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getResourceIds() {
		return resourceIds;
	}

	public String getScope() {
		return scope;
	}

	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	public String getWebServerRedirectUri() {
		return webServerRedirectUri;
	}

	public String getAuthorities() {
		return authorities;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public boolean isAutoApprove() {
		return autoApprove;
	}

	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public Integer getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri = webServerRedirectUri;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public void setAutoApprove(boolean autoApprove) {
		this.autoApprove = autoApprove;
	}

	public void setAccessTokenValidity(int accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public void setRefreshTokenValidity(int refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

}