SELECT * FROM data_furama.loai_dich_vu;
insert into loai_dich_vu
value(1,'Villa'),(2,'House'),(3,'Room');
update loai_dich_vu
set ten_loai_dich_vu = 'VIP'
where ID_loai_dich_vu =1;
update loai_dich_vu
set ten_loai_dich_vu = 'Good'
where ID_loai_dich_vu =2;
update loai_dich_vu
set ten_loai_dich_vu = 'Normal'
where ID_loai_dich_vu =3;