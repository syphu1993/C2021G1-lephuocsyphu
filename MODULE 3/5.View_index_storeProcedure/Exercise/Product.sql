-- Bước 1: Tạo cơ sở dữ liệu demo

create database if not exists Product;
use Product;

-- Bước 2: Tạo bảng Products và insert dữ liệu:

create table Product(
Id int primary key not null auto_increment,
Product_code varchar(55),
Product_name varchar(55),
Product_price int,
Product_amount int,
Product_description varchar(55),
Product_status int
);
insert into Product(Product_code,Product_name,Product_price,Product_amount,Product_description,Product_status)
value('dt','Dien_thoai',2000000,10,'samsung',1),
('mg','may_giat',300000,1,'GL',1),
('ot','xe_o_to',20000000,1,'kia',1),
('dh','Dieu_hoa',500000000,2,'Invector',1),
('cd','noi_com_dien',100000,1,'Sharp',1),
('qm','Quat_may',50000000,4,'Senco',1);

-- Bước 3: Thao tác Index

-- a. Truy vấn explain để so sách tốc độ truy xuất
explain select * from product 
where Product_code = 'ot';
explain select * from product 
where Product_name = 'may_giat';
explain select * from product 
where Product_price = 500000000;
-- b. Tạo unique index
create unique index idx_code on product(Product_code);
-- c.Tạo Composite index
alter table product 
add index idx_product_name (Product_name);
alter table product
add index idx_products_price (Product_price);

-- Bước 4: Thao tác với View

-- a. Tạo view
create view product_views as 
select Product_name,Product_price,Product_status
from product;
select * from product_views;
-- b. Update view
create or replace view product_views as
select Product_name,Product_price
from product
where Id=3 or Id = 5;
select * from product_views;
-- c. Xóa view
drop view product_views; 

-- Bước 5: Thao tác với Procedure
-- a. Lấy tất cả thông tin của tất cả các sản phẩm trong bảng product

DELIMITER //
create procedure Infor_all_product()
begin
select *
from product;
end //
DELIMITER ;
call Infor_all_product();
-- b. Thêm một sản phẩm mới

DELIMITER //
create procedure Add_new_product(p_id int,p_code varchar(55), p_name varchar(55),
p_price int, p_amount int, p_decription varchar(55), p_status int)
begin
insert into product(Id, Product_code,Product_name,Product_price,Product_amount,Product_description,Product_status)
value(p_id, p_code, p_name, p_price, p_amount, p_decription, p_status);
end  //
DELIMITER ;
call Add_new_product(11,'rc','May_rua_chen',1000000,1,'Abc',1);
-- c.Sửa thông tin sản phẩm theo id

DELIMITER //
create procedure Edit_new_product(p_id int,p_code varchar(55), p_name varchar(55),
p_price int, p_amount int, p_decription varchar(55), p_status int)
begin
update product
set Product_code = p_code, Product_name = p_name,Product_price =p_price,Product_amount=p_amount,
Product_description=p_decription,Product_status=p_status
where Id = p_id;
end  //
DELIMITER ;
call Edit_new_product(11,'mrc','May_rua_chen',5000000,2,'Abc',1);

-- d. Xoá sản phẩm theo id

DELIMITER //
create procedure Remove_new_product(p_id int)
begin
delete from product
where Id = p_id;
end  //
DELIMITER ;
call Remove_new_product(10);
