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
insert into attach_service(attach_service_name,attach_service_cost,attach_service_unit,attach_service_status)
value('Massage',500000,1,'on'),('Karaoke',500000,1,'on'),('Swim',500000,1,'on');
create table contract_detail(
contract_detail_id int not null primary key auto_increment,
contract_id int,
attach_service_id int,
quantity int,
foreign key(contract_id) references contract(contract_id),
foreign key(attach_service_id) references attach_service(attach_service_id)
);
insert into contract_detail(contract_id,attach_service_id,quantity)
value(1,1,2);

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

-- insert data table rent type
insert into rent_type (rent_type_name,rent_type_cost)
value('Hour',50000),('Day',200000),('Month',3000000);

-- insert data table service type
insert into service_type(service_type_name)
value('VIP'),('Normal');

-- insert data table service
insert into service
value(1,'villa',100,5000000,6,3,1,'high','pool',20,4),
	(2,'house',75,3000000,4,2,1,'high',null,null,3),
	(3,'room',20,2000000,2,1,2,'high',null,null,1);
 
 -- insert data table possition
insert into `Position`
value(1,'Manager'),(2,'Staff');

 -- insert data table possition
insert into Education_degree
value(1,'Vocational'),(2,'College');

 -- insert data table Division
insert into Division
value(1,'Receptionist'),(2,'Housekeeping'),(3,'Office');

 -- insert data table role
insert into `Role`
value(1,'Serve'),(2,'Marketing'),(3,'Manage');

 -- insert data table user
insert into `User`
value('NamFurama','123'),('QuocFurama','123'),('SonFurama','123'),('HaFurama','123'),
('DaiFurama','123'),('ThienFurama','123'),('ThuFurama','123');

 -- insert data table employee
 insert into employee(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,
 employee_email,employee_address,Position_id,Education_degree_id,Division_id,username)
 value('Le Nam','1992-12-12','123222111',5000000,'0999222111','nam1@gmail.com','Quang Tri',2,1,1,'NamFurama'),
 ('Le Quoc','1992-02-05','123222112',6000000,'0999222112','quoc1@gmail.com','Quang Nam',1,1,2,'QuocFurama'),
 ('Le Son','1992-03-11','123222113',7000000,'0999222113','son1@gmail.com','Quang Tri',2,1,3,'SonFurama'),
 ('Le Ha','1992-04-12','123222114',8000000,'0999222114','ha1@gmail.com','Quang Ngai',2,1,1,'HaFurama'),
 ('Le Dai','1992-05-02','123222115',9000000,'0999222115','dai1@gmail.com','Quang Binh',1,1,1,'DaiFurama'),
 ('Le Thien','1992-06-02','123222116',5000000,'0999222116','thien1@gmail.com','Da Nang',2,1,2,'ThienFurama'),
 ('Le Thu','1992-07-01','123222117',8000000,'0999222117','thu1@gmail.com','Nghe An',2,1,1,'ThuFurama');
 
  -- insert data table cantract
  insert into contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,
  customer_id,service_id)
  value('2019-05-07','2020-05-08',5000000,8000000,2,2,3);




