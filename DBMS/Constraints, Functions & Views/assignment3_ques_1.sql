show databases;

drop database IF EXISTS storeFront;

create database storeFront;

use storeFront;

#creating users table
create table users (  
    id INT NOT NULL AUTO_INCREMENT, 
    first_name VARCHAR(50) NOT NULL, 
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    type VARCHAR(7) CHECK(type ="admin"), 
    PRIMARY KEY(id)
) ;

#creating zipcode table
CREATE TABLE zipcode(
    city VARCHAR(30) NOT NULL,
    state VARCHAR(30) NOT NULL,
    pincode VARCHAR(6) NOT NULL,
    PRIMARY KEY(pincode)
);


#creating address table
CREATE TABLE address
(
    id INTEGER AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    house_no VARCHAR(7) NOT NULL,
    street VARCHAR(30) NOT NULL,
    country VARCHAR(30) DEFAULT "India",
    pincode VARCHAR(6) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(pincode) REFERENCES zipcode(pincode)
);


#creating category table
create table category (  
    id INT NOT NULL AUTO_INCREMENT , 
    title VARCHAR(100) NOT NULL , 
    parent_category INT, PRIMARY KEY(ID), 
    FOREIGN KEY(parent_category) REFERENCES category(id) 
);

#creating product table
create table product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price VARCHAR(10) NOT NULL CHECK ( price > 0),
    description TEXT NOT NULL,
    status VARCHAR(8) DEFAULT "ACTIVE" CHECK (status IN ("active","inactive")),
    quantity INT(5) NOT NULL CHECK ( quantity >= 0),
    PRIMARY KEY(id)
) ;


#creating table for map between category and product
CREATE TABLE product_category(
    product_id INT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY(product_id, category_id),
    FOREIGN KEY(product_id) REFERENCES product(id),
    FOREIGN KEY(category_id) REFERENCES category(id) 
);


#creataing product_image table
create table product_image (
    id INTEGER AUTO_INCREMENT,
    product_id INT NOT NULL, 
    image_url TEXT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(product_id) REFERENCES product(id)
);

#cretaing category table
CREATE TABLE orders (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    order_time DATETIME NOT NULL,
    total FLOAT NOT NULL,
    address_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(address_id) REFERENCES address(id)
);

#creating order_item table
CREATE TABLE order_item (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    deliver_time DATETIME,
    status VARCHAR(30) CHECK(status IN ("shipped", "placed","delivered","returned")) ,
    PRIMARY KEY(order_id,product_id),
    FOREIGN KEY(product_id) REFERENCES product(id)
);



SHOW TABLES;

DROP TABLE orders;
DROP TABLE order_item;
DROP TABLE product_image;
DROP TABLE product_category;
DROP TABLE product;


SHOW TABLES;

#again creating table
create table product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price VARCHAR(10) NOT NULL CHECK ( price > 0),
    description TEXT NOT NULL,
    status VARCHAR(8) DEFAULT "ACTIVE" CHECK (status IN ("active","inactive")),
    quantity INT(5) NOT NULL CHECK ( quantity >= 0),
    PRIMARY KEY(id)
) ;

CREATE TABLE product_category(
    product_id INT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY(product_id, category_id),
    FOREIGN KEY(product_id) REFERENCES product(id),
    FOREIGN KEY(category_id) REFERENCES category(id) 
);



create table product_image (
    id INTEGER AUTO_INCREMENT,
    product_id INT NOT NULL, 
    image_url TEXT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(product_id) REFERENCES product(id)
);

CREATE TABLE orders (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    order_time DATETIME NOT NULL,
    total FLOAT NOT NULL,
    address_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(address_id) REFERENCES address(id)
);

CREATE TABLE order_item (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    deliver_time DATETIME,
    status VARCHAR(30) NOT NULL CHECK(status IN ("shipped", "placed","delivered","returned")) ,
    PRIMARY KEY(order_id,product_id),
    FOREIGN KEY(product_id) REFERENCES product(id)
);

SHOW TABLES;

// INSERTING DATA INTO TABLES

INSERT INTO users(first_name, last_name, type,email) 
VALUES  ("first1", "last1", "admin", "xyz1@gmail.com"),
        ("first2", "last2", "shopper", "xyz2@gmail.com"),
        ("first3", "last3", "shopper", "xyz3@gmail.com"),
        ("first4", "last4", "shopper", "xyz4@gmail.com"),
        ("first5", "last5", "shopper", "xyz5@gmail.com");
 
SELECT * FROM users; 

INSERT INTO zipcode(city, state, pincode)
VALUES  ( "jaipur", "rajasthan", "302017"),
        ("udaipur", "rajasthan", "302016"),
        ("bhanpur", "up", "302022"),
        ("kanpur", "up", "302015"),
        ( "jodhpur", "rajasthan", "302021");
        
INSERT INTO address(user_id, house_no, street,  pincode)
VALUES  (1, "1", "ABC1",  "302017"),
        (2, "2", "ABC2", "302016"),
        (3, "3", "ABC3",  "302022"),
        (4, "4", "ABC4", "302015"),
        (5, "5", "ABC5", "302022"),
        (2, "6", "ABC6", "302022"),
        (3, "7", "ABC7", "302021");
        
        
INSERT INTO category(title, parent_category)
VALUES  ("Eletronics", NULL),
        ("Mobile", 1),
        ("Laptops", 1),
        ("Mobile Accessories", 2),
        ("Laptop Accessories", 3),
        ("Fashion", NULL),
        ("Men's Fashion", 6),
        ("Women's Fashion", 6),
        ("Men's Watch", 7),
        ("Women's Watch", 8),
        ("Sports", NULL),
        ("Cricket", 11),
        ("Football", 11);
        
INSERT INTO product(name, description, quantity, price)
VALUES  ("Apple iPhone X", "Latest by apple", 13, 70000.00),
        ("Samsung S9", "Latest by samsung", 121, 62000.00),
        ("HP BS-164TU", "Top selling by HP", 34, 41000.00),
        ("Dell AB-220TX", "Top selling by Dell", 23, 47500.00),
        ("Sandisk Memory card 32 gb", "Top selling memory card by Sandisk", 45, 410.00),
        ("Sandisk pen drive 32 gb", "Top selling pen drive by Sandisk", 54, 540.00),
        ("Timex Men's Watch", "Best in men class", 132, 5000.00),
        ("Timex Women's Watch", "Best in women class", 123, 7000.00),
        ("SG Full Size Bat", "Best for batting", 546, 900.00),
        ("Adidas Football", "Best for football", 234, 1000.00),
        ("Apple iPhone 8", "Latest by apple", 0, 70000.00);
        
INSERT INTO product_category(product_id, category_id)
VALUES  (1, 2),
        (2, 2),
        (2,1),
        (3, 3),
        (4, 3),
        (5, 4),
        (6, 5),
        (7, 9),
        (8, 10),
        (9, 12),
        (1,1),
        (1,3),
        (10, 13);
        
INSERT INTO product_image(product_id, image_url)
VALUES  (1,  "image.com/id101"),
        (1, "image.com/id102"),
        (1,  "image.com/id103"),
        (2, "image.com/id201"),
        (3,  "image.com/id301"),
        (4, "image.com/id401"),
        (7, "image.com/id701"),
        (8, "image.com/id801"),
        (8,  "image.com/id802");
        
        
INSERT INTO orders(user_id, address_id, total, order_time)
VALUES  (2, 1, 124000.00,'2021-01-16 14:29:36' ),
        (3, 3, 143580.00, '2021-01-04 14:29:36'),
        (5, 7, 820.00, '2021-02-07 16:29:36'),
        (5, 7, 1800.00, '2021-03-19 14:29:36'),
        (5, 7, 1800.00, '2021-03-05 14:29:36'),
        (5, 7, 1800.00, '2021-03-05 14:29:36');

INSERT INTO order_item(product_id, order_id, status, quantity,  deliver_time)
VALUES  (2, 1,  "placed", 2,  NULL),
        (4, 2,  "plcaed", 3,  NULL),
        (6, 2,  "shipped", 2,  NULL),
        (5, 3,  "delivered", 2,  '2021-03-20 17:29:36'),
        (9, 4, "shipped", 2,  '2021-03-25 17:29:36'),
        (5, 6, "placed", 6,  NULL);


INSERT INTO product(name, description, quantity, price)
VALUES  ("Apple iPhone 8", "Latest by apple", 0, 70000.00);


SELECT * FROM users;


