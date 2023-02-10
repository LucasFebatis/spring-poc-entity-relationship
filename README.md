# base-demo do Febatis

Projeto padrão 2023 para criar Pocs com:

- Java 17 + Maven
- Spring, JPA, h2, lombok
- Swegger

- Design Pattern: Controller, Service, Repository
- Context setado
- h2 configurado

## Entradas

http://localhost:8080/base-demo/swagger-ui/index.html

http://localhost:8080/base-demo/h2-console

## Como recriar

1. Spring Initializr com essas configs

[start.spring.io with params](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.0.1&packaging=jar&jvmVersion=17&groupId=com.febatis&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.febatis.demo&dependencies=data-jpa,h2,web,lombok)

2. Swegger (springdoc-openapi v2)

https://springdoc.org/v2/

