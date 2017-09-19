# fiap-telembra

Aplicação que envia notificação via celular ou telefone fixo utilizando um sistema de voz ou texto chamado [total voice](http://www.totalvoice.com.br)

# instando dependências via docker

## mysql

O comando abaixo iniciará o mysql com o banco de dados populado. O banco e senha são definidos nas variáveis MYSQL_DATABASE e MYSQL_ROOT_PASSWORD respectivamente, já o usuário por padrão é root.

```bash
docker run --name fiap-mysql-telembra -p 3306:3306 -v $(pwd)/docs:/docker-entrypoint-initdb.d/ -e MYSQL_DATABASE=fiap_telembra -e MYSQL_ROOT_PASSWORD=<PASSWORD> -d mysql --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```

maiores informações https://hub.docker.com/_/mysql/

## importando o banco de dados

docker run -p 7711:7711 -d richnorth/disque
