-- Drop the database if it already exists and create the database
DROP DATABASE IF EXISTS wizkidsDB;
CREATE DATABASE wizkidsDB;

-- Select the database
USE wizkidsDB;

-- Create the tables
CREATE TABLE employee
(
    employeeID        INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employeeFirstName VARCHAR(50)  NOT NULL,
    employeeLastName  VARCHAR(50)  NOT NULL,
    employeeEmail     VARCHAR(100) NOT NULL,
    employeePhone     INT

);