create table tb_order (
                         id integer primary key auto_increment,
                         identifier varchar not null,
                         status varchar not null,
                         orderDate date
);

create table tb_order_item (
    id integer primary key auto_increment,
    productIdentifier varchar(100) not null,
    amount int not null,
    price float not null,
    orderId bigint REFERENCES  tb_order(id)
);