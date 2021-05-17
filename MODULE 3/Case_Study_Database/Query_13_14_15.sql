-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select dvdk.ID_dich_vu_di_kem,dvdk.Ten_dich_vu_di_kem,dvdk.Gia,dvdk.Don_vi,dvdk.Trang_thai_Kha_dung,
count(hdct.ID_hop_dong_chi_tiet) as So_luong_dich_vu_di_kem
from Hop_dong hd inner join Hop_dong_chi_tiet hdct on hd.Id_hop_dong = hdct.Id_hop_dong
inner join dich_vu_di_kem dvdk on dvdk.ID_dich_vu_di_kem = hdct.ID_dich_vu_di_kem
group by dvdk.ID_dich_vu_di_kem
having count(hdct.ID_hop_dong_chi_tiet) >= all(select count(hdct.ID_hop_dong_chi_tiet)
from Hop_dong hd inner join Hop_dong_chi_tiet hdct on hd.Id_hop_dong = hdct.Id_hop_dong
inner join dich_vu_di_kem dvdk on dvdk.ID_dich_vu_di_kem = hdct.ID_dich_vu_di_kem
group by dvdk.ID_dich_vu_di_kem);

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm
--  IDHopDong, TenLoaiDichVu,TenDichVuDiKem, SoLanSuDung.

select hd.ID_hop_dong,dv.Ten_dich_vu,dvdk.Ten_dich_vu_di_kem,
count(hdct.ID_hop_dong_chi_tiet) as So_lan_su_dung
from Hop_dong hd inner join Hop_dong_chi_tiet hdct on hd.Id_hop_dong = hdct.Id_hop_dong
inner join dich_vu dv on dv.ID_dich_vu = hd.ID_dich_vu
inner join dich_vu_di_kem dvdk on dvdk.ID_dich_vu_di_kem = hdct.ID_dich_vu_di_kem
group by dvdk.ID_dich_vu_di_kem
having count(hdct.ID_hop_dong_chi_tiet) =1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai,
--  DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select *, count(hd.ID_hop_dong) as So_lan_lap_hop_dong
from nhan_vien nv inner join hop_dong hd on nv.ID_nhan_vien = hd.ID_nhan_vien
inner join trinh_do td on td.ID_trinh_do = nv.ID_trinh_do
inner join bo_phan bp on bp.ID_bo_phan = nv.ID_bo_phan
where year(hd.Ngay_lam_hop_dong) between 2018 and 2019
group by nv.ID_nhan_vien
having So_lan_lap_hop_dong between 1 and 3;