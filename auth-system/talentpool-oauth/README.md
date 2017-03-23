
OAuth Server
============

Description :
This project is build to secure the exposed APIs. 
It acts as authorization server and gives back access-token for registered clients with system defined roles and scopes.
It gives APIs to get access-token.

e.g. 
/oauth/token 
/oauth/authorize


Notes
============

This project is a Spring boot project with Spring OAuth enabled. Also added fly-way dependency to maintain database versions.
Database - MYSQL.

Requirements -

Please cheeck if database setup is in place