

DROP VIEW IF EXISTS order_info;

#Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
#with latest ordered items should be displayed first for last 60 days.
CREATE VIEW order_info
AS SELECT orders.id, product.name, product.price, users.first_name, users.email, orders.order_time, order_item.status
FROM orders
INNER JOIN order_item
ON orders.id = order_item.order_id
INNER JOIN users
ON orders.user_id = users.id
INNER JOIN product
ON product.id = order_item.product_id
WHERE orders.order_time > ( DATE_SUB( CURDATE(), INTERVAL 60 DAY ) )
ORDER BY orders.order_time DESC;

SELECT * 
FROM order_info;

#Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT * 
FROM order_info 
WHERE status = "shipped";

# Use the above view to display the top 5 most selling products.
SELECT name,COUNT(name) as total_quantity
FROM order_info 
GROUP BY order_info.name
ORDER BY total_quantity DESC
LIMIT 10;