create database if not exists furama_data;
use furama_data;
create table `Position`(
Position_id int not null  primary key auto_increment,
Position_name varchar(45)
);
create table Education_degree(
Education_degree_id int not null  primary key auto_increment,
Education_degree_name varchar(45)
);
create table Division(
Division_id int not null  primary key auto_increment,
Division_name varchar(45)
);
create table `Role`(
role_id int not null  primary key auto_increment,
role_name varchar(45)
);
create table `user`(
username varchar(45) not null primary key,
`password` varchar(45)
);
create table user_role(
role_id int,
username varchar(45),
primary key(role_id,username),
foreign key(role_id) references `Role`(role_id),
foreign key(username) references `user`(username)
);
create table Customer_type(
Customer_type_id int not null primary key auto_increment,
Customer_type_name  varchar(45)
);
create  table rent_type(
rent_type_id int not null primary key auto_increment,
rent_type_name varchar(45) not null,
rent_type_cost int not null
);
create table service_type(
service_type_id int not null primary key auto_increment,
service_type_name varchar(45)
);
create table customer(
customer_id int not null primary key auto_increment,
Customer_type_id int not null,
Customer_name varchar(45),
Customer_birthday date,
Customer_gender  varchar(45),
Customer_id_card  varchar(45),
Customer_phone  varchar(45),
Customer_email  varchar(45),
Customer_address  varchar(45),
foreign key(Customer_type_id) references Customer_type(Customer_type_id)
);
create table employee(
employee_id int not null primary key auto_increment,
employee_name varchar(45),
employee_birthday date,
employee_id_card varchar(45),
employee_salary double,
employee_phone varchar(45),
employee_email  varchar(45),
employee_address  varchar(45),
Position_id  int,
Education_degree_id  int,
Division_id  int,
username varchar(225),
foreign key(Position_id) references `Position`(Position_id),
foreign key(Education_degree_id) references Education_degree(Education_degree_id),
foreign key(Division_id) references Division(Division_id),
foreign key(username) references `user`(username)
);
create table service(
service_id int not null primary key auto_increment,
service_name varchar(45),
service_area int,
service_cost double,
service_max_peple int,
rent_type_id int,
service_type_id int,
standard_rome varchar(45),
decription_other_convenient varchar(45),
poor_area double,
number_of_floor int,
foreign key(rent_type_id) references rent_type(rent_type_id),
foreign key(service_type_id) references service_type(service_type_id)
);
create table contract(
contract_id int not null primary key auto_increment,
contract_start_date date,
contract_end_date date,
contract_deposit double,
contract_total_money double,
employee_id int,
customer_id int,
service_id int,
foreign key(employee_id) references employee(employee_id),
foreign key(customer_id) references customer(customer_id),
foreign key(service_id) references service(service_id)
);
create table attach_service(
attach_service_id int primary key not null auto_increment,
attach_service_name varchar(45),
attach_service_cost int,
attach_service_unit int,
attach_service_status varchar(45)
);
create table contract_detail(
contract_detail_id int not null primary key auto_increment,
contract_id int,
attach_service_id int,
quantity int,
foreign key(contract_id) references contract(contract_id),
foreign key(attach_service_id) references attach_service(attach_service_id)
);

-- insert data table type customer

insert into Customer_type (Customer_type_name)
value('Diamond'),('Platinium');

-- insert data table  customer
insert into Customer (Customer_type_id,Customer_name,Customer_birthday,Customer_gender,Customer_id_card,
Customer_phone,Customer_email,Customer_address)
value(2,'Nguyen van Hoa','1993-12-25','male','123456789','0373306101','hoa@gmail.com','Da Nang'),
(1,'Nguyen van Khoa','1960-05-26','male','123456781','0373306102','khoa@gmail.com','Quang Tri'),
(2,'Nguyen Quoc Thinh','1997-10-28','male','123456782','0373306103','thinh@gmail.com','Quang Tri'),
(1,'Nguyen Thi Hien','2009-01-27','female','123456783','0373306104','hien@gmail.com','Quang Binh'),
(2,'Nguyen quoc Hoa','1995-10-09','male','000456789','0373306000','hoanguyen@gmail.com','Quang Ngai'),
(1,'Nguyen Quoc Son','1995-07-09','male','111456789','0373306111','son@gmail.com','Quang Ngai');
