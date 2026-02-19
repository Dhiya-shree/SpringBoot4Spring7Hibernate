 USE 'employee_directory';

 DROP TABLE IF EXISTS 'authorities';
 DROP TABLE IF EXISTS 'users';


 CREATE TABLE 'users'(
    'username' varchar(50) NOT NULL,
    'password' varchar(50) NOT NULL,
    'enabled' tinyint NOT NULL,
    PRIMARY KEY('username')
 )

 ---------------------------------------------------------
 --- Password encrypted using bcrypt 
 ---- ip : user 
 ---- op : $2a$12$iOoi0rPM8yRkBbkgaF8X3e6x9tvweTq.SGn/YppNDnjkeCUxKp8Yq
 ----------------------------------------------------------

 INSERT INTO 'users'
 VALUES 
('user1','{bcrypt}$2a$12$iOoi0rPM8yRkBbkgaF8X3e6x9tvweTq.SGn/YppNDnjkeCUxKp8Yq',1),
('user2','{bcrypt}$2a$12$iOoi0rPM8yRkBbkgaF8X3e6x9tvweTq.SGn/YppNDnjkeCUxKp8Yq',1),
('user3','{bcrypt}$2a$12$iOoi0rPM8yRkBbkgaF8X3e6x9tvweTq.SGn/YppNDnjkeCUxKp8Yq',1);

CREATE TABLE 'authorities'(
    'username' varchar(50) NOT NULL,
    'authority' varchar(50) NOT NULL,
    UNIQUE KEY 'authorities_idx_1'('username','authority'),
    CONSTRAINT 'authorities_idx_fk' FOREIGN KEY('username') 
    REFERENCES 'users'('username')
);

INSERT INTO 'authorities' VALUES 
('user1','ROLE_EMPLOYEE'),
('user1','ROLE_MANAGER'),
('user2','ROLE_EMPLOYEE'),
('user3','ROLE_ADMIN');