-- 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Đà Nẵng” 
-- và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”

create view V_nhan_vien as
select nv.ID_nhan_vien,nv.Ho_ten,nv.Ngay_sinh,nv.So_CMND,nv.So_dien_thoai,nv.Email,nv.Dia_chi
from nhan_vien nv inner join hop_dong hd on nv.ID_nhan_vien = hd.ID_nhan_vien
where nv.ID_nhan_vien  in(
	select Id_nhan_vien from hop_dong
)
and hd.Ngay_lam_hop_dong = '2019-12-12';

select * from V_nhan_vien;
drop view V_nhan_vien;

-- 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Ha Noi” đối với tất cả các Nhân viên 
-- được nhìn thấy bởi khung nhìn này.

update V_nhan_vien 
set Dia_chi = 'Ha Noi';




