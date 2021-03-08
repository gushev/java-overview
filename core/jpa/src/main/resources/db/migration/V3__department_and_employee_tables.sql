DROP table if exists department;

CREATE TABLE department
(
    code varchar(45) NOT NULL ,
    number int NOT NULL ,
    name varchar(45),
    PRIMARY KEY (`code`, `number`)
);

DROP table if exists employee;

CREATE TABLE employee
(
    id   int PRIMARY KEY AUTO_INCREMENT,
    name varchar(45),
    company_id int
);