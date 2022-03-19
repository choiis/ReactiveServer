
## ReactiveServer
It is a Spring Redis CRUD server implemented with Webflux.
### Build & run

* I use openjdk 11 version gradle 7.3 version

* Start the Redis server with docker-compose
```
docker-compose up
```

* Start the Spring Boot server
```
gradle build
gradle bootrun
```