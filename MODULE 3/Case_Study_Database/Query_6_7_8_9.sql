-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được 
-- Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

select DV.ID_dich_vu, DV.Ten_dich_vu, DV.Dien_tich, DV.Chi_phi_thue, LDV.Ten_loai_dich_vu
from dich_vu DV inner join loai_dich_vu LDV on DV.ID_loai_dich_vu = LDV.ID_loai_dich_vu
inner join hop_dong HD on  HD.ID_dich_vu = DV.ID_dich_vu
where DV.ID_dich_vu not in(
	select hop_dong.ID_dich_vu 
	from hop_dong
	where hop_dong.Ngay_lam_hop_dong between '2019-01-01' and '2019-03-31')
group by DV.ID_dich_vu;

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại 
-- dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

select DV.ID_dich_vu, DV.Ten_dich_vu, DV.Dien_tich, DV.So_nguoi_toi_da, DV.Chi_phi_thue, LDV.Ten_loai_dich_vu
from dich_vu DV inner join loai_dich_vu LDV on DV.ID_loai_dich_vu = LDV.ID_loai_dich_vu
inner join hop_dong HD on  HD.ID_dich_vu = DV.ID_dich_vu
where DV.ID_dich_vu not in(
	select hop_dong.ID_dich_vu 
    from hop_dong
	where year(Ngay_lam_hop_dong)=2019)
and year(HD.Ngay_lam_hop_dong) =2018
group by DV.ID_dich_vu;

-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.

-- Cách 1:
select Ho_ten
from khach_hang
group by Ho_ten;
-- Cách 2:
select distinct Ho_ten
from khach_hang;
-- Cách 3:
select Ho_ten
from khach_hang
union 
select Ho_ten
from khach_hang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu
--  khách hàng thực hiện đặt phòng.

select month(hd.Ngay_lam_hop_dong), count(hd.ID_khach_hang) as 'So_luong_khach_dat_phong',
sum(dv.Chi_phi_thue + hdct.So_luong*dvdk.Gia) as 'Tong_thu'
from khach_hang kh inner join hop_dong hd  on kh.ID_khach_hang = hd.ID_khach_hang
inner join dich_vu dv on dv.ID_dich_vu = hd.ID_dich_vu
inner join hop_dong_chi_tiet hdct on hdct.ID_hop_dong = hd.ID_hop_dong
inner join dich_vu_di_kem dvdk on dvdk.ID_dich_vu_di_kem = hdct.ID_dich_vu_di_kem
where year(hd.Ngay_lam_hop_dong)=2019
group by month(hd.Ngay_lam_hop_dong);


