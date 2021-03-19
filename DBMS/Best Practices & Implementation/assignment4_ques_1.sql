DROP FUNCTION IF EXISTS numberOfOrdersInMonth;
DROP FUNCTION IF EXISTS monthWithMaxOrderInYear;


#Create a function to calculate number of orders in a month. 
# Month and year will be input parameter to function.
DELIMITER //
CREATE FUNCTION numberOfOrdersInMonth (ofMonth INT, ofYear INT)
 RETURNS INT NOT DETERMINISTIC
BEGIN 
    DECLARE number_of_orders INT;
    
    SELECT COUNT(*) INTO number_of_orders 
    FROM orders 
    WHERE MONTH(order_time) = ofMonth AND YEAR(order_time) = ofYear ;
    
    RETURN(number_of_orders);
    
END//

DELIMITER ;

SELECT numberOfOrdersInMonth(03,2021);
SELECT numberOfOrdersInMonth(02,2021);
SELECT numberOfOrdersInMonth(01,2021);



# Create a function to return month in a year having maximum orders.
# Year will be input parameter.
DELIMITER //
CREATE FUNCTION monthWithMaxOrderInYear (ofYear INT)
 RETURNS VARCHAR(10) NOT DETERMINISTIC
BEGIN 
    DECLARE monthWithMaxOrder VARCHAR(10);
    
    SELECT ordersInMonth.monthOfOrder INTO monthWithMaxOrder
    FROM (SELECT MONTHNAME(order_time) as monthOfOrder ,COUNT(*) AS number_of_orders 
    FROM orders 
    WHERE YEAR(order_time) = ofYear
    GROUP BY monthOfOrder 
    ORDER BY number_of_orders DESC) ordersInMonth
    LIMIT 1;
    
    RETURN(monthWithMaxOrder);
    
END//

DELIMITER ;

SELECT monthWithMaxOrderInYear(2021);
SELECT monthWithMaxOrderInYear(2020);