-- 1.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên

select i.Instructor_id, i.Instructor_name, f.Faculty_name
from instructor i join faculty f on i.Faculty_id  = f.Faculty_id;

-- 2.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của các giảng viên của khoa ‘DIA LY va QLTN’

select i.Instructor_id, i.Instructor_name, f.Faculty_name
from instructor i join faculty f on i.Faculty_id  = f.Faculty_id
where f.Faculty_name = 'DIA LY' or f.Faculty_name ='QLTN';

-- 3.	Cho biết số sinh viên của khoa ‘CONG NGHE SINH HOC’

select count(s.Student_id) as So_sinh_vien_khoa_CNSH
from student s join faculty f on s.Faculty_id = f.Faculty_id
where f.Faculty_name ='CONG NGHE SINH HOC'
group by f.Faculty_name;

-- 4.	Đưa ra danh sách gồm mã số, họ tên và tuổi của các sinh viên khoa ‘TOAN’

select s.Student_id, s.Student_name, s.Date_of_birth, f.Faculty_name
from student s join faculty f on s.Faculty_id  = f.Faculty_id
where f.Faculty_name = 'TOAN';



