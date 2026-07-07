# OctaTicket

Sistema de gerenciamento de chamados (ITSM) desenvolvido utilizando **Java 21**, **Spring Boot**, **Arquitetura Hexagonal**, **JWT**, **Kafka**, **Docker** e **PostgreSQL**.

O projeto foi desenvolvido com foco na consolidação dos meus estudos pessoais de arquitetura, separação de responsabilidades e comunicação entre serviços. Além do gerenciamento de tickets, a aplicação utiliza um serviço independente de notificações responsável pelo envio de e-mails de verificação, notificações de chamados (analistas são notificados que um Ticket foi criado e os usuários notificados sobre o andamento de seus chamados).

---

# Funcionalidades

### Autenticação

- Cadastro de usuários
- Verificação de conta por e-mail
- Login com JWT

### Gerenciamento de Tickets

- Criação de chamados
- Listagem paginada
- Filtros por status, prioridade e data
- Busca por número do ticket
- Visualização detalhada
- Comentários em chamados
- Atualização de status
- Atribuição de analistas

### Dashboard

- Indicadores gerais
- Quantidade de tickets por status
- Tickets recentes
- Dashboard exclusivo para analistas

### Segurança

- JWT Authentication
- Controle de acesso baseado em Roles
- Rotas protegidas
- Usuários COMMON e ANALYST

### Integrações

- Notification Service
- Apache Kafka
- PostgreSQL

---

# Arquitetura

O projeto utiliza **Arquitetura Hexagonal (Ports and Adapters)**, separando regras de negócio da infraestrutura.

```
Frontend
      │
      ▼
REST Controllers
      │
      ▼
Use Cases
      │
      ▼
Domain
      │
 ┌────┴──────────────┐
 │                   │
 ▼                   ▼
Repositories      Notification Port
 │                   │
 ▼                   ▼
PostgreSQL      Notification Service
                     │
                     ▼
                  SMTP
```



---

# Tecnologias

| Categoria | Tecnologia |
|------------|------------|
| Linguagem | Java 21 |
| Framework | Spring Boot |
| Arquitetura | Hexagonal Architecture |
| Banco de Dados | PostgreSQL 15 |
| Segurança | Spring Security + JWT |
| Mensageria | Apache Kafka |
| ORM | Spring Data JPA / Hibernate |
| Build | Maven |
| Containerização | Docker + Docker Compose |
| Proxy Reverso | Nginx |
| Front-end | HTML, CSS e JavaScript |

---

# Estrutura do Projeto

```
src/main/java/ticket/management/system

├── adapters
│   ├── input
│   │   └── controller
│   │   └── dto
│   │   └── mapperDTO
│   │   └── security
│   └── output
│       ├── entities
│       ├── kafka
│       └── mapper
│       └── notification
│       └── repository
│       └── security
│
├── config
│  
├── domain
│   ├── entities
│   ├── events
│   └── ports
│   └── usecases
│
└── Application
```

---

# Fluxo de Criação de Ticket

```
Usuário

↓

POST /api/tickets

↓

Validação

↓

Persistência no PostgreSQL

↓

Publicação de evento

↓

Kafka

↓

Notification Service

↓

Envio de e-mail aos analistas
```

---

# Notification Service

Este projeto utiliza um serviço independente para envio de e-mails.

Responsabilidades:

- Verificação de conta
- Recuperação de senha
- Notificação de criação de tickets
- Notificação para analistas
- Templates HTML com Thymeleaf

Repositório:

https://github.com/acmors/itsm-notification-service

---

# Como Executar

## Pré-requisitos

- Java 21
- Docker
- Docker Compose

---

## Clonar o projeto

```bash
git clone https://github.com/seu-usuario/ticket-management-system.git

cd ticket-management-system
```

---

## Configurar variáveis de ambiente

Crie um arquivo `.env`:

```properties
DB_HOST=
DB_PORT=
DB_NAME=

DB_USER=
DB_PASSWORD=

KAFKA_HOST=
KAFKA_PORT=

JWT_SECRET_KEY=

NOTIFICATION_URL=
```

---

## Executar com Docker

```bash
docker compose up --build
```

A aplicação ficará disponível em:

```
http://localhost:8080
```

---

# Endpoints

## Auth

| Método | Endpoint |
|---------|----------|
| POST | /auth/login |
---

## Tickets

| Método | Endpoint |
|---------|----------|
| GET | /api/tickets |
| GET | /api/tickets/my-tickets |
| POST | /api/tickets |
| PATCH | /api/tickets/number/{number} |

---
## User
| Método | Endpoint |
|---------|----------|
| POST | /api/users |
| POST | /api/users/verify |

---

# Deploy

O projeto foi publicado utilizando:

- Docker
- Docker Compose
- Nginx
- VPS Linux

---

# Melhorias Futuras

- Upload de anexos
- Histórico de alterações
- WebSocket para atualização em tempo real
- Métricas e Obsevabilidade
- Testes de integração
- GitHub Actions para CI/CD

---

# Teste online

O projeto encontra-se hospedado e pode ser testado facilmente através do Link: https://acmors-developer.online/login.html

Apenas um aviso de que o foco do projeto é o funcionamento do back-end e sua comunicação com serviços externos. O front-end da aplicação está simples e com alguns bugs que futuramente irei altera-los.

"Um sistema sempre estará em constante mudança até seu último dia de vida." 

---

# Projeto Relacionado

Este projeto utiliza um microsserviço responsável pelo envio de notificações.

➡ **Notification Service**

https://github.com/acmors/itsm-notification-service

---

# Contribuições

Contribuições são bem-vindas.

Caso encontre algum problema ou tenha sugestões de melhoria:

1. Abra uma Issue.
2. Faça um Fork do projeto.
3. Crie uma Branch.
4. Envie um Pull Request.
