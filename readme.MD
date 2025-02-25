


```shell
docker run -d -p 9411:9411 openzipkin/zipkin-slim
```

Для успешного запуска проекта необходимо.

````
mvn spring-boot:build-image
````

````shell
docker compose -f docker-compose-cashe.yaml up 
````

````shell
docker compose -f docker-compose-cashe.yaml down 
````


Первоначальный рест
http://localhost:8081/name

Zipkin 
http://localhost:9411/


