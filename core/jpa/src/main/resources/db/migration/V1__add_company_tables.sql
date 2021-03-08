DROP table if exists company;

CREATE TABLE company
(
    id   int PRIMARY KEY AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    address_number varchar(45),
    street varchar(45),
    city varchar(45)
);

DROP table if exists company_address;

CREATE TABLE company_address
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    street varchar(45),
    number varchar(45),
    company int
);