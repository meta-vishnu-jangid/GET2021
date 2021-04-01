#Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
SELECT product.id, product.name, category.title, product.price 
FROM product, category, product_category 
WHERE product_category.product_id = product.id AND product_category.category_id = category.id AND quantity > 0
ORDER BY product.id DESC;


#Display the list of products which don't have any images. 
SELECT product.id, product.name, product.price 
FROM product
WHERE product.id NOT IN ( SELECT DISTINCT product_id FROM product_image);

#Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title.
#(If Category is top category then Parent Category Title column should display “Top Category” as value.)
SELECT child.id, child.title, IFNULL(parent.title, 'Top Category') AS parent_category 
FROM category child
LEFT JOIN category parent
ON child.parent_category = parent.id
ORDER BY parent.title, child.title;

#Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)
SELECT child.id, child.title, IFNULL(parent.title, 'Top Category') AS parent_category 
FROM category child
LEFT JOIN category parent
ON child.parent_category = parent.id
WHERE child.id NOT IN (SELECT DISTINCT parent_category FROM category WHERE parent_category is NOT NULL);

#Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
SELECT product.price, product.name, product.description
FROM product, product_category, category
WHERE product.id = product_category.product_id AND product_category.category_id = category.id AND category.title = "Mobile";  

#Display the list of Products whose Quantity on hand (Inventory) is under 50.
SELECT product.name
FROM product
WHERE quantity < 50;

#Display Recent 50 Orders placed (Id, Order Date, Order Total).
SELECT orders.id , orders.order_time, orders.total
FROM orders
ORDER BY order_time DESC
LIMIT 50;