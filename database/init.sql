CREATE TABLE IF NOT EXISTS categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(120) NOT NULL UNIQUE,
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS customers (
    id BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    phone VARCHAR(40)
);

CREATE TABLE IF NOT EXISTS products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description VARCHAR(255),
    price NUMERIC(12,2) NOT NULL,
    stock INTEGER NOT NULL,
    image_url VARCHAR(500),
    category_id BIGINT REFERENCES categories(id)
);

CREATE TABLE IF NOT EXISTS carts (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL REFERENCES customers(id),
    status VARCHAR(30) NOT NULL,
    subtotal NUMERIC(12,2) NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS cart_items (
    id BIGSERIAL PRIMARY KEY,
    cart_id BIGINT NOT NULL REFERENCES carts(id) ON DELETE CASCADE,
    product_id BIGINT NOT NULL REFERENCES products(id),
    quantity INTEGER NOT NULL,
    unit_price NUMERIC(12,2) NOT NULL,
    line_total NUMERIC(12,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL REFERENCES customers(id),
    cart_id BIGINT NOT NULL REFERENCES carts(id),
    total NUMERIC(12,2) NOT NULL,
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS order_items (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL REFERENCES orders(id) ON DELETE CASCADE,
    product_id BIGINT NOT NULL REFERENCES products(id),
    product_name VARCHAR(150) NOT NULL,
    quantity INTEGER NOT NULL,
    unit_price NUMERIC(12,2) NOT NULL,
    line_total NUMERIC(12,2) NOT NULL
);

INSERT INTO categories (name, description) VALUES
('Tecnología', 'Accesorios y dispositivos'),
('Hogar', 'Artículos prácticos para el hogar'),
('Oficina', 'Productos para estudio y trabajo')
ON CONFLICT (name) DO NOTHING;

INSERT INTO customers (full_name, email, phone) VALUES
('Valentina Rojas', 'valentina@novashop.com', '3001112233'),
('Mateo Cárdenas', 'mateo@novashop.com', '3004445566')
ON CONFLICT (email) DO NOTHING;

INSERT INTO products (name, description, price, stock, image_url, category_id) VALUES
('Mouse Inalámbrico Nova', 'Mouse ergonómico con conexión USB', 75000, 20, 'https://images.unsplash.com/photo-1527864550417-7fd91fc51a46?auto=format&fit=crop&w=900&q=80', 1),
('Lámpara Minimal Aura', 'Lámpara de escritorio LED', 98000, 15, 'https://images.unsplash.com/photo-1505693416388-ac5ce068fe85?auto=format&fit=crop&w=900&q=80', 2),
('Agenda Ejecutiva 2026', 'Agenda elegante para organización diaria', 42000, 30, 'https://images.unsplash.com/photo-1517842645767-c639042777db?auto=format&fit=crop&w=900&q=80', 3)
ON CONFLICT DO NOTHING;
