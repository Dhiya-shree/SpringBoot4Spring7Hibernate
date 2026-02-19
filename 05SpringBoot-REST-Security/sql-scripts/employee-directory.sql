CREATE SATABASE IF NOT EXISTS 'employee_directory';
USE 'employee_directory';

DROP TABLE IF EXISTS 'employee';

CREATETABLE 'employee'(
    'id' int NOT NULL AUTO_INCREMENT,
    'first_name' varchar(45) DEFAULT 'name',
    'last_name' varchar(45) DEFAULT 'lname',
    'mail' varchar(100) DEFAULT 'mail',
    PRIMARY KEY ('id')
)ENGINE=InnoDB AUTO_INCREMENT=100 ;

