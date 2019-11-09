CREATE TABLE UserLogin (
    id serial primary key,
    username varchar(255),
    password varchar(255)
);

CREATE TABLE Customer (
    id serial primary key,
    fullName varchar(255),
    documentId varchar(255),
    phone varchar(255),
    email varchar(255),
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

CREATE TABLE PaymentOrder (
    id serial primary key,
    paymentMethod varchar(40),
    instalments int,
    amount int
);

CREATE TABLE OrderSell (
    id serial primary key,
    customer_id int,
    payment_id int,
    address_id int,
    status varchar(40),
    CONSTRAINT FK_CustomerOrder FOREIGN KEY (customer_id)
    REFERENCES Customer(id),
    CONSTRAINT FK_PaymentOrderId FOREIGN KEY (payment_id)
    REFERENCES paymentOrder(id),
    CONSTRAINT FK_AddressOrder FOREIGN KEY (address_id)
    REFERENCES Address(id)
);

CREATE TABLE ProductOrder (
    id serial primary key,
    product_id int,
    ordersell_id int,
    quantity int,
    price int,
    CONSTRAINT FK_ProductOrder FOREIGN KEY (product_id)
    REFERENCES Product(id),
    CONSTRAINT FK_ProductOrderID FOREIGN KEY (ordersell_id)
    REFERENCES OrderSell(id)
);
