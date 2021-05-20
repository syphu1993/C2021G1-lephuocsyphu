create database if not exists Data_intership;
use Data_intership;
create table Faculty(
Faculty_id int not null primary key auto_increment,
Faculty_name varchar(55) not null,
Phone varchar(55)
);
create table Project(
Project_id int not null primary key auto_increment,
Project_name varchar(55),
Expense int,
Place_of_intern varchar(55)
);
create table Instructor(
Instructor_id int  not null primary key auto_increment,
Instructor_name varchar(55),
Salary int,
Faculty_id int,
foreign key(Faculty_id) references Faculty(Faculty_id)
);
create table Student(
Student_id int not null primary key auto_increment,
Student_name varchar(55),
Faculty_id int,
Date_of_birth date,
Place_of_birth varchar(55),
foreign key(Faculty_id)  references Faculty(Faculty_id)
);
create table Instructor_student(
Student_id int,
Project_id int,
Instructor_id int,
primary key(Student_id,Project_id,Instructor_id),
foreign key(Student_id) references Student(Student_id),
foreign key(Project_id) references Project(Project_id),
foreign key(Instructor_id) references Instructor(Instructor_id),
Grade int
);
-- Insert dữ liệu cho bảng Faculty
insert into Faculty(Faculty_name,Phone)
value('Cong Nghe Sinh Hoc','0911123000'),('Toan','0911123123'),('Dia Ly','0911123111'),
('QLTN','0911123222');
delete from Faculty;
-- Insert dữ liệu cho bảng Project
insert into Project(Project_name,Expense,Place_of_intern)
value('ABC',2000000,'TP HCM'),('CDE',3000000,'Ha Noi'),('XYZ',4000000,'Da Nang');
-- Insert dữ liệu cho bảng Instructor
insert into Instructor(Instructor_name,Salary,Faculty_id)
value('Truong Tam Phong',5000000,5),('Ta Ton',6000000,6),('Tran Son',8000000,7),('Le Quang Nam',6000000,8);
insert into Instructor(Instructor_name,Salary,Faculty_id)
value('Vi Nhat Tieu',8000000,5),('Duong Bat Hoi',9000000,6),('Truong Vo Ky',8000000,5),('Dien Ba Quan',6000000,7);
-- Insert dữ liệu cho bảng Student
insert into Student(Student_name,Faculty_id,Date_of_birth,Place_of_birth)
value('Do Minh Nhat',5,'1993-12-26','Da Nang'),('Le Sy Phu',6,'1993-09-25','Quang Tri'),
('Nguyen Manh Cuong',7,'1993-01-01','Hue'),('Ho Ngoc Ha',8,'1993-02-15','Ha Noi'),
('Phan Tan Trung',5,'1993-11-11','Da Nang'),('Pham Hong Phuc',6,'1993-12-26','Quang Nam'),
('Nguyen kim Oanh',5,'1993-01-14','Da Nang'),('Le Phong',8,'1993-05-26','Quang Nam');
-- Insert dữ liệu cho bảng Instructor_student
insert into Instructor_student
value(1,1,7,9),(5,2,5,7),(8,3,8,8);