-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao
--  gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các 
--  IDHopDongChiTiet).
select hd.ID_hop_dong, hd.Ngay_lam_hop_dong, hd.Ngay_ket_thuc, hd.Tien_dat_coc,
count(hdct.ID_hop_dong_chi_tiet) as 'So_luong_dich_vu_di_kem'
from hop_dong hd inner join hop_dong_chi_tiet hdct on hd.ID_hop_dong = hdct.ID_hop_dong
group by hdct.ID_hop_dong;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
-- và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select kh.Ho_ten, lk.Ten_loai_khach_hang, kh.Dia_chi, dvdk.Ten_dich_vu_di_kem
from khach_hang kh inner join loai_khach lk on kh.ID_loai_khach = lk.ID_loai_khach
inner join hop_dong hd on hd.ID_khach_hang = kh.ID_khach_hang
inner join hop_dong_chi_tiet hdct on hdct.ID_hop_dong = hd.ID_hop_dong
inner join dich_vu_di_kem  dvdk on dvdk.ID_dich_vu_di_kem = hdct.ID_dich_vu_di_kem
where lk.Ten_loai_khach_hang = 'Diamond' and (kh.Dia_chi = 'Vinh' or kh.Dia_chi = 'Quang Ngai');

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3
--  tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
select hd.ID_hop_dong, nv.Ho_ten, kh.Ho_ten, kh.So_dien_thoai, dv.Ten_dich_vu,
count(hdct.ID_hop_dong_chi_tiet) as 'So_luong_dich_vu_di_kem'
from khach_hang kh inner join hop_dong hd on kh.ID_khach_hang = hd.ID_khach_hang
inner join nhan_vien nv on nv.ID_nhan_vien = hd.ID_nhan_vien
right join hop_dong_chi_tiet hdct on hdct.ID_hop_dong = hd.ID_hop_dong
inner join dich_vu dv on dv.ID_dich_vu = hd.ID_dich_vu
where dv.ID_dich_vu not in(select hop_dong.ID_dich_vu 
from hop_dong
where month(hop_dong.Ngay_lam_hop_dong)<=6 and year(hop_dong.Ngay_lam_hop_dong)=2019)
and (month(hd.Ngay_lam_hop_dong)>=10 and year(hd.Ngay_lam_hop_dong)=2019)
group by hdct.ID_hop_dong;