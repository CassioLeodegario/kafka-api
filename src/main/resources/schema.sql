create table order(
    id bigserial primary key auto_increment,
    identifier varchart not null,
    status varchar not null,
    orderDate date
);

create table order_item(
    id bigserial primary key auto_increment,
    productIdentifier varchar(100) not null,
    amount int not null,
    price float not null,
    orderId bigint REFERENCES  order(id)
);