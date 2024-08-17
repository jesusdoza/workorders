using keycloak as test oauth server

will using following in root dir will start a server will take a couple of mins

- will require setting up realm - the groups of users, groups, roles...
- client - aka the app
- user - users you want to authenticate with for tests

`` docker-compose up -d``

# docker compose file has a setting for user admin setup

# Using java 17

- download required JDK 17

# Running test

``./gradlew test``

# Running app

``./gradlew bootrun``