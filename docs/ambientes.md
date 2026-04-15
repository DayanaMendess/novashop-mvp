# Ambientes del Proyecto

## Ambientes definidos

### develop
Ambiente de desarrollo continuo.  
Aquí se integran cambios funcionales en construcción.

### qa
Ambiente de pruebas.  
Se utiliza para validar integración, comportamiento general y revisión previa.

### main
Ambiente final o estable.  
Representa la versión lista para entrega o liberación.

## Flujo sugerido

```text
feature/catalogo-productos -> develop -> qa -> main
feature/carrito-compras   -> develop -> qa -> main
feature/pedidos           -> develop -> qa -> main
```

## Puertos sugeridos por ambiente para backend

- develop: `8081`
- qa: `8082`
- main: `8080`

## Bases de datos sugeridas por ambiente

- develop: `novashop_dev`
- qa: `novashop_qa`
- main: `novashop_prod`

Esto permite que cada ambiente sea independiente y no se afecten entre sí.
