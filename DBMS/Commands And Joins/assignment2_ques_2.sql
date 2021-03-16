SELECT product.id, product.name, category.title, product.price 
FROM product, category, product_category 
WHERE product_category.product_id = product.id AND product_category.category_id = category.id AND quantity > 0
ORDER BY product.id DESC;

SELECT product.id, product.name, product.price 
FROM product
WHERE product.id NOT IN ( SELECT DISTINCT product_id FROM product_image);

SELECT child.id, child.title, IFNULL(parent.title, 'Top Category') AS parent_category 
FROM category child
LEFT JOIN category parent
ON child.parent_category = parent.id
ORDER BY parent.title, child.title;


SELECT child.id, child.title, IFNULL(parent.title, 'Top Category') AS parent_category 
FROM category child
LEFT JOIN category parent
ON child.parent_category = parent.id
WHERE child.id NOT IN (SELECT DISTINCT parent_category FROM category WHERE parent_category is NOT NULL);

SELECT product.price, product.name, product.description
FROM product, product_category, category
WHERE product.id = product_category.product_id AND product_category.category_id = category.id AND category.title = "Mobile";  

SELECT product.name
FROM product
WHERE quantity < 50;

SELECT orders.id , orders.order_time, orders.total
FROM orders
ORDER BY order_time DESC
LIMIT 50;