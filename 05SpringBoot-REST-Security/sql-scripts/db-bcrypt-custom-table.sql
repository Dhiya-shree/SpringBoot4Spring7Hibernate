 USE 'employee_directory';

 DROP TABLE IF EXISTS 'autrolesorities';
 DROP TABLE IF EXISTS 'members';


 CREATE TABLE 'members'(
    'user_id' varchar(50) NOT NULL,
    'pwd' varchar(50) NOT NULL,
    'active' tinyint NOT NULL,
    PRIMARY KEY('user_id')
 )

 ---------------------------------------------------------
 --- Password encrypted using bcrypt 
 ---- ip : user 
 ---- op : $2a$12$iOoi0rPM8yRkBbkgaF8X3e6x9tvweTq.SGn/YppNDnjkeCUxKp8Yq
 ----------------------------------------------------------

 INSERT INTO 'members'
 VALUES 
('user1','{bcrypt}$2a$12$iOoi0rPM8yRkBbkgaF8X3e6x9tvweTq.SGn/YppNDnjkeCUxKp8Yq',1),
('user2','{bcrypt}$2a$12$iOoi0rPM8yRkBbkgaF8X3e6x9tvweTq.SGn/YppNDnjkeCUxKp8Yq',1),
('user3','{bcrypt}$2a$12$iOoi0rPM8yRkBbkgaF8X3e6x9tvweTq.SGn/YppNDnjkeCUxKp8Yq',1);

CREATE TABLE 'roles'(
    'user_id' varchar(50) NOT NULL,
    'role' varchar(50) NOT NULL,
    UNIQUE KEY 'roles_idx_1'('user_id','role'),
    CONSTRAINT 'roles_idx_fk' FOREIGN KEY('user_id') 
    REFERENCES 'members'('user_id')
);

INSERT INTO 'roles' VALUES 
('user1','ROLE_EMPLOYEE'),
('user1','ROLE_MANAGER'),
('user2','ROLE_EMPLOYEE'),
('user3','ROLE_ADMIN');