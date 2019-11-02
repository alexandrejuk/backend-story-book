CREATE TABLE Book (
    id serial primary key,
    name varchar(255)
)

CREATE TABLE Customer (
    id serial primary key,
    fullName varchar(255),
    documentId varchar(255)
)

CREATE TABLE Product (
    id serial primary key,
    description varchar(255),
    weight int,
    price int,
    quantity int
)

CREATE TABLE UserLogin (
    id serial primary key,
    username varchar(255),
    password varchar(255)
)

CREATE TABLE OrderSell (
    id serial primary key
)

INSERT INTO Customer (fullName, documentID)
VALUES ('Alexandre S Soares', '987654321');

INSERT INTO Customer (fullName, documentID)
VALUES ('Thiago Ramalho', '123456789');

INSERT INTO Product (description, weight, price, quantity)
VALUES ('Alices Adventures', 500, 12000, 10);

INSERT INTO Product (description, weight, price, quantity)
VALUES ('Wonderland Glass', 1000, 12000, 10);

INSERT INTO UserLogin (username, password)
VALUES ('alexandre', '123456');

INSERT INTO UserLogin (username, password)
VALUES ('thiago', '123456');