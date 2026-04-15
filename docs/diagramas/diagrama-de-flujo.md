##  Diagrama de Flujo – Proceso General

```mermaid
flowchart TD

Inicio[Inicio] --> VerProductos[Ver productos]
VerProductos --> SeleccionarProducto[Seleccionar producto]
SeleccionarProducto --> AgregarCarrito[Agregar al carrito]
AgregarCarrito --> RevisarCarrito[Revisar carrito]
RevisarCarrito --> ConfirmarCompra[Confirmar compra]
ConfirmarCompra --> GenerarPedido[Generar pedido]
GenerarPedido --> Fin[Fin]
```