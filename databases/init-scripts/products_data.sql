CREATE DATABASE IF NOT EXISTS products_db;
USE products_db;

CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO products (name, description, price, stock) VALUES 
('Producto 1', 'Descripción del producto 1', 19.99, 100),
('Producto 2', 'Descripción del producto 2', 29.99, 200),
('Producto 3', 'Descripción del producto 3', 39.99, 300);
