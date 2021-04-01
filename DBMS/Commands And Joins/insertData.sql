
INSERT INTO users(first_name, last_name, type) 
VALUES  ("first1", "last1", "admin"),
        ("first2", "last2", "shopper"),
        ("first3", "last3", "shopper"),
        ("first4", "last4", "shopper"),
        ("first5", "last5", "shopper");
        
        

INSERT INTO address(user_id, house_no, street, city, state, pincode)
VALUES  (1, "1", "ABC1", "jaipur", "rajasthan", "302017"),
        (2, "2", "ABC2", "jaipur", "rajasthan", "302016"),
        (3, "3", "ABC3", "jaipur", "rajasthan", "302022"),
        (4, "4", "ABC4", "jaipur", "rajasthan", "302015"),
        (5, "5", "ABC5", "jaipur", "rajasthan", "302022"),
        (2, "6", "ABC6", "jaipur", "rajasthan", "302022"),
        (3, "7", "ABC7", "jaipur", "rajasthan", "302021");
        
        

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
        (3, 3),
        (4, 3),
        (5, 4),
        (6, 5),
        (7, 9),
        (8, 10),
        (9, 12),
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
VALUES  (2, 1, 124000.00,'2018-07-12 14:29:36' ),
        (3, 3, 143580.00, '2018-07-04 14:29:36'),
        (5, 7, 820.00, '2018-07-07 14:29:36'),
        (5, 7, 1800.00, '2018-07-19 14:29:36'),
        (5, 7, 1800.00, '2021-03-05 14:29:36');



INSERT INTO order_item(product_id, order_id, status, quantity,  deliver_time)
VALUES  (2, 1,  NULL, 2,  NULL),
        (4, 2,  "placed", 3,  NULL),
        (6, 2,  "shipped", 2,  NULL),
        (5, 3,  "delivered", 2,  '2018-07-20 17:29:36'),
        (9, 4, "returned", 2,  '2018-07-25 17:29:36'),
        (9, 5, "placed", 2,  NULL);



INSERT INTO product(name, description, quantity, price)
VALUES  ("Apple iPhone 8", "Latest by apple", 0, 70000.00);




