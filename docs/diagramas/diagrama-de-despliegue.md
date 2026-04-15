##  Diagrama de Despliegue

```mermaid
graph TD

Usuario[Equipo del Usuario] --> Docker[Docker Desktop]

Docker --> FrontendContainer[Contenedor Frontend]

Docker --> BackendContainer[Contenedor Backend]

Docker --> DatabaseContainer[(Contenedor PostgreSQL)]
```