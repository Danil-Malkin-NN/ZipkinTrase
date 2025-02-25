


```shell
docker run -d -p 9411:9411 openzipkin/zipkin-slim
```

Для успешного запуска проекта необходимо.

````shell
mvn spring-boot:build-image
````

````shell
docker compose up -f docker-compose.yaml
````
Первоначальный рест
http://localhost:8081/name

Zipkin 
http://localhost:9411/


