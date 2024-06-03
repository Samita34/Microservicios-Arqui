CREATE DATABASE IF NOT EXISTS payments_db;
USE payments_db;

CREATE TABLE IF NOT EXISTS payments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    method VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    transaction_id VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO payments (order_id, amount, method, status, transaction_id) VALUES 
(1, 49.99, 'Credit Card', 'Completed', 'txn_1001'),
(2, 99.99, 'PayPal', 'Pending', 'txn_1002'),
(3, 29.99, 'Credit Card', 'Failed', 'txn_1003'),
(2, 99.99, 'Credit Card', 'Completed', 'txn_1004'),
(1, 49.99, 'Bank Transfer', 'Pending', 'txn_1005');
