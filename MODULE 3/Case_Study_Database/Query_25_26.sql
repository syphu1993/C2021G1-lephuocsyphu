-- 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại 
-- có trong bảng HopDong ra giao diện console của database

drop trigger if exists Tr_1;
DELIMITER //
create trigger Tr_1 after delete  on hop_dong
for each row
begin
select (select count(Id_hop_dong) from hop_dong)
as log into outfile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/log2.txt';
end ; //
DELIMITER ;
delete from hop_dong
where Id_hop_dong = 1;

-- 26.	Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật
--  có phù hợp hay không, với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất
--  là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo 
--  “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database

drop trigger if exists Tr_2;
DELIMITER //
create trigger Tr_2 before update on hop_dong
for each row
begin
if   datediff(new.Ngay_ket_thuc,old.Ngay_lam_hop_dong)>=2 then
     SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Dung';
else 
     SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Sai,Nhap_lai!!';
end if ;     
end ; //
DELIMITER ;

update hop_dong
set Ngay_ket_thuc = '2019-02-17'
where Id_hop_dong = 2;



