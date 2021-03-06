#Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT id, name, COUNT(id) as count_of_category
FROM product, product_category
WHERE product.id = product_category.product_id
AND ( SELECT COUNT(category_id) AS count_of_category FROM product_category WHERE product.id = product_category.product_id ) > 1 
GROUP BY product.id ;

#Display Count of products as per below price range 0-100, 100-500, >500
SELECT pnew.rangeofprice , count(*) 
FROM (SELECT CASE
       WHEN price > 0 AND price <= 100 THEN '0-100'
       WHEN price > 100 AND price <= 500 THEN '100-500'
       ELSE 'Above 500' END AS rangeofprice
   FROM product) pnew
GROUP BY pnew.rangeofprice;


#Display the Categories along with number of products under each category.
SELECT  category.title,product_category.category_id , count(*)
FROM product_category 
INNER JOIN category
ON product_category.category_id = category.id
GROUP BY product_category.category_id