--Part 1

CREATE TABLE Customers(
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100),
    City VARCHAR(50),
    SignupDate DATE
);

CREATE TABLE Orders(
    OrderID INT PRIMARY KEY,
    CustomerID INT,
    OrderDate DATE,
    TotalAmount DECIMAL(10,2),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Products(
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100),
    Category VARCHAR(50),
    Price DECIMAL(10,2)
);

CREATE TABLE OrderDetails(
    OrderDetailID INT PRIMARY KEY,
    OrderID INT,
    ProductID INT,
    Quantity INT,
    Price DECIMAL(10,2),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

--Part 2

--Basic Queries

SELECT * FROM customers;

SELECT * FROM Orders
WHERE OrderDate>= CURDATE()-INTERVAL 30 DAY;

SELECT ProductName,Price
FROM Products;

SELECT Category,COUNT(ProductID)
FROM Products
GROUP BY Category;

--Filtering and Conditions

SELECT * FROM Customers
WHERE City ='Mumbai';

SELECT * FROM Orders
WHERE TotalAmount>5000;

SELECT * FROM Customers
WHERE SignupDate> '2024-01-01';

--Joins

SELECT Orders.OrderID,Customers.Name
FROM Orders
JOIN Customers
ON Customers.CustomerID = Orders.CustomerID;

SELECT OrderDetails.OrderID,Products.ProductName
FROM OrderDetails
JOIN Products
ON OrderDetails.ProductID=Products.ProductID;

SELECT Cu.Name
FROM Customers AS Cu
LEFT JOIN Orders AS O
ON Cu.CustomerID=O.CustomerID
WHERE O.OrderID IS NULL;

--Aggregation and Grouping

SELECT SUM(TotalAmount)
FROM Orders
GROUP BY CustomerID;

SELECT ProductID,SUM(Quantity)
FROM OrderDetails
GROUP BY ProductID
ORDER BY SUM(Quantity) DESC
LIMIT 1;

SELECT CustomerID, AVG(TotalAmount)
FROM Orders
GROUP BY CustomerID;

SELECT Products.Category,SUM(OrderDetails.Price)
FROM OrderDetails
JOIN Products
ON OrderDetails.ProductID=Products.ProductID
GROUP BY Products.Category;

--Subqueries

SELECT CustomerID FROM Orders 
GROUP BY CustomerID
HAVING SUM(TotalAmount)>
(SELECT AVG(Total)
FROM
(SELECT SUM(TotalAmount) AS Total
FROM Orders
GROUP BY CustomerID) AS Avg_moneyspent);

SELECT ProductID
FROM Products
WHERE ProductID NOT IN
(SELECT DISTINCT ProductID
FROM OrderDetails); 

SELECT CustomerID,MAX(OrderDate)
FROM Orders
GROUP BY CustomerID;

--Advanced Queries

SELECT CustomerID, SUM(TotalAmount),RANK () OVER (ORDER BY SUM(TotalAmount)DESC) AS RANKING
FROM Orders
GROUP BY CustomerID;

SELECT CustomerID,COUNT(*)
FROM Orders
GROUP BY CustomerID
ORDER BY COUNT(*) DESC
LIMIT 3;

SELECT OrderDetails.ProductID,COUNT(DISTINCT(Orders.CustomerID))
FROM Orders
JOIN OrderDetails
ON OrderDetails.OrderID=Orders.OrderID
GROUP BY OrderDetails.ProductID;

