 USE 'employee_directory';

 DROP TABLE IF EXISTS 'authorities';
 DROP TABLE IF EXISTS 'users';


 CREATE TABLE 'users'(
    'username' varchar(50) NOT NULL,
    'password' varchar(50) NOT NULL,
    'enabled' tinyint NOT NULL,
    PRIMARY KEY('username')
 )

 INSERT INTO 'users'
 VALUES 
('user1','{noop}test123',1),
('user2','{noop}test123',1),
('user3','{noop}test123',1);

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