CREATE DATABASE `student_management`;
create table `student_management`.`class`(
`id` int not null auto_increment primary key,
`name` varchar(25) null
);
create  table `student_management`.`teacher`(
`id` int not null auto_increment primary key,
`name` varchar(25) null,
`age` int null,
`country` varchar(25) null
);
insert into `student_management`.`class`(`name`)
value("phu1"),("phu2"),("phu3"),("phu4");
select * from `student_management`.`class`;
select * from `student_management`.`teacher`;
insert into `student_management`.`teacher`(`name`,`age`,`country`)
value("chanh",33,"Thanh Hoa"),("tien",31,"Thanh Hoa"),("chien",32,"Thanh Hoa");
update `student_management`.`teacher`
set `country` = "Quang Nam"
where `id` = 2;
update `student_management`.`teacher`
set `country` = "Quang Nam",`age` = 28
where `id` = 1;
delete from `class`
where id = 1;
