# 🧪 Manual de Pruebas – NovaShop MVP

## 📑 Introducción

El presente documento describe las pruebas realizadas al sistema **NovaShop MVP**, un sistema de carrito de compras desarrollado utilizando tecnologías modernas como **Spring Boot**, **React**, **PostgreSQL** y **Docker**.

El objetivo de este manual es verificar el correcto funcionamiento del sistema, validar la persistencia de datos en la base de datos y garantizar que los servicios del sistema respondan correctamente a las solicitudes del usuario.

---

# Tipos de pruebas realizadas

Durante el desarrollo del proyecto se realizaron los siguientes tipos de pruebas:

Pruebas funcionales  
Pruebas de conexión  
Pruebas de persistencia  
Pruebas de integración  
Pruebas de ejecución del sistema  

Estas pruebas permitieron validar el funcionamiento correcto del sistema en cada uno de sus módulos.

---

# Entorno de pruebas

Las pruebas se realizaron en el siguiente entorno:

Sistema operativo:

Windows 10 / Windows 11

Herramientas utilizadas:

Visual Studio Code  
Docker Desktop  
Postman / Navegador web  
GitHub  

Tecnologías utilizadas:

Backend:

Java 17  
Spring Boot  

Frontend:

React  
Vite  

Base de datos:

PostgreSQL  

Contenedores:

Docker  

---

# Casos de prueba

## Caso de prueba 1 — Obtener productos

Descripción:

Verificar que el sistema permite consultar los productos registrados en la base de datos.

Endpoint:

http://localhost:8080/api/products

Método:

GET

Resultado esperado:

El sistema debe retornar una lista de productos en formato JSON.

Resultado obtenido:

El sistema respondió correctamente mostrando los productos registrados.

Estado:

Prueba exitosa

---

## Caso de prueba 2 — Crear producto

Descripción:

Verificar que el sistema permite registrar un nuevo producto.

Endpoint:

http://localhost:8080/api/products

Método:

POST

Datos enviados:

{
  "name": "Laptop",
  "price": 2500000,
  "stock": 10
}

Resultado esperado:

El sistema debe registrar el producto en la base de datos.

Resultado obtenido:

El producto fue registrado correctamente.

Estado:

Prueba exitosa

---

## Caso de prueba 3 — Verificar conexión a la base de datos

Descripción:

Verificar que el backend se conecta correctamente a la base de datos PostgreSQL.

Resultado esperado:

El sistema debe conectarse sin errores.

Resultado obtenido:

La conexión se realizó correctamente.

Estado:

Prueba exitosa

---

## Caso de prueba 4 — Ejecutar sistema con Docker

Descripción:

Verificar que el sistema se ejecuta correctamente utilizando Docker.

Comando ejecutado:

docker compose up --build

Resultado esperado:

El sistema debe iniciar correctamente.

Resultado obtenido:

Los contenedores del backend y la base de datos se ejecutaron correctamente.

Estado:

Prueba exitosa

---

# Resultados generales

Todas las pruebas realizadas al sistema NovaShop MVP fueron ejecutadas correctamente, demostrando que el sistema cumple con los requisitos funcionales definidos en el proyecto.

El sistema permite:

Consultar productos  
Registrar productos  
Persistir información en la base de datos  
Ejecutarse mediante Docker  

---

# Evidencias de pruebas

Las evidencias de las pruebas realizadas se encuentran almacenadas en la carpeta:

docs/img

Estas evidencias incluyen:

Capturas de ejecución del sistema  
Capturas de los endpoints  
Capturas del funcionamiento del sistema  
Capturas de Docker en ejecución  

---

# Conclusión

El sistema NovaShop MVP fue probado satisfactoriamente y se verificó que cumple con los requisitos funcionales definidos.

Las pruebas realizadas demostraron que el sistema es estable, funcional y capaz de ejecutarse correctamente en un entorno controlado.