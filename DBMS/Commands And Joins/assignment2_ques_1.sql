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
    type VARCHAR(7) CHECK(type IN ("admin","shopper") ), 
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
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(pincode) REFERENCES zipcode(pincode) ON DELETE CASCADE ON UPDATE CASCADE
);


#creating category table
create table category (  
    id INT NOT NULL AUTO_INCREMENT , 
    title VARCHAR(100) NOT NULL , 
    parent_category INT, 
    PRIMARY KEY(ID), 
    FOREIGN KEY(parent_category) REFERENCES category(id) ON DELETE CASCADE ON UPDATE CASCADE 
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
    FOREIGN KEY(product_id) REFERENCES product(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(category_id) REFERENCES category(id) ON DELETE CASCADE ON UPDATE CASCADE 
);


#creataing product_image table
create table product_image (
    id INTEGER AUTO_INCREMENT,
    product_id INT NOT NULL, 
    image_url TEXT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(product_id) REFERENCES product(id) ON DELETE CASCADE ON UPDATE CASCADE
);

#cretaing category table
CREATE TABLE orders (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    order_time DATETIME NOT NULL,
    total FLOAT NOT NULL,
    address_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(address_id) REFERENCES address(id) ON DELETE CASCADE ON UPDATE CASCADE
);

#creating order_item table
CREATE TABLE order_item (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    deliver_time DATETIME,
    status VARCHAR(30) CHECK(status IN ("shipped", "placed","delivered","returned")) ,
    PRIMARY KEY(order_id,product_id) ,
    FOREIGN KEY(product_id) REFERENCES product(id) ON DELETE CASCADE ON UPDATE CASCADE
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
    FOREIGN KEY(product_id) REFERENCES product(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(category_id) REFERENCES category(id) ON DELETE CASCADE ON UPDATE CASCADE  
);



create table product_image (
    id INTEGER AUTO_INCREMENT,
    product_id INT NOT NULL, 
    image_url TEXT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(product_id) REFERENCES product(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE orders (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    order_time DATETIME NOT NULL,
    total FLOAT NOT NULL,
    address_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE, 
    FOREIGN KEY(address_id) REFERENCES address(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE order_item (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    deliver_time DATETIME,
    status VARCHAR(30) NOT NULL CHECK(status IN ("shipped", "placed","delivered","returned")) ,
    PRIMARY KEY(order_id,product_id),
    FOREIGN KEY(product_id) REFERENCES product(id) ON DELETE CASCADE ON UPDATE CASCADE
);
