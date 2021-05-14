create database if not exists quan_ly_sinh_vien_bai_tap;
use quan_ly_sinh_vien_bai_tap;
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
insert into Class(ClassName,StartDate,`status`)
value('A1','2008-12-20',1),('A2','2008-12-22',1),('B3',current_date,0);
insert into Student(StudentName,Adress,NumberPhone,`Status`,ClassID)
value('Hung','Ha Noi','0912113113',1,1);
insert into Student(StudentName,Adress,`Status`,ClassID)
value ('Hoa','Hai phong',1,1);
insert into Student(StudentName,Adress,NumberPhone,`Status`,ClassID)
value ('Manh','TP HCM','0912113000',0,2);
insert into `Subject`(SubName,Credit,`Status`)
value('CF',5,1),('C',6,1),('HDJ',5,1),('RDBMS',10,1);
insert into Mark(SubID,StudentID,Mark,ExamTimes)
value(1,1,8,1),(1,2,10,2),(2,1,12,1);
-- --Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select *
from student
where  StudentName like 'H%';
-- --Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select *
from Class
where StartDate between '2008-12-01' and '2008-12-30';
-- --Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select *
from `Subject`
where Credit between 3 and  5;
SET SQL_SAFE_UPDATES = 0;
-- --Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
update student
set ClassID =2
where StudentName = 'Hung';
-- --Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. 
-- nếu trùng sắp theo tên tăng dần.
select Student.StudentName,`Subject`.SubName,Mark.Mark
from Student join Mark on Student.StudentID = Mark.StudentID
join `Subject` on Mark.SubID = `Subject`.SubID
order by Mark.Mark asc,Student.StudentName asc;
