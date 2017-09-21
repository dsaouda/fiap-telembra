# fiap-telembra

Aplicação que envia notificação via celular ou telefone fixo utilizando um sistema de voz ou texto chamado [TotalVoice](http://www.totalvoice.com.br)

## frontend ui

O frontend está disponível no repositório https://github.com/dsaouda/fiap-telembra-ui

# Usando docker para montar a infra necessária

## Spring Boot

### build
./gradlew build -x test

### run in docker

```bash
docker run -it -p8081:8080 --rm -v `pwd`:/srv -w /srv openjdk:8 java -jar build/libs/fiap-telembra-1.0.0.jar
```

### iniciando apenas o cli para usar o disque

```bash
docker run -it --rm -v `pwd`:/srv -w /srv openjdk:8 java -jar build/libs/fiap-telembra-1.0.0.jar cli
shell:> pl
```

 - https://hub.docker.com/_/openjdk/
 - http://start.spring.io/
 - https://projects.spring.io/spring-shell/
 - https://projects.spring.io/spring-boot/

## MySQL

O comando abaixo iniciará o mysql com o banco de dados populado. O banco e senha são definidos nas variáveis MYSQL_DATABASE e MYSQL_ROOT_PASSWORD respectivamente, já o usuário por padrão é root.

```bash
docker run --name fiap_mysql_telembra -p 3306:3306 -v `pwd`/docs:/docker-entrypoint-initdb.d/ -e MYSQL_DATABASE=fiap_telembra -e MYSQL_ROOT_PASSWORD=dsaouda -d mysql
```

https://hub.docker.com/_/mysql/

## PHPMyAdmin

Para realizar alguma administração no banco de dados o [PHPMyAdmin](https://www.phpmyadmin.net/) é uma ótima opção. Não é uma instalação obrigatória

```bash
docker run --name phpmyadmin -d --link fiap_mysql_telembra:db -p 8000:80 phpmyadmin/phpmyadmin
```
https://hub.docker.com/r/phpmyadmin/phpmyadmin/

## Disque, an in-memory, distributed job queue

```bash
docker run --name disque -p 7711:7711 -d richnorth/disque
```

 - https://hub.docker.com/r/richnorth/disque/
 - https://github.com/antirez/disque
