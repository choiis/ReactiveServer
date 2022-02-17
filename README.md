
## ReactiveServer
Webflux로 구현된 Spring Redis CRUD 서버입니다
### Build & run

* openjdk 11버전 gradle 7.3버전을 사용합니다

* docker-compose로 Redis서버를 시작합니다
```
docker-compose up
```

* Spring Boot 서버를 시작합니다
```
gradle build
gradle bootrun
```