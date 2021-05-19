-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 2 lần trong năm 2019 lên gấp đôi.

SET FOREIGN_KEY_CHECKS=0;
SET SQL_SAFE_UPDATES = 0;
update dich_vu_di_kem 
set Gia = Gia*2
where Id_dich_vu_di_kem in(
	select new_table.iddvdk from
	(select dvdk.ID_dich_vu_di_kem as iddvdk , count(hdct.ID_hop_dong_chi_tiet) as So_lan_su_dung
    from hop_dong_chi_tiet hdct inner join dich_vu_di_kem dvdk on  hdct.ID_dich_vu_di_kem = dvdk.ID_dich_vu_di_kem
    inner join hop_dong hd on hd.ID_hop_dong = hdct.ID_hop_dong
    where  year(hd.Ngay_lam_hop_dong)  = 2019
    group by dvdk.ID_dich_vu_di_kem, dvdk.Ten_dich_vu_di_kem
    having So_lan_su_dung >2) as new_table
);
SET FOREIGN_KEY_CHECKS=1; 

-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID
--  (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

select Id_nhan_vien as ID,Ho_ten,Email,So_dien_thoai,Dia_chi,Ngay_sinh
from nhan_vien
union all
select Id_khach_hang as ID,Ho_ten,Email,So_dien_thoai,Dia_chi,Ngay_sinh
from khach_hang;

