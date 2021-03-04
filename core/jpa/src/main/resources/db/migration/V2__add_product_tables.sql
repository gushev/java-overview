DROP table if exists product;

CREATE TABLE product
(
    id   int PRIMARY KEY AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    price double,
    expiration_date date
);

DROP table if exists product_details;

CREATE TABLE product_details
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    kcal varchar(45),
    product_id int
);