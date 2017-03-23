package com.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oauth.entity.OAuthClientDetail;

public interface OAuthClientDetailRepository extends JpaRepository<OAuthClientDetail, String> {
	
	OAuthClientDetail findByClientId(String clientId);
}
