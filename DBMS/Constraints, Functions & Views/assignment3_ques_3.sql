SELECT users.first_name, COUNT(orders.id) as number_of_orders
FROM users, orders
WHERE users.id = orders.user_id
AND orders.order_time > (DATE_SUB(CURDATE(), INTERVAL 30 DAY) )
AND users.type = "shopper";


SELECT users.first_name, SUM(orders.total) as revenue
FROM users 
INNER JOIN orders
ON users.id = orders.user_id
GROUP BY users.first_name
ORDER BY revenue DESC
LIMIT 10;


SELECT product.name, COUNT(order_item.product_id) as total_quantity
FROM product 
INNER JOIN order_item
ON product.id = order_item.product_id
INNER JOIN orders
ON orders.id = order_item.order_id
WHERE orders.order_time > (DATE_SUB( CURDATE(), INTERVAL 60 DAY) )
GROUP BY order_item.product_id
ORDER BY total_quantity DESC
LIMIT 20;


SELECT MONTHNAME(orders.order_time) as month, YEAR(orders.order_time) as year ,sum(orders.total) as revenue
FROM orders
WHERE orders.order_time > (DATE_SUB( CURDATE(), INTERVAL 6 MONTH) )
GROUP BY month
ORDER BY order_time DESC;


SET SQL_SAFE_UPDATES = 0;


UPDATE product
SET product.status = "INACTIVE"
WHERE product.id NOT IN ( 
    SELECT DISTINCT order_item.product_id 
    FROM orders
    INNER JOIN order_item
    ON order_item.order_id = orders.id
    WHERE orders.order_time > ( DATE_SUB( CURDATE(), INTERVAL 90 DAY) )
    );
    

SELECT * FROM product; 


SET SQL_SAFE_UPDATES = 1;


SELECT product.name, category.title as category 
FROM product
INNER JOIN product_category
ON product.id = product_category.product_id
INNER JOIN category
ON product_category.category_id = category.id
WHERE category.title LIKE "%obi%" ;


SELECT product.name, count(order_item.product_id) as number_of_cancellation
FROM product
INNER JOIN order_item
ON order_item.product_id = product.id
WHERE order_item.status = "returned"
GROUP BY order_item.product_id 
ORDER BY number_of_cancellation DESC
LIMIT 10;
