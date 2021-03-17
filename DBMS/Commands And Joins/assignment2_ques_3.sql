#Display Recent 50 Orders placed (Id, Order Date, Order Total).
SELECT orders.id , orders.order_time, orders.total
FROM orders
ORDER BY order_time DESC
LIMIT 50;

#Display 10 most expensive Orders.
SELECT orders.id , orders.order_time, orders.total
FROM orders
ORDER BY total DESC
LIMIT 10;

#Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
SELECT o.id , o.total
FROM orders o
WHERE o.order_time < (DATE_SUB(CURDATE(), INTERVAL 10 DAY))
AND o.id IN (SELECT DISTINCT order_id FROM order_item WHERE status = "placed");

#Display list of shoppers which haven't ordered anything since last month.
SELECT users.first_name
FROM users
WHERE users.id NOT IN ( SELECT DISTINCT user_id FROM orders WHERE order_time > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH) ))
AND users.type = "shopper";

#Display list of shopper along with orders placed by them in last 15 days. 
SELECT users.first_name, orders.id, orders.total
FROM users, orders
WHERE users.id = orders.user_id
AND orders.order_time > (DATE_SUB(CURDATE(), INTERVAL 15 DAY) )
AND users.type = "shopper";

#Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
SELECT order_item.product_id, order_item.status 
FROM order_item
WHERE status = "shipped"
AND order_id = 2 ;

#Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
SELECT  orders.id, order_item.product_id,product.name, orders.order_time
FROM orders, order_item , product
WHERE orders.id = order_item.order_id
AND order_item.product_id = product.id
AND product.price >= 20000
AND product.price <= 50000;