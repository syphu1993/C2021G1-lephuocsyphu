create database if not exists Quan_ly_ban_hang;
use Quan_ly_ban_hang;
create table Customer(
Id_customer int not null primary key auto_increment,
Name_customer varchar(30) not null,
Age_customer int
);
create table `Order`(
Id_order int not null primary key auto_increment,
Date_made_order datetime not null,
Total_price float not null,
Id_customer int not null,
foreign key(Id_customer) references Customer(Id_customer)
);
create table Product(
Id_product int not null primary key auto_increment,
Name_product varchar(30) not null,
Price_product float not null
);
create table Order_detail(
Id_order int not null,
Id_product int not null,
Qty_product int not null,
primary key(Id_order,Id_product),
foreign key(Id_order) references `Order`(Id_order),
foreign key(Id_product) references Product(Id_product)
);