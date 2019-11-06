drop table Customer;
drop table UserLogin;
drop table Product;
drop table PaymentOrder;
drop table Book;
drop table OrderSell;
drop table ProductOder;
drop table Contact;
drop table Address;
drop table ProductOder;

CREATE TABLE UserLogin (
    id serial primary key,
    username varchar(255),
    password varchar(255)
);

CREATE TABLE Customer (
    id serial primary key,
    fullName varchar(255),
    documentId varchar(255),
    loginId int,
    CONSTRAINT FK_CustomerLogin FOREIGN KEY (loginId)
    REFERENCES UserLogin(id)
);

CREATE TABLE Product (
    id serial primary key,
    description varchar(255),
    weight int,
    price int,
    quantity int
);

CREATE TABLE Address (
    id serial primary key,
    customerId int,
    street varchar(255),
    street_number varchar(255),
    city varchar(255),
    state varchar(255),
    neighborhood varchar(255),
    zipcode varchar(255),
    CONSTRAINT FK_CustomerAddress FOREIGN KEY (customerId)
    REFERENCES Customer(id)
);

CREATE TABLE Contact (
    id serial primary key,
    customerId int,
    phone varchar(255),
    email varchar(255),
    CONSTRAINT FK_CustomerContact FOREIGN KEY (customerId)
    REFERENCES Customer(id)
);


CREATE TABLE PaymentOrder (
    id serial primary key,
    paymentMethod varchar(40),
    instalments int,
    amount int
);

CREATE TABLE OrderSell (
    id serial primary key,
    customerId int,
    paymentId int,
    contactId int,
    addressId int,
    status varchar(40),
    CONSTRAINT FK_CustomerOrder FOREIGN KEY (customerId)
    REFERENCES Customer(id),
    CONSTRAINT FK_PaymentOrderId FOREIGN KEY (paymentId)
    REFERENCES PaymentOrder(id),
    CONSTRAINT FK_CustomerContactOrder FOREIGN KEY (contactId)
    REFERENCES Contact(id),
    CONSTRAINT FK_PaymentOrder FOREIGN KEY (addressId)
    REFERENCES Address(id)
);

CREATE TABLE ProductOder (
    id serial primary key,
    productId int,
    orderId int,
    quantity int,
    price int,
    CONSTRAINT FK_ProductOrder FOREIGN KEY (productId)
    REFERENCES Product(id),
    CONSTRAINT FK_ProductOrderID FOREIGN KEY (orderId)
    REFERENCES OrderSell(id)
);


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