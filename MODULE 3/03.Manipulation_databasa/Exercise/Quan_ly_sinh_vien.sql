create database if not exists quan_ly_sinh_vien_bai_tap;
use quan_ly_sinh_vien_bai_tap;
create table Class(
Id_class int not null auto_increment primary key,
name_class varchar(60) not null,
Start_date datetime not null,
`status` bit
);
create table Student(
Id_student int not null auto_increment primary key,
Name_student varchar(30) not null,
Adress varchar(30),
Number_phone varchar(30),
`Status` bit,
Id_class int not null,
foreign key(Id_class)  references Class(Id_class)
);
create table `Subject`(
Id_subject int primary key not null auto_increment,
Name_subject varchar(30) not null,
Credit tinyint not null default 1 check(Credit>=1),
`Status`bit default 1
);
create  table Mark(
Id_mark int not null primary key auto_increment,
Id_subject int not null,
Id_student int not null,
Mark float default 0 check(Mark between 0 and 100),
Exam_times tinyint default 1,
unique(Id_subject,Id_student),
foreign key(Id_subject) references `Subject`(Id_subject),
foreign key(Id_student) references Student(Id_student)
);
insert into Class(name_class,Start_date,`status`)
value('A1','2008-12-20',1),('A2','2008-12-22',1),('B3',current_date,0);
insert into Student(Name_student,Adress,Number_phone,`Status`,Id_class)
value('Hung','Ha Noi','0912113113',1,1);
insert into Student(Name_student,Adress,`Status`,Id_class)
value ('Hoa','Hai phong',1,1);
insert into Student(Name_student,Adress,Number_phone,`Status`,Id_class)
value ('Manh','TP HCM','0912113000',0,2);
insert into `Subject`(Name_subject,Credit,`Status`)
value('CF',5,1),('C',6,1),('HDJ',5,1),('RDBMS',10,1);
insert into Mark(Id_subject,Id_student,Mark,Exam_times)
value(1,1,8,1),(1,2,10,2),(2,1,12,1);
-- --Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select *
from student
where  Name_student like 'H%';
-- --Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select *
from Class
where month(Start_date)=12;
-- --Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select *
from `Subject`
where Credit between 3 and  5;
SET SQL_SAFE_UPDATES = 0;
-- --Thay đổi mã lớp(Id_class) của sinh viên có tên ‘Hung’ là 2.
update student
set Id_class =2
where Name_student = 'Hung';
-- --Hiển thị các thông tin: Name_student, Name_subject, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. 
-- nếu trùng sắp theo tên tăng dần.
select Student.Name_student,`Subject`.Name_subject,Mark.Mark
from Student join Mark on Student.Id_student = Mark.Id_student
join `Subject` on Mark.Id_subject = `Subject`.Id_subject
order by Mark.Mark desc,Student.Name_student asc;
