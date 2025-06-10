--Part 1
CREATE DATABASE inventory;

CREATE TABLE customers(
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    city VARCHAR(50) DEFAULT "Mumbai",
    signupdate DATE
    CONSTRAINT CHK_customer CHECK(signupdate<'1947-01-01')
)AUTO_INCREMENT = 1;;

CREATE TABLE orders(
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    orderdate DATE NOT NULL,
    totalamount DECIMAL(10,2) NOT NULL,
    CONSTRAINT FK_customerorder
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
)AUTO_INCREMENT = 101;;

CREATE TABLE products(
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    productname VARCHAR(100) NOT NULL,
    category VARCHAR(50) DEFAULT "Electronics",
    product_price DECIMAL(10,2) NOT NULL
)AUTO_INCREMENT = 301;;

CREATE TABLE orderdetails(
    orderdetail_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    CONSTRAINT FK_orderdetailsorder
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    CONSTRAINT FK_orderdetailsproduct
    FOREIGN KEY (product_id) REFERENCES products(product_id)
)AUTO_INCREMENT = 501;;


INSERT INTO customers (name, email, city, signupdate) VALUES
('Aryananda S', 'aryananda@example.com', 'Mumbai', '2024-02-15'),
('Rishikesh P', 'rishikesh@example.com', 'Bengaluru', '2023-12-10'),
('Nila M', 'nila@example.com', 'Chennai', '2024-04-01');

INSERT INTO orders (customer_id, orderdate, totalamount) VALUES
(1, '2024-05-01', 3200.00), 
(2, '2024-05-20', 5600.00); 


INSERT INTO products (productname, category, product_price) VALUES
('Wireless Mouse', 'Electronics', 800.00),
('Bluetooth Speaker', 'Electronics', 1500.00),
('Notebook', 'Stationery', 100.00);

INSERT INTO orderdetails (order_id, product_id, quantity, price) VALUES
(101, 301, 2, 1600.00),   
(101, 303, 5, 500.00),   
(102, 302, 2, 3000.00),  
(102, 301, 2, 1600.00);  

--Index
CREATE INDEX productpricename
ON products (productname,product_price);

CREATE INDEX customerdetail
ON customers (customer_id);


CREATE INDEX customercity
ON customers (city);

--Part 2

--Basic Queries

SELECT customer_id
FROM customers USE INDEX(customerdetail);

SELECT order_id FROM orders
WHERE orderdate>= CURDATE()-INTERVAL 30 DAY;

SELECT productname,product_price
FROM products USE INDEX(productnameprice);

SELECT category,COUNT(product_id)
FROM products
GROUP BY category;

--Filtering and Conditions

SELECT customer_id
FROM customers
WHERE City='Mumbai';

SELECT order_id FROM orders
WHERE totalamount>5000;

SELECT customerid_name FROM customers
WHERE signupdate> '2024-01-01';

--Joins

SELECT orders.order_id,customers.name
FROM orders
JOIN customers
ON customers.customer_id = orders.customer_id;

SELECT orderdetails.order_id,products.productname
FROM orderdetails
JOIN products
ON orderdetails.product_id=products.product_id;

SELECT cu.name
FROM customers AS cu
LEFT JOIN orders
ON cu.customer_id=orders.customer_id
WHERE orders.order_id IS NULL;

--Aggregation and Grouping

SELECT SUM(totalamount)
FROM orders
GROUP BY customer_id;

SELECT product_id,SUM(quantity)
FROM orderdetails
GROUP BY product_id
ORDER BY SUM(quantity) DESC
LIMIT 1;

SELECT customer_id, AVG(totalamount)
FROM orders
GROUP BY customer_id;

SELECT products.category,SUM(orderdetails.Price)
FROM orderdetails
JOIN products
ON orderdetails.product_id=products.product_id
GROUP BY products.category;

--Subqueries

SELECT customer_id FROM orders 
GROUP BY customer_id
HAVING SUM(totalamount)>
(SELECT AVG(Total)
FROM
(SELECT SUM(totalamount) AS Total
FROM orders
GROUP BY customer_id) AS Avg_moneyspent);

SELECT product_id
FROM products
WHERE product_id NOT IN
(SELECT DISTINCT product_id
FROM orderdetails); 

SELECT customer_id,MAX(orderdate)
FROM orders
GROUP BY customer_id;

--Advanced Queries

SELECT customer_id, SUM(totalamount),RANK () OVER (ORDER BY SUM(totalamount)DESC) AS RANKING
FROM orders
GROUP BY customer_id;

SELECT customer_id,COUNT(*)
FROM orders
GROUP BY customer_id
ORDER BY COUNT(*) DESC
LIMIT 3;

SELECT orderdetails.product_id,COUNT(DISTINCT(orders.customer_id))
FROM orders
JOIN orderdetails
ON orderdetails.order_id=orders.order_id
GROUP BY orderdetails.product_id;

