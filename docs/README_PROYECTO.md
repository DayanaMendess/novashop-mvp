# 🛒 NovaShop MVP — Descripción del Proyecto

## 1. Descripción general

**NovaShop MVP** es una aplicación web diseñada para simular el flujo básico de compra de una tienda virtual, permitiendo la gestión de clientes, productos, carritos y pedidos dentro de un entorno controlado.

El proyecto fue desarrollado como parte de un ejercicio académico orientado a demostrar la implementación de una arquitectura moderna basada en servicios, separación de responsabilidades y buenas prácticas de desarrollo de software.

La solución integra un **frontend**, un **backend**, una **base de datos** y un entorno de ejecución mediante **contenedores Docker**, permitiendo que el sistema sea ejecutado de manera consistente en diferentes equipos y ambientes.

---

## 2. Objetivo general

Desarrollar un sistema funcional de carrito de compras que permita administrar clientes, productos, carritos y pedidos, aplicando principios de organización del software, modularidad y control de versiones, con el fin de simular el funcionamiento de una tienda virtual en un entorno académico.

---

## 3. Objetivos específicos

- Diseñar y construir una API REST utilizando **Spring Boot**.
- Implementar una interfaz web moderna utilizando tecnologías actuales de desarrollo frontend.
- Modelar y administrar la base de datos utilizando **PostgreSQL**.
- Implementar la persistencia de datos mediante el uso de **JPA / Hibernate**.
- Contenerizar los servicios del sistema utilizando **Docker**.
- Configurar el proyecto para su ejecución en ambientes locales.
- Documentar la arquitectura, los ambientes y los procesos de ejecución del sistema.
- Aplicar buenas prácticas de organización del código y control de versiones mediante **Git y GitHub**.

---

## 4. Alcance funcional

El sistema **NovaShop MVP** permite realizar las siguientes operaciones:

### Gestión de clientes

- Registro de clientes
- Consulta de clientes
- Validación de datos de cliente

### Gestión de productos

- Registro de productos
- Consulta de productos
- Actualización de información de productos
- Control de stock

### Gestión de carrito de compras

- Creación de carrito
- Agregado de productos al carrito
- Eliminación de productos del carrito
- Cálculo del total de la compra

### Gestión de pedidos

- Confirmación de compra
- Generación de pedido
- Consulta de pedidos realizados

---

## 5. Arquitectura del sistema

El sistema está diseñado bajo una arquitectura cliente-servidor, organizada en capas y componentes independientes.

Los componentes principales son:

Frontend  
Backend  
Base de datos  
Docker  

La comunicación entre los componentes se realiza mediante servicios REST utilizando el protocolo HTTP.

Esta arquitectura permite:

- Separación de responsabilidades
- Escalabilidad del sistema
- Facilidad de mantenimiento
- Reutilización de componentes
- Despliegue controlado

---

## 6. Tecnologías utilizadas

### Backend

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

### Frontend

- React
- JavaScript
- HTML
- CSS
- Vite

### Base de datos

- PostgreSQL

### Infraestructura

- Docker
- Docker Compose
- Git
- GitHub

---

## 7. Ambientes del sistema

El proyecto simula el funcionamiento de diferentes ambientes de desarrollo, permitiendo representar el ciclo de vida de un sistema real.

Los ambientes definidos son:

DEV — Desarrollo  
QA — Pruebas  
MAIN — Producción  

Cada ambiente representa una etapa del desarrollo del sistema y permite validar el comportamiento del software antes de su liberación final.

---

## 8. Valor académico del proyecto

El proyecto **NovaShop MVP** representa una evidencia práctica del aprendizaje adquirido en el área de desarrollo de software y arquitectura de sistemas.

Este proyecto permite demostrar:

- Organización de un repositorio profesional
- Separación entre frontend y backend
- Implementación de servicios REST
- Modelado de base de datos relacional
- Uso de contenedores Docker
- Documentación técnica del sistema
- Control de versiones con Git y GitHub
- Simulación de ambientes de desarrollo
- Aplicación de buenas prácticas de ingeniería de software

---

## 9. Conclusión

El desarrollo del proyecto **NovaShop MVP** permitió aplicar conocimientos de programación, arquitectura de software y gestión de proyectos tecnológicos, integrando múltiples herramientas y tecnologías en una solución funcional.

El sistema demuestra la capacidad de construir aplicaciones web estructuradas, documentadas y ejecutables en entornos controlados, cumpliendo con los requisitos académicos establecidos.