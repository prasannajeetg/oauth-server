CREATE TABLE IF NOT EXISTS oauth_access_token (
  			token_id VARCHAR(256) DEFAULT NULL,
  			token BLOB,
  			authentication_id VARCHAR(256) DEFAULT NULL,
  			user_name VARCHAR(256) DEFAULT NULL,
  			client_id VARCHAR(256) DEFAULT NULL,
  			authentication BLOB,
  			refresh_token VARCHAR(256) DEFAULT NULL
			);

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
  			token_id VARCHAR(256) DEFAULT NULL,
  			token BLOB,
  			authentication BLOB
			);

CREATE TABLE IF NOT EXISTS `oauth_client_details` (                   
            `client_id` varchar(255) NOT NULL,                    
             `access_token_validity` int(11) DEFAULT NULL,         
             `additional_information` varchar(255) DEFAULT NULL,   
             `authorities` varchar(255) DEFAULT NULL,              
             `authorized_grant_types` varchar(255) DEFAULT NULL,   
             `auto_approve` bit(1) NOT NULL,                       
             `client_secret` varchar(255) DEFAULT NULL,            
             `refresh_token_validity` int(11) DEFAULT NULL,        
             `resource_ids` varchar(255) DEFAULT NULL,             
             `scope` varchar(255) DEFAULT NULL,                    
             `web_server_redirect_uri` varchar(255) DEFAULT NULL,  
             PRIMARY KEY (`client_id`)                             
             );