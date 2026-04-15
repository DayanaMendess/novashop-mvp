## Diagrama de Componentes

```mermaid
graph TB

Frontend[Frontend React]
Gateway[API Gateway]
Backend[Backend Spring Boot]
Database[(PostgreSQL)]
Docker[Docker Compose]
Docs[Documentación]

Frontend --> Gateway
Gateway --> Backend
Backend --> Database
Docker --> Frontend
Docker --> Backend
Docker --> Database
Docs --> Frontend
Docs --> Backend
Docs --> Database
```