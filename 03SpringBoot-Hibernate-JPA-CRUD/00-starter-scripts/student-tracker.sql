CREATE DATABASE IF NOT EXISTS 'student_tracker';
USE `student_tracker`;

---
--- TABLE sructure for table student 
---

--DROP TABLE IF EXISTS `student`;

CREATE TABLE IF NOT EXISTS `student` (
    'id' int NOT NULL AUTO_INCREMENT,
    'first_name' varchar(50) DEFAULT NULL,
    'last_name' varchar(50) DEFAULT NULL,
    'email' varchar(50) DEFAULT NULL,
    PRIMARY KEY('id')
) ENGINE=Inno AUTO_INCREMENT=156757;