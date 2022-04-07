SELECT o.*
FROM orders o
JOIN users u ON o.USER_ID = u.USER_ID
WHERE u.FIRST_NAME = 'Marion';

SELECT *
FROM users u
WHERE u.USER_ID NOT IN (SELECT o.USER_ID FROM orders o);

SELECT i.NAME, i.PRICE
FROM items i
JOIN order_items oi ON i.ITEM_ID = oi.ITEM_ID
JOIN orders o ON oi.ORDER_ID = o.ORDER_ID
GROUP BY i.NAME
HAVING COUNT(o.ORDER_ID) >= 2;

SELECT o.ORDER_ID, i.NAME, i.PRICE, oi.QUANTITY
FROM orders o
JOIN stores s ON o.STORE_ID = s.STORE_ID
JOIN order_items oi ON o.ORDER_ID = oi.ORDER_ID
JOIN items i ON oi.ITEM_ID = i.ITEM_ID
WHERE s.CITY = 'New York'
ORDER BY o.ORDER_ID ASC;

SELECT i.NAME AS 'ITEM_NAME', (i.PRICE * SUM(oi.QUANTITY)) AS 'REVENUE'
FROM items i
JOIN order_items oi ON i.ITEM_ID = oi.ITEM_ID
GROUP BY i.ITEM_ID;

SELECT s.NAME AS 'Store Name', COUNT(o.ORDER_ID) AS 'Order_Quantity',
	CASE
		WHEN COUNT(o.ORDER_ID) > 3 THEN 'High'
		WHEN COUNT(o.ORDER_ID) <= 3 AND COUNT(o.ORDER_ID) > 1 THEN 'Medium'
		ELSE 'Low'
	END AS 'Sales Figure'
FROM stores s
JOIN orders o ON s.STORE_ID = o.STORE_ID
GROUP BY s.STORE_ID
ORDER BY Order_Quantity DESC;