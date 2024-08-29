using keycloak as test oauth server

using following docker compose command in root dir will start a server container with keyclock ouath server can take a
couple of mins
to download image

## keycloak will require

- realm - the groups of users, groups, roles...
- client - aka the app that will start the oauth flow
- user - creating users you want to authenticate

`` docker-compose up -d``

# docker compose file has a setting for user admin password setup

# Using java 17 with graddle to run api server

- download required JDK 17

# Running test

``./gradlew test``

# Running app

``./gradlew bootrun``