create database if not exists Quan_ly_hang_hoa;
use Quan_ly_hang_hoa;
create table Nha_cung_cap(
Ma_nha_cung_cap int not null primary key auto_increment,
Ten_nha_cung_cap varchar(30) not null,
Dia_chi varchar(30),
So_dien_thoai varchar(30)
);
create table Don_dat_hang(
So_don_hang int not null primary key auto_increment,
Ngay_dat_hang datetime not null,
Ma_nha_cung_cap int not null,
foreign key(Ma_nha_cung_cap) references Nha_cung_cap(Ma_nha_cung_cap)
);
create table Vat_tu(
Ma_vat_tu int not null primary key auto_increment,
Ten_vat_tu varchar(30) not null
);
create table Phieu_nhap(
So_phieu_nhap int not null primary key auto_increment,
Ngay_nhap datetime not null
);
create table Phieu_xuat(
So_phieu_xuat int not null primary key auto_increment,
Ngay_xuat datetime not null
);
create table Xuat_vat_tu(
So_phieu_xuat int not null,
Ma_vat_tu int not null,
Don_gia_xuat float not null,
So_luong_xuat  int not null,
primary key(So_phieu_xuat,Ma_vat_tu),
foreign key(So_phieu_xuat) references Phieu_xuat(So_phieu_xuat),
foreign key(Ma_vat_tu) references Vat_tu(Ma_vat_tu)
);
create table Nhap_vat_tu(
So_phieu_nhap int not null,
Ma_vat_tu int not null,
Don_gia_nhap float not null,
So_luong_nhap  int not null,
primary key(So_phieu_nhap,Ma_vat_tu),
foreign key(So_phieu_nhap) references Phieu_nhap(So_phieu_nhap),
foreign key(Ma_vat_tu) references Vat_tu(Ma_vat_tu)
);
create table Don_hang_vat_tu(
Ma_vat_tu int not null,
So_don_hang int not null,
primary key(Ma_vat_tu,So_don_hang),
foreign key(Ma_vat_tu) references Vat_tu(Ma_vat_tu),
foreign key(So_don_hang) references Don_dat_hang(So_don_hang)
);