docker-compose up -d
---
#products
docker exec -it service-products-db bash
mysql -u root -p
SHOW DATABASES;
USE products_db;
SHOW TABLES;
SELECT * FROM products;
---
#users
docker exec -it service-users-db bash
mysql -u root -p
SHOW DATABASES;
USE users_db;
SHOW TABLES;
SELECT * FROM users;
---
#orders
docker exec -it service-orders-db bash
mysql -u root -p
SHOW DATABASES;
USE orders_db;
SHOW TABLES;
SELECT * FROM orders;
SELECT * FROM order_items;
---
#payments
docker exec -it service-payments-db bash
mysql -u root -p
SHOW DATABASES;
USE payments_db;
SHOW TABLES;
SELECT * FROM payments;