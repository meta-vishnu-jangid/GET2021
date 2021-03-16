show databases;

drop database storeFront;

create database storeFront;

use storeFront;

create table users (  
    id INT NOT NULL AUTO_INCREMENT, 
    first_name VARCHAR(50) NOT NULL, 
    last_name VARCHAR(50) NOT NULL,
    type VARCHAR(7) CHECK(type IN ("admin", "shopper")), 
    PRIMARY KEY(id)
) ;

CREATE TABLE address
(
    id INTEGER AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    house_no VARCHAR(7) NOT NULL,
    street VARCHAR(30) NOT NULL,
    city VARCHAR(30) NOT NULL,
    state VARCHAR(30) NOT NULL,
    country VARCHAR(30) DEFAULT "India",
    pincode VARCHAR(6) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES users(id)
);


create table category (  
    id INT NOT NULL AUTO_INCREMENT , 
    title VARCHAR(100) NOT NULL , 
    parent_category INT, PRIMARY KEY(ID), 
    FOREIGN KEY(parent_category) REFERENCES category(id) 
);

create table product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price VARCHAR(10) NOT NULL,
    description TEXT NOT NULL,
    quantity INT(5) NOT NULL,
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

create table product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price VARCHAR(10) NOT NULL,
    description TEXT NOT NULL,
    quantity INT(5) NOT NULL,
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
    status VARCHAR(30) CHECK(status IN ("shipped", "placed","delivered","returned")) ,
    PRIMARY KEY(order_id,product_id),
    FOREIGN KEY(product_id) REFERENCES product(id)
);

SHOW TABLES;
