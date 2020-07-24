## Kanban Application

Aplicação feita com 3 contêineres Docker que contêm:

- PostgreSQL database
- Java backend (Spring Boot)
- Angular frontend

Aplicação web: **http://localhost:4200/**

![Kanban](https://github.com/daienelima/kanban-board/blob/master/assets/kanban.gif)

---

### Pré-requisitos

**Docker** & **Docker Compose**.

### Como Executar?

Na raiz do projeto executar:

```
$ docker-compose up -d
```

Finalizar execução:

```
$ docker-compose down
```

---

#### kanban-postgres (Database)

- Host: _localhost_
- Database: _kanban_
- User: _kanban_
- Password: _kanban_

definições do banco no _docker-compose.yml_

```yml
kanban-postgres:
  image: 'postgres:9.6-alpine'
  container_name: kanban-postgres
  volumes:
    - kanban-data:/var/lib/postgresql/data
  ports:
    - 5432:5432
  environment:
    - POSTGRES_DB:kanban
    - POSTGRES_USER:kanban
    - POSTGRES_PASSWORD:kanban
```

#### kanban-app (REST API)

Backend: **http://localhost:8080/api/swagger-ui.html**

![swagger-ui](https://github.com/daienelima/kanban-board/blob/master/assets/swagger.png)

#### kanban-ui (Frontend)

Frontend: **http://localhost:4200/**
