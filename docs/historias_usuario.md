# Historias de Usuario

## HU-01 Registrar cliente
**Como** administrador o usuario del sistema  
**Quiero** registrar un cliente  
**Para** poder asociarlo a compras futuras.

**Criterios de aceptación**
- Debe guardar nombre, correo y teléfono.
- El correo debe ser único.
- Debe permitir consultar clientes registrados.

## HU-02 Consultar catálogo
**Como** comprador  
**Quiero** visualizar los productos disponibles  
**Para** elegir qué deseo comprar.

**Criterios de aceptación**
- Debe mostrar nombre, precio, stock e imagen.
- Debe poder filtrar por categoría.

## HU-03 Crear carrito
**Como** comprador  
**Quiero** tener un carrito de compras  
**Para** ir agregando productos antes de confirmar el pedido.

**Criterios de aceptación**
- El carrito debe asociarse a un cliente.
- Debe iniciar en estado OPEN.
- Debe guardar subtotal calculado.

## HU-04 Agregar productos al carrito
**Como** comprador  
**Quiero** agregar uno o varios productos al carrito  
**Para** preparar mi compra.

**Criterios de aceptación**
- Debe validar stock disponible.
- Debe actualizar cantidades si el producto ya existe en el carrito.
- Debe recalcular el subtotal.

## HU-05 Confirmar pedido
**Como** comprador  
**Quiero** confirmar el carrito  
**Para** generar un pedido formal.

**Criterios de aceptación**
- Debe crear un pedido a partir del carrito.
- Debe cambiar el estado del carrito a CHECKED_OUT.
- Debe descontar stock.
