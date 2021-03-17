DROP PROCEDURE IF EXISTS averageSales;
DROP PROCEDURE IF EXISTS orderDeatailInPeriod;

#Create a Stored procedure to retrieve average sales of each product in a month.
# Month and year will be input parameter to function.
DELIMITER $$ 
CREATE PROCEDURE averageSales(ofMonth INT,ofYear INT)
BEGIN
    SELECT product.name, SUM(order_item.quantity)/DAY(LAST_DAY(orders.order_time)) as averageQuantity, 
    SUM(order_item.quantity)*product.price/DAY(LAST_DAY(orders.order_time)) as averagePrice
    FROM order_item
    INNER JOIN product
    ON order_item.product_id = product.id
    INNER JOIN orders
    ON order_item.order_id = orders.id
    WHERE MONTH(orders.order_time) = ofMonth AND YEAR(orders.order_time) = ofYear 
    GROUP BY order_item.product_id;
END$$

DELIMITER ; 

CALL averageSales(03,2021);




#Create a stored procedure to retrieve table having order detail with status for a given period.
# Start date and end date will be input parameter.
# Put validation on input dates like start date is less than end date.
# If start date is greater than end date take first date of month as start date.
DELIMITER $$ 
CREATE PROCEDURE orderDeatailInPeriod(startDate DATETIME,endDate DATETIME)
BEGIN
    
    IF startDate > endDate THEN
    SET startDate = DATE_SUB(DATE_ADD(LAST_DAY(endDate), INTERVAL 1 DAY), INTERVAL  1 MONTH);
    END IF;
    
    SELECT product.name, orders.id, order_item.status, orders.order_time FROM order_item
    INNER JOIN product
    ON order_item.product_id = product.id
    INNER JOIN orders
    ON order_item.order_id = orders.id
    WHERE orders.order_time >= startDate AND orders.order_time <= endDate ;
END$$

DELIMITER ;

CALL orderDeatailInPeriod("2021-01-01","2021-02-01");