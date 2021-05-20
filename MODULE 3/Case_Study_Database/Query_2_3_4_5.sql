-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” 
-- và có tối đa 15 ký tự.

select *
from Nhan_vien inner join Bo_phan on Nhan_vien.ID_bo_phan = Bo_phan.ID_bo_phan
inner join vi_tri on Nhan_vien.ID_vi_tri = vi_tri.ID_vi_tri
inner join trinh_do on Nhan_vien.ID_trinh_do = trinh_do.ID_trinh_do
where (Ho_ten like 'H%' or Ho_ten like 'T%' or Ho_ten like 'K%')and length(Ho_ten)<=15;

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

-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
--  cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select K.ID_khach_hang,K.Ho_ten,L.Ten_loai_khach_hang,H.ID_hop_dong,V.Ten_dich_vu,H.Ngay_lam_hop_dong,H.Ngay_ket_thuc,
sum(V.Chi_phi_thue+HDCT.So_luong*DVDK.Gia) as Tong_tien
from khach_hang K left join hop_dong H on K.ID_khach_hang = H.ID_khach_hang
inner join dich_vu V on H.ID_dich_vu = V.ID_dich_vu
inner join loai_khach L on L.ID_loai_khach = K.ID_loai_khach
inner join hop_dong_chi_tiet HDCT on HDCT.ID_hop_dong = H.ID_hop_dong
inner join dich_vu_di_kem DVDK on DVDK.ID_dich_vu_di_kem = HDCT.ID_dich_vu_di_kem
group by K.ID_khach_hang;
