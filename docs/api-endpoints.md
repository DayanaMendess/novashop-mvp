# API Endpoints

## Clientes
- `GET /api/customers`
- `POST /api/customers`

## Categorías
- `GET /api/categories`
- `POST /api/categories`

## Productos
- `GET /api/products`
- `GET /api/products/category/{categoryId}`
- `POST /api/products`

## Carritos
- `POST /api/carts`
- `GET /api/carts/{id}`
- `POST /api/carts/{cartId}/items`
- `PUT /api/carts/{cartId}/items/{itemId}`
- `DELETE /api/carts/{cartId}/items/{itemId}`

## Pedidos
- `POST /api/orders/checkout/{cartId}`
- `GET /api/orders`
- `GET /api/orders/{id}`
