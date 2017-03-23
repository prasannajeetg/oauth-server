/*
insert into `oauth_client_details` 
(`client_id`,`access_token_validity`,`additional_information`,`authorities`,`authorized_grant_types`,`auto_approve`,`client_secret`,`refresh_token_validity`,`resource_ids`,`scope`,`web_server_redirect_uri`) 
values ('test-vault',4800,NULL,'ROLE_CONSUMER','implicit,refresh_token,client_credentials','','test-vault',7200,'oauth2_resource','vault-tokenize,vault-detokenize',NULL);
*/

INSERT INTO `talentpool_auth`.`oauth_client_details` (`client_id`, `access_token_validity`, `authorities`, `authorized_grant_types`,
`auto_approve`, `client_secret`, `refresh_token_validity`, `resource_ids`, `scope`) VALUES ('test-client_id', '4800', 'ROLE_CONSUMER',
'implicit,refresh_token,client_credentials', '', 'test-client_secret', '7200', 'oauth2_resource', 'scope1,scope2');
