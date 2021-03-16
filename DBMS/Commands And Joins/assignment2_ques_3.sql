SELECT orders.id , orders.order_time, orders.total
FROM orders
ORDER BY order_time DESC
LIMIT 50;

SELECT orders.id , orders.order_time, orders.total
FROM orders
ORDER BY total DESC
LIMIT 10;

SELECT o.id , o.total
FROM orders o
WHERE
o.order_time < (DATE_SUB(CURDATE(), INTERVAL 10 DAY))
AND
o.id IN (SELECT DISTINCT order_id FROM order_item WHERE status = "placed");

SELECT users.first_name
FROM users
WHERE users.id NOT IN ( SELECT DISTINCT user_id FROM orders WHERE order_time > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH) ))
AND users.type = "shopper";

SELECT users.first_name, orders.id, orders.total
FROM users, orders
WHERE users.id = orders.user_id
AND orders.order_time > (DATE_SUB(CURDATE(), INTERVAL 15 DAY) )
AND users.type = "shopper";

SELECT order_item.product_id, order_item.status 
FROM order_item
WHERE status = "shipped"
AND order_id = 2 ;

SELECT  orders.id, order_item.product_id,product.name, orders.order_time
FROM orders, order_item , product
WHERE orders.id = order_item.order_id
AND order_item.product_id = product.id
AND product.price > 19999
AND product.price < 50001;