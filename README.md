# NovaShop MVP

NovaShop MVP es un proyecto académico de carrito de compras con **frontend**, **backend**, **base de datos PostgreSQL**, **Docker** y **documentación técnica**.  
Fue diseñado para verse más profesional, organizado y diferente al ejemplo base, pero conservando la idea de un MVP funcional para evaluación académica.

## Vista general

El sistema permite:

- registrar clientes
- consultar productos
- administrar un carrito
- generar pedidos
- consultar pedidos realizados

## Arquitectura del proyecto

```text
novashop-mvp/
├── backend/                  # API REST con Spring Boot
├── frontend/                 # Interfaz web con React + Vite
├── database/                 # Script SQL inicial
├── docs/                     # Documentación funcional y técnica
├── docker-compose.yml        # Orquestación completa
└── .env.example              # Variables de entorno de referencia
```

## Tecnologías usadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL 16
- React
- Vite
- Docker
- Docker Compose

## Módulos del MVP

1. **Clientes**  
   Registro y consulta de clientes.

2. **Catálogo**  
   Gestión básica de productos y categorías.

3. **Carrito**  
   Creación de carrito, agregar productos y actualizar cantidades.

4. **Pedidos**  
   Confirmación de compra a partir del carrito.

## Cómo ejecutar con Docker

1. Copia `.env.example` a `.env`
2. En la raíz del proyecto ejecuta:

```bash
docker compose up --build
```

3. Abre:
- Frontend: `http://localhost:5173`
- Backend: `http://localhost:8080`
- PostgreSQL: `localhost:5432`

## Cómo ejecutar sin Docker

### Backend

```bash
cd backend
mvn spring-boot:run
```

o en Windows:

```bash
mvn spring-boot:run
```

### Frontend

```bash
cd frontend
npm install
npm run dev
```

## Variables importantes

Revisa estos archivos:

- `backend/src/main/resources/application.yml`
- `.env.example`
- `frontend/.env.example`

## Documentación

Dentro de la carpeta `docs/` encontrarás:

- `README_PROYECTO.md`
- `historias_usuario.md`
- `ambientes.md`
- `api-endpoints.md`
- `manual-ejecucion.md`

## Flujo sugerido de ramas

```text
main     -> versión final
qa       -> pruebas integradas
develop  -> integración de desarrollo
feature/* -> funcionalidades nuevas
```

## Autoría sugerida


- Proyecto: **NovaShop MVP**
- Tipo: MVP académico de carrito de compras
- Universidad: Corhuila
- Programa: Ingeniería de Sistemas
