SELECT p.NAME AS Product, pt.NAME AS Type
FROM product p
JOIN product_type pt
ON p.PRODUCT_TYPE_CD = pt.PRODUCT_TYPE_CD;

SELECT b.NAME AS 'Branch Name', b.CITY AS 'City', e.LAST_NAME AS 'Lst Name', e.TITLE AS 'Title'
FROM branch b
JOIN employee e
ON b.BRANCH_ID = e.ASSIGNED_BRANCH_ID;

SELECT DISTINCT e.TITLE 
FROM employee e;

SELECT e.LAST_NAME AS 'Last Name', e.TITLE AS 'Title', 
	em.LAST_NAME AS 'Boss Last Name', em.TITLE AS 'Boss Title'
FROM employee e
LEFT JOIN employee em ON e.SUPERIOR_EMP_ID = em.EMP_ID


SELECT p.NAME AS 'Product Name', a.AVAIL_BALANCE AS 'Available Balance', i.LAST_NAME
FROM account a
JOIN customer c ON a.CUST_ID = c.CUST_ID
JOIN product p ON a.PRODUCT_CD = p.PRODUCT_CD
JOIN individual i ON c.CUST_ID  = i.CUST_ID

SELECT *
FROM acc_transaction t
JOIN account a ON t.ACCOUNT_ID = a.ACCOUNT_ID
JOIN customer c ON a.CUST_ID = c.CUST_ID
JOIN individual i ON c.CUST_ID = i.CUST_ID
WHERE i.LAST_NAME LIKE 'T%';

CREATE DATABASE EComWebSite;
DROP DATABASE ecomwebsite;

CREATE TABLE department (
depid INT(22) AUTO_INCREMENT NOT NULL,
dname VARCHAR(20) UNIQUE NOT NULL DEFAULT "NAME is pending" ,
dzipcode INT(10),
dareacode INT(10),
daddress VARCHAR(50) UNIQUE,
depcode INT(22),
depMini_wage DECIMAL(10,2) CHECK(depMini_wage >= 15),
depStatus ENUM('Active', 'deActive', 'onHold'),
	CONSTRAINT IDPK PRIMARY KEY(depid),
	UNIQUE(dzipcode,dareacode )
	);	