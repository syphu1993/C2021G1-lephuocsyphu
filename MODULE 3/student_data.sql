create database if not exists student_data;
use student_data;
create table student(
id int primary key not null auto_increment,
`name` varchar(45),
birthday date
);

insert into student(`name`,birthday)
value('Nam','1993-12-12'),('Quoc','1993-12-11'),('Son','1993-12-10'),('Ha','1993-12-09');

select *
from student;

select *
from student
where id = 1;

update student
set `name` = 'hung', birthday = '2000-12-12'
where id = 1;

delete from student
where id = 6;