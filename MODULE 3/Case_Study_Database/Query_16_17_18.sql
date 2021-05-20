-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

SET FOREIGN_KEY_CHECKS=0;
SET SQL_SAFE_UPDATES = 0;
delete from nhan_vien 
where ID_nhan_vien not in (
    select idnv.newID from
	(select nv.ID_nhan_vien as newID
    from nhan_vien nv left join hop_dong hd on nv.ID_nhan_vien =hd.ID_nhan_vien
    where year(hd.Ngay_lam_hop_dong) between 2017 and 2019) as idnv
    );
SET FOREIGN_KEY_CHECKS=1;  

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách 
-- hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

SET FOREIGN_KEY_CHECKS=0;
SET SQL_SAFE_UPDATES = 0;
update khach_hang
set Id_loai_khach = 1
where Id_khach_hang in (
	select newtable.idkh from
	(select kh.Id_khach_hang  as idkh , sum(dv.Chi_phi_thue+dvdk.Gia*hdct.So_luong) as Tong_tien
    from khach_hang kh inner join hop_dong hd on kh.ID_khach_hang = hd.ID_hop_dong
    inner join loai_khach lk on lk.ID_loai_khach = kh.ID_loai_khach 
    inner join dich_vu dv on dv.ID_dich_vu =hd.ID_dich_vu
    inner join hop_dong_chi_tiet hdct on hdct.ID_hop_dong = hd.ID_hop_dong
    inner join dich_vu_di_kem dvdk on dvdk.ID_dich_vu_di_kem  = hdct.ID_dich_vu_di_kem
    where year(hd.Ngay_lam_hop_dong) = 2019 and lk.Ten_loai_khach_hang='Platinium'
    group by kh.ID_khach_hang
    having Tong_tien >10000000) as newtable
    );
SET FOREIGN_KEY_CHECKS=1;  

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).

SET FOREIGN_KEY_CHECKS=0;
SET SQL_SAFE_UPDATES = 0;
delete from khach_hang
where ID_khach_hang in(
	select newtable.idkh from
	(select kh.ID_khach_hang as idkh
    from khach_hang kh inner join hop_dong hd on kh.ID_khach_hang = hd.ID_khach_hang
    where year(hd.Ngay_lam_hop_dong)<2016) as newtable
);
SET FOREIGN_KEY_CHECKS=1;