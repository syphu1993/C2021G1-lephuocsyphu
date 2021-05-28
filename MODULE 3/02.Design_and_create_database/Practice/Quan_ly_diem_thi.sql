create database if not exists Quan_ly_diem_thi;
use quan_ly_diem_thi;
create table Hoc_sinh(
MaHS varchar(20) primary key,
TenHS varchar(50),
Ngay_sinh datetime,
Lop varchar(20),
GT varchar(20)
);
create table Mon_hoc(
MaMH varchar(20) primary key,
TenMH varchar(50)
);
create table Bang_diem(
MaHS  varchar(20),
MaMH  varchar(20),
Diem_thi int,
NgayfKT datetime,
primary key(MaHS,MaMH),
foreign key(MaHS) references Hoc_sinh(MaHS),
foreign key(MaMH) references Mon_hoc(MaMH)
);
create table Giao_vien(
MaGV varchar(20) primary key,
TenGV varchar(50),
SDT varchar(20)
);
alter table Mon_hoc add  MaGV varchar(20);
alter table Mon_hoc add constraint FK_MaGV foreign key(MaGV) references Giao_vien(MaGV);
alter table Bang_diem 
change column NgayfKT NgayKT
datetime;
