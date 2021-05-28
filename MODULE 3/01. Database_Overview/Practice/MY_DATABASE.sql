create database MY_DATABASE;
create table MY_DATABASE.STUDENT(
`id` int not null auto_increment,
`NAME` varchar(25) null,
`AGE` int null,
`COUNTRY` varchar(25) null,
primary key(id)
); 