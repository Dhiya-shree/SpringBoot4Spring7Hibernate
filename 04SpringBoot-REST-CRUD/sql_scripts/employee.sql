CREATE DATABASE IF NOT EXISTS 'employee_directory';
USE 'employee_directory';

DROP TABLE IF EXISTS 'employee';

CREATE TABLE 'employee'(
    'id' int NOT NULL AUTO_INCREMENT,
    'firstName' varchar(50) DEFAULT NULL,
    'lastName' varchar(50) DEFAULT NULL,
    'mail' varchar(110) DEFAULT NULL,
    'dept' varchar(10) DEFAULT "GENERAL",
    PRIMARY KEY('id') 
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO 'employee' VALUES 
(1,"A1","B1","emailId@gmail.com"),
(2,"A2","B2","emailId1@gmail.com"),
(3,"A3","B3","emailI3@gmail.com"),
(4,"A4","B4","emailId4@gmail.com"),
(4,"A5","B5","emailId5@gmail.com");