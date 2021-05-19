-- 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được truyền vào 
-- như là 1 tham số của Sp_1

DELIMITER //
create procedure Xoa_khach_hang(Id_p int)
begin
delete from khach_hang
where ID_khach_hang = Id_p;
end //
DELIMITER ;
SET FOREIGN_KEY_CHECKS=0;
SET SQL_SAFE_UPDATES = 0;
call Xoa_khach_hang(2);

-- 24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện kiểm tra 
-- tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu
-- đến các bảng liên quan.

DELIMITER //
create procedure Them_hop_dong(Id_hopdong_p int,Id_nhanvien_p int,Id_khachhang_p int,Id_dichvu_p int,
Ngay_lam_hop_dong_p date, Ngay_ket_thuc_hop_dong_p date,Tien_dat_coc_p int, Tien_tang_p int)
begin
if(
	Id_hopdong_p not in (select Id_hop_dong  from hop_dong) 
	and Id_nhanvien_p in(select Id_nhan_vien from nhan_vien)
	and Id_khachhang_p in(select Id_khach_hang from khach_hang)
	and Id_dichvu_p in(select Id_dich_vu from dich_vu)
    ) then
	insert into hop_dong
	value(Id_hopdong_p,Id_nhanvien_p,Id_khachhang_p,Id_dichvu_p,Ngay_lam_hop_dong_p, Ngay_ket_thuc_hop_dong_p,Tien_dat_coc_p, Tien_tang_p);
else 
	SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Loi_nhap,Nhap_lai!!';    
 end if ;
end ; //
DELIMITER ;
call Them_hop_dong(10,1,1,3,'2021-05-12','2021-05-30',500000,500000);