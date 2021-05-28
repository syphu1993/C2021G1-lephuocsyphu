create database if not exists quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table Class(
ClassID int not null auto_increment primary key,
ClassName varchar(60) not null,
StartDate datetime not null,
`status` bit
);
create table Student(
StudentID int not null auto_increment primary key,
StudentName varchar(30) not null,
Adress varchar(30),
NumberPhone varchar(30),
`Status` bit,
ClassID int not null,
foreign key(ClassID)  references Class(ClassID)
);
create table `Subject`(
SubID int primary key not null auto_increment,
SubName varchar(30) not null,
Credit tinyint not null default 1 check(Credit>=1),
`Status`bit default 1
);
create  table Mark(
MarkID int not null primary key auto_increment,
SubID int not null,
StudentID int not null,
Mark float default 0 check(Mark between 0 and 100),
ExamTimes tinyint default 1,
unique(SubID,StudentID),
foreign key(SubID) references `Subject`(SubID),
foreign key(StudentID) references Student(StudentID)
);
