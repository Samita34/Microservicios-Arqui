CREATE DATABASE IF NOT EXISTS orders_db;
USE orders_db;

CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    status VARCHAR(50) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS order_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

INSERT INTO orders (user_id, status, total) VALUES 
(1, 'Pending', 49.99),
(2, 'Completed', 99.99),
(1, 'Shipped', 29.99);

INSERT INTO order_items (order_id, product_id, quantity, price) VALUES 
(1, 1, 2, 19.99),
(1, 2, 1, 29.99),
(2, 3, 1, 39.99),
(2, 2, 2, 29.99),
(3, 1, 1, 19.99);
