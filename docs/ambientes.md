# 🖥️ Ambiente del Proyecto – NovaShop MVP

## 📑 Introducción

El presente documento describe el ambiente técnico utilizado para el desarrollo del proyecto **NovaShop MVP**, un sistema de carrito de compras implementado bajo una arquitectura moderna basada en servicios, contenedores y control de versiones.

El objetivo de este documento es detallar las herramientas, tecnologías y configuraciones necesarias para ejecutar correctamente el sistema, permitiendo su replicación en cualquier entorno de desarrollo.

---

# Arquitectura del Sistema

El sistema NovaShop MVP se desarrolló utilizando una arquitectura cliente-servidor, compuesta por tres componentes principales:

Frontend  
Backend  
Base de datos  

La comunicación entre estos componentes se realiza mediante el protocolo HTTP utilizando servicios REST.

---

# Tecnologías utilizadas

## Backend

El backend del sistema fue desarrollado utilizando:

- Java 17
- Spring Boot
- Maven
- Spring Data JPA
- Hibernate
- REST API

El backend es responsable de:

- Procesar la lógica de negocio
- Gestionar los datos
- Exponer los endpoints del sistema
- Conectarse a la base de datos

---

## Frontend

El frontend del sistema fue desarrollado utilizando:

- React
- Vite
- JavaScript
- HTML
- CSS

El frontend es responsable de:

- Mostrar la interfaz del usuario
- Permitir la interacción con el sistema
- Consumir los servicios del backend

---

## Base de datos

La base de datos utilizada en el proyecto es:

PostgreSQL

El sistema utiliza esta base de datos para almacenar:

- Productos
- Categorías
- Información del carrito
- Registros del sistema

---

# Contenedores Docker

El proyecto utiliza Docker para ejecutar los servicios de manera independiente.

Se configuraron los siguientes contenedores:

Backend  
Base de datos  

Esto permite:

- Facilitar la ejecución del sistema
- Aislar los servicios
- Evitar conflictos de configuración
- Simplificar el despliegue

---

# Puertos del sistema

Los servicios del sistema se ejecutan en los siguientes puertos:

Backend

8080

Base de datos

5432

Frontend

5173

---

# Requisitos del sistema

Para ejecutar el proyecto correctamente se requiere tener instalado:

- Java 17
- Node.js
- npm
- Docker Desktop
- Git
- Visual Studio Code

---

# Variables de entorno

El sistema utiliza las siguientes configuraciones:

Base de datos

Nombre:

novashopdb

Usuario:

postgres

Contraseña:

postgres

Puerto:

5432

---

# Ejecución del sistema

Para ejecutar el sistema se deben seguir los siguientes pasos:

## Paso 1 — Clonar el repositorio

git clone https://github.com/usuario/novashop-mvp.git

## Paso 2 — Ingresar al proyecto

cd novashop-mvp

## Paso 3 — Ejecutar Docker

docker compose up -d

## Paso 4 — Ejecutar el backend

mvn spring-boot:run

## Paso 5 — Ejecutar el frontend

npm install

npm run dev

---

# URL del sistema

Backend

http://localhost:8080

Frontend

http://localhost:5173

---

# Estructura del proyecto

El proyecto se encuentra organizado de la siguiente manera:

novashop-mvp

backend  
frontend  
database  
docker-compose.yml  
README.md  
docs  

---

# Control de versiones

El proyecto utiliza Git y GitHub para el control de versiones.

Se manejan los siguientes ambientes:

DEV  
QA  
MAIN  

Cada ambiente representa una etapa del desarrollo del sistema.

---

# Conclusión

El ambiente del proyecto NovaShop MVP fue diseñado para garantizar estabilidad, facilidad de ejecución y compatibilidad entre los componentes del sistema.

La utilización de Docker y herramientas modernas permite que el sistema pueda ejecutarse en diferentes equipos sin problemas de configuración.