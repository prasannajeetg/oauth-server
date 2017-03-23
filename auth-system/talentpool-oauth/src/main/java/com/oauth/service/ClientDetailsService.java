package com.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.oauth.entity.OAuthClientDetail;
import com.oauth.repository.OAuthClientDetailRepository;

@Component
public class ClientDetailsService implements org.springframework.security.oauth2.provider.ClientDetailsService {

	@Autowired
	private OAuthClientDetailRepository oauthClientDetailRepository;
	
	public ClientDetails loadClientByClientId(String clientId)
			throws ClientRegistrationException {
		OAuthClientDetail oauthClientDetail = oauthClientDetailRepository.findByClientId(clientId);

		if (oauthClientDetail == null) {
            throw new UsernameNotFoundException(String.format("ClientDetails %s does not exist!", clientId));
        }
        BaseClientDetails clientDetails=new BaseClientDetails();

        clientDetails.setClientId(oauthClientDetail.getClientId());
        clientDetails.setScope(StringUtils.commaDelimitedListToSet(oauthClientDetail.getScope()));
        clientDetails.setAuthorizedGrantTypes(StringUtils.commaDelimitedListToSet(oauthClientDetail.getAuthorizedGrantTypes()));
        clientDetails.setAuthorities(AuthorityUtils.createAuthorityList(oauthClientDetail.getAuthorities().split(",")));
        clientDetails.setAccessTokenValiditySeconds(oauthClientDetail.getAccessTokenValidity());
        clientDetails.setClientSecret(oauthClientDetail.getClientSecret());
      
        clientDetails.setAccessTokenValiditySeconds(oauthClientDetail.getAccessTokenValidity());
        clientDetails.setRegisteredRedirectUri(StringUtils.commaDelimitedListToSet(oauthClientDetail.getWebServerRedirectUri()));
        clientDetails.setResourceIds(StringUtils.commaDelimitedListToSet(oauthClientDetail.getResourceIds()));
        //clientDetails.setAdditionalInformation(oauthClientDetails.getAdditionalInformation());
        return clientDetails;
	}

}
