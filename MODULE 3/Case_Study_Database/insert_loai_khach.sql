SELECT * FROM data_furama.loai_khach;
insert into loai_khach
value(1,'Vip'),(2,'Normal');
update loai_khach
set Ten_loai_khach_hang ='Diamond'
where ID_loai_khach = 1;