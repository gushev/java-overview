DROP table if exists company;

CREATE TABLE company
(
    id   int PRIMARY KEY AUTO_INCREMENT,
    name varchar(45) NOT NULL
);

DROP table if exists company_address;

CREATE TABLE company_address
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    street varchar(45),
    number varchar(45),
    company int
);