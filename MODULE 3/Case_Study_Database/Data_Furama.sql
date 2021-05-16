create database if not exists Data_Furama;
use data_furama;
create table Vi_tri(
ID_vi_tri int not null  primary key,
Ten_vi_tri varchar(45)
);
create table Trinh_do(
ID_trinh_do int not null  primary key,
Trinh_do varchar(45)
);
create table Bo_phan(
ID_bo_phan int not null  primary key,
Bo_phan varchar(45)
);
create table Loai_khach(
ID_loai_khach int not null primary key,
Ten_loai_khach_hang  varchar(45)
);
create  table Kieu_thue(
ID_kieu_thue int not null primary key,
Ten_kieu_thue varchar(45) not null,
Gia int not null
);
create table Loai_dich_vu(
ID_loai_dich_vu int not null primary key,
Ten_loai_dich_vu varchar(45)
);
create table Khach_hang(
ID_khach_hang int not null primary key,
ID_loai_khach int not null,
Ho_ten varchar(45),
Ngay_sinh date,
So_CMND  varchar(45),
So_dien_thoai  varchar(45),
Email  varchar(45),
Dia_chi  varchar(45),
foreign key(ID_loai_khach) references Loai_khach(ID_loai_khach)
);
create table Nhan_vien(
ID_nhan_vien int not null primary key,
Ho_ten varchar(45),
ID_vi_tri int not null,
ID_trinh_do int not null,
ID_bo_phan int not null,
Ngay_sinh date,
So_CMND  varchar(45),
Luong  varchar(45),
So_dien_thoai  varchar(45),
Email  varchar(45),
Dia_chi  varchar(45),
foreign key(ID_vi_tri) references Vi_tri(ID_vi_tri),
foreign key(ID_trinh_do) references Trinh_do(ID_trinh_do),
foreign key(ID_bo_phan) references Bo_phan(ID_bo_phan)
);
create table Dich_vu(
ID_dich_vu int not null primary key,
Ten_dich_vu varchar(45),
Dien_tich int,
So_tang int,
So_nguoi_toi_da varchar(45),
Chi_phi_thue varchar(45),
ID_kieu_thue int,
ID_loai_dich_vu int,
Trang_thai varchar(45),
foreign key(ID_kieu_thue) references Kieu_thue(ID_kieu_thue),
foreign key(ID_loai_dich_vu) references Loai_dich_vu(ID_loai_dich_vu)
);
create table Hop_dong(
ID_hop_dong int not null primary key,
ID_nhan_vien int not null,
ID_khach_hang int not null,
ID_dich_vu int not null,
Ngay_lam_hop_dong date,
Ngay_ket_thuc date,
Tien_dat_coc int,
Tang_tien  int,
foreign key(ID_nhan_vien) references Nhan_vien(ID_nhan_vien),
foreign key(ID_khach_hang) references Khach_hang(ID_khach_hang),
foreign key(ID_dich_vu) references Dich_vu(ID_dich_vu)
);
create table Dich_vu_di_kem(
ID_dich_vu_di_kem int primary key not null,
Ten_dich_vu_di_kem varchar(45),
Gia int not null,
Don_vi int,
Trang_thai_Kha_dung varchar(45)
);
create table Hop_dong_chi_tiet(
ID_hop_dong_chi_tiet int not null primary key auto_increment,
ID_hop_dong int not null,
ID_dich_vu_di_kem int not null,
So_luong int,
foreign key(ID_hop_dong) references Hop_dong(ID_hop_dong),
foreign key(ID_dich_vu_di_kem) references Dich_vu_di_kem(ID_dich_vu_di_kem)
);
-- 1a. Insert data for table Vi_tri;
insert into Vi_tri
value(1,'Truong_bo_phan'),(2,'Nhan_vien');
-- 1b. Insert data for table Trinh_do;
insert into Trinh_do
value(1,'Dai_hoc'),(2,'Cao_dang'),(3,'Trung_cap');
-- 1c. Insert data for table Bo_phan;
insert into Bo_phan
value(1,'Maketing'),(2,'Le_tan'),(3,'Buong_phong');
-- 1d. Insert data for table Loai_khach;
insert into loai_khach
value(1,'Vip'),(2,'Normal');
update loai_khach
set Ten_loai_khach_hang ='Diamond'
where ID_loai_khach = 1;
-- 1e. Insert data for table Kieu_thue;
insert into Kieu_thue()
value(1,'Theo_gio',50000),(2,'Theo_ngay',1000000),(3,'Theo_thang',5000000);
-- 1f. Insert data for table Loai_dich_vu;
insert into loai_dich_vu
value(1,'VIP'),(2,'Good'),(3,'Normal');
-- 1g. Insert data for table Khach_hang;
insert into khach_hang
value(1,2,'Nguyen van Hoa','1993-12-25','123456789','0373306101','hoang@gmail.com','Da Nang'),
(2,1,'Nguyen van Khoa','1960-05-26','123456781','0373306102','khoa@gmail.com','Quang Tri'),
(3,2,'Nguyen Quoc Thinh','1997-10-28','123456782','0373306103','hoang@gmail.com','Quang Tri'),
(4,1,'Nguyen Thi Hien','2009-01-27','123456783','0373306104','hoang@gmail.com','Quang Binh');
insert into khach_hang
value(5,2,'Nguyen van Hoa','1995-10-09','000456789','0373306000','hoanguyen@gmail.com','Quang Ngai');
-- 1g. Insert data for table Nhan_vien;
insert nhan_vien
value(1,'Do Van Khanh',1,1,1,'1993-07-12','097272380','8000000','0911012123','khanh@gmail.com','Da Nang'),
(2,'Le Van Hoa',2,1,1,'1995-08-09','097272381','5000000','0911012124','hoa@gmail.com','Quang Nam'),
(3,'Do Van Quoc',2,1,1,'1996-08-05','097272382','5000000','0911012125','quoc@gmail.com','Quang Tri'),
(4,'Nguyen Thi Hue',1,2,2,'1993-10-12','087272380','6000000','0811012123','hue@gmail.com','Da Nang'),
(5,'Do Thi Tuyet',2,2,2,'1995-01-01','077272380','4000000','0711012123','khanh@gmail.com','Quang Binh'),
(6,'Le thi Quynh',2,2,2,'1998-03-09','067272380','4000000','0611012123','quynh@gmail.com','Da Nang'),
(7,'Mai Quoc Nam',1,2,3,'1993-02-12','057272380','5000000','0511012123','nam@gmail.com','Da Nang'),
(8,'Nguyen Thi Lan',2,2,3,'1993-02-14','037272380','3000000','0411012123','nam@gmail.com','Quang Ngai'),
(9,'Le Hung Dung',2,2,3,'1993-02-23','047272380','3000000','0311012123','dung@gmail.com','Hue');
update nhan_vien
set Ho_ten = 'Huynh Ngoc Hue'
where ID_nhan_vien = 2;
update nhan_vien
set Ho_ten = 'Kha Can Van'
where ID_nhan_vien = 6;
update nhan_vien
set Ho_ten = 'Tong Khuong'
where ID_nhan_vien = 9;
-- 1l. Insert data for table Dich_vu;
insert dich_vu
value(1,'Villa',150,3,5,3000000,2,1,'open'),(2,'House',100,2,4,2000000,3,2,'open'),(3,'Room',75,1,2,1000000,1,3,'open');
SET SQL_SAFE_UPDATES = 0;
delete  from dich_vu;
-- 1k. Insert data for table Hop_dong;
insert into hop_dong
value(1,1,1,1,'2021-05-12','2021-05-30',500000,500000);
insert into hop_dong
value(2,1,2,2,'2021-05-13','2021-07-13',2000000,1000000);
insert into hop_dong
value(3,1,3,3,'2021-05-15','2021-05-16',100000,100000);
insert into hop_dong
value(4,1,4,1,'2021-06-12','2021-06-30',700000,400000);
insert into hop_dong
value(5,1,1,2,'2021-09-12','2021-12-12',1000000,700000);
insert into hop_dong
value(6,1,1,3,'2021-01-12','2021-01-13',900000,400000);
insert into hop_dong
value(7,1,4,2,'2021-01-12','2021-03-30',7000000,4000000);
SET SQL_SAFE_UPDATES = 0;
update hop_dong
set Ngay_lam_hop_dong = '2019-02-13',Ngay_ket_thuc='2019-07-13'
where ID_hop_dong = 2;
update hop_dong
set Ngay_lam_hop_dong = '2019-01-12',Ngay_ket_thuc='2019-02-15'
where ID_hop_dong = 7;
update hop_dong
set Ngay_lam_hop_dong = '2018-05-12',Ngay_ket_thuc='2018-05-30'
where ID_hop_dong = 1;
update hop_dong
set Ngay_lam_hop_dong = '2019-06-12',Ngay_ket_thuc='2019-06-30'
where ID_hop_dong = 4;
update hop_dong
set Ngay_lam_hop_dong = '2018-09-12',Ngay_ket_thuc='2018-12-12'
where ID_hop_dong = 5;
update hop_dong
set Ngay_lam_hop_dong = '2018-01-12',Ngay_ket_thuc='2018-01-13'
where ID_hop_dong = 6;
-- 1m. Insert data for table Dich_vu_di_kem;
insert into dich_vu_di_kem
value(1,'massage',300000,1,'open'),(2,'swim',200000,1,'open'),(3,'karaoke',400000,1,'open');
-- 1n. Insert data for table Hop_dong_chi_tiet;
insert into hop_dong_chi_tiet
value(1,1,2,5),(2,2,1,2),(3,3,3,3),(4,4,1,1);

