DROP table if exists students;

CREATE TABLE students
(
    id   int PRIMARY KEY AUTO_INCREMENT,
    name varchar(45)
);

DROP table if exists professors;

CREATE TABLE professors
(
    id   int PRIMARY KEY AUTO_INCREMENT,
    name varchar(45)
);

DROP table if exists professor_student;

CREATE TABLE professor_student
(
    professor_id int,
    student_id  int,
    PRIMARY KEY (professor_id, student_id)
);