create database if not exists Quan_ly_ban_hang_bai_tap;
use Quan_ly_ban_hang_bai_tap;
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
-- --insert infor  table customer;
insert into Customer(Name_customer,Age_customer)
value('Minh Quan',10),('Ngoc Oanh',20),('Hong Ha',50);
-- --Drop column total price in Order table;
alter table `Order`
drop column Total_price;
-- --insert infor  'Order'table;
insert into `Order`(Date_made_order,Id_customer)
value('2006-3-21',1),('2006-3-23',2),('2006-3-16',1);
-- --insert infor table product;
insert into Product(Name_product,Price_product)
value('May Giat',3),('Tu Lanh',5),('Dieu Hoa',7),('Quat',1),('Bep Dien',2);
-- --insert infor table Order_detail;
insert into Order_detail(Id_order,Id_product,Qty_product)
value(1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);
-- --Hiển thị các thông tin  gồm oID, oDate của tất cả các hóa đơn trong bảng Order;
select Id_order,Date_made_order
from `Order`;
-- --Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách;
select C.Name_customer,P.Name_product, count(P.Name_product) as 'Count_product'
from Customer C inner join `Order` O on C.Id_customer = O.Id_customer
inner join Order_detail D on D.Id_order = O.Id_order
inner join Product P on P.Id_product = D.Id_product
group by C.Name_customer,P.Name_product;
-- --Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào;
select C.Name_customer
from Customer C left join `Order` O on C.Id_customer = O.Id_customer
where O.Id_customer is null;
-- --Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
--  Giá bán của từng loại được tính = odQTY*pPrice)
select O.Id_order,O.Date_made_order, sum(P.Price_product*D.Qty_product) as 'Total_price'
from `Order` O inner join Order_detail D on D.Id_order = O.Id_order
inner join Product P on P.Id_product = D.Id_product
group by O.Id_order;
