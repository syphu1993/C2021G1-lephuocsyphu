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
-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” 
-- và có tối đa 15 ký tự.
select *
from Nhan_vien inner join Bo_phan on Nhan_vien.ID_bo_phan = Bo_phan.ID_bo_phan
inner join vi_tri on Nhan_vien.ID_vi_tri = vi_tri.ID_vi_tri
inner join trinh_do on Nhan_vien.ID_trinh_do = trinh_do.ID_trinh_do
where (Ho_ten like '% H%'or Ho_ten like '% T%' or Ho_ten like '% K%')and length(Ho_ten)<=15;
-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc 
-- “Quảng Trị”.
select *
from Khach_hang inner join loai_khach on khach_hang.ID_loai_khach = loai_khach.ID_loai_khach
where ((year(curdate())-year(Khach_hang.Ngay_sinh)) between 18 and 50) 
and (Khach_hang.Dia_chi = 'Da Nang'or Khach_hang.Dia_chi = 'Quang Tri');
-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
--  Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select K.Ho_ten, count(K.ID_khach_hang) as 'Lan_dat_phong'
from khach_hang K inner join hop_dong H on K.ID_khach_hang = H.ID_khach_hang
inner join loai_khach L on K.ID_loai_khach = L.ID_loai_khach
where L.Ten_loai_khach_hang = 'Diamond'
group by K.ID_khach_hang
order by Lan_dat_phong asc;
