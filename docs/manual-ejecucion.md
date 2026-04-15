# Manual de Ejecución

## Opción 1: Con Docker

1. Abrir terminal en la raíz del proyecto.
2. Crear el archivo `.env` a partir de `.env.example`.
3. Ejecutar:

```bash
docker compose up --build
```

4. Verificar:
- Frontend en `http://localhost:5173`
- Backend en `http://localhost:8080`

## Opción 2: Manual

### Base de datos
1. Crear una base llamada `novashop_db`.
2. Ejecutar el script `database/init.sql`.

### Backend
1. Entrar a la carpeta `backend`.
2. Ejecutar:

```bash
mvn spring-boot:run
```

### Frontend
1. Entrar a la carpeta `frontend`.
2. Ejecutar:

```bash
npm install
npm run dev
```

## Recomendación
Si lo vas a presentar al profesor, usa Docker porque te deja todo más profesional y más fácil de correr.
