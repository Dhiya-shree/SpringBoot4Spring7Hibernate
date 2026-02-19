-- Drop user first if they exist 
DROP USER if exists 'springstudent'@'%';

-- Create user with Proper privileges 
CREATE USER 'springstudent'@'%' IDENTIFIED BY 'springstudent';
GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'%';
