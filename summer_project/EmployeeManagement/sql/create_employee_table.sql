CREATE TABLE employee(
employeeid int PRIMARY KEY,
name VARCHAR(255) NOT NULL,
hoursworked int NOT NULL,
salary int NOT NULL,
projectedpay int
);

CREATE TABLE manager(
employeeid int NOT NULL,
manages VARCHAR(255) NOT NULL,
department int NOT NULL
);

CREATE TABLE department(
departmentid int PRIMARY KEY,
departmentname varchar(255) NOT NULL
);

CREATE TABLE item(
productid int PRIMARY KEY,
name VARCHAR(255) NOT NULL,
category VARCHAR(255) NOT NULL,
price int NOT NULL,
rating int NOT NULL
);

CREATE TABLE manufacturer(
manufactureid int PRIMARY KEY,
name VARCHAR(255) NOT NULL,
products VARCHAR(255)
);

CREATE TABLE customer(
customerid int PRIMARY KEY,
name VARCHAR(255),
orders VARCHAR(255),
email VARCHAR(255)
);

commit;