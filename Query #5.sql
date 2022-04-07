SELECT p.productName AS "Name", p.productLine AS "Product Line", p.buyPrice AS "Buy Price" 
FROM products p
ORDER BY p.buyPrice DESC;

SELECT c.contactFirstName AS "First Name", c.contactLastName AS "Last Name", c.city AS "City"
FROM customers c
WHERE c.country = 'Germany'
ORDER BY c.contactLastName ASC;

SELECT DISTINCT o.`status`
FROM orders o
ORDER BY o.`status` ASC;

SELECT *
FROM payments p
WHERE p.paymentDate >= '2005-01-01'
ORDER BY p.paymentDate ASC;

SELECT e.lastName, e.firstName, e.email, e.jobTitle
FROM employees e
WHERE e.officeCode = (SELECT DISTINCT o.officeCode FROM offices o WHERE o.city = 'San Francisco')
ORDER BY e.lastName;

SELECT p.productName, p.productLine, p.productScale, p.productVendor
FROM products p
WHERE p.productLine IN ("Vintage Cars", "Classic Cars")
ORDER BY p.productLine DESC, p.productName ASC;

