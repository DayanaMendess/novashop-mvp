# 🧩 Arquitectura del Sistema – NovaShop MVP

## 1. Introducción

El sistema **NovaShop MVP** fue diseñado bajo una arquitectura cliente-servidor, organizada en componentes independientes que permiten una ejecución modular, escalable y fácil de mantener.

La solución integra:

Frontend  
Backend  
Base de datos  
Contenedores Docker  
API Gateway  

Esta arquitectura permite simular un entorno real de desarrollo de software, aplicando principios de separación de responsabilidades y buenas prácticas de ingeniería.

---

# 2. API Gateway

## ¿El proyecto tiene Gateway?

Actualmente el sistema NovaShop MVP utiliza un backend principal que expone los servicios REST del sistema.  
Sin embargo, la arquitectura está preparada para incorporar un **API Gateway**, el cual actuaría como punto central de acceso a los servicios del sistema.

El Gateway es responsable de:

- Recibir las solicitudes del frontend
- Redirigir las solicitudes al backend
- Controlar el acceso a los servicios
- Gestionar la seguridad
- Centralizar las rutas del sistema

---

## Función del API Gateway

El API Gateway permite:

- Centralizar las solicitudes
- Controlar el acceso a los servicios
- Manejar autenticación
- Registrar logs
- Aplicar reglas de seguridad
- Facilitar la escalabilidad del sistema

---

## Ejemplo de Gateway en el sistema

El Gateway escucha en:

http://localhost:8080


Y redirige solicitudes hacia:

Backend:
http://localhost:8081

Frontend:
http://localhost:5173



---

# 3. Diagrama de Arquitectura del Sistema

```mermaid
graph LR

Usuario --> Frontend
Frontend --> Gateway
Gateway --> Backend
Backend --> BaseDatos

Frontend[Frontend React]
Gateway[API Gateway]
Backend[Backend Spring Boot]
BaseDatos[(PostgreSQL Database)]