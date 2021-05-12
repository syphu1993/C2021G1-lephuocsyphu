create database Data_Furama;
use data_furama;
create table Khach_hang(
ID_khach_hang int not null primary key,
ID_loai_khach int not null,
Ho_ten varchar(45),
Ngay_sinh date,
So_CMND  varchar(45),
So_dien_thoai  varchar(45),
Email  varchar(45),
Dia_chi  varchar(45)
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
Dia_chi  varchar(45)
);
create table Hop_dong(
ID_hop_dong int not null primary key,
ID_nhan_vien int not null,
ID_khach_hang int not null,
ID_dich_vu int not null,
Ngay_lam_hop_dong date,
Ngay_ket_thuc date,
Tien_dat_coc int,
Tang_tien  int
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
Trang_thai varchar(45)
);
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
)