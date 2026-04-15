## Diagrama de Ambientes

```mermaid
graph LR

DEV[DEV<br/>Desarrollo<br/>Puerto 8081] --> QA[QA<br/>Pruebas<br/>Puerto 8082]
QA --> MAIN[MAIN<br/>Producción<br/>Puerto 8083]
```