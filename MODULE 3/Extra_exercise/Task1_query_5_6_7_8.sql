-- 5.	Cho biết số giảng viên của khoa ‘CONG NGHE SINH HOC’

select count(i.Instructor_id) as So_giang_vien_khoa_CNSH
from instructor i join faculty f on i.Faculty_id = f.Faculty_id
where f.Faculty_name ='CONG NGHE SINH HOC'
group by f.Faculty_name;

-- 6.	Cho biết thông tin về sinh viên không tham gia thực tập

select *
from student s left join instructor_student si on s.Student_id = si.Student_id
where s.Student_id not in (
	select s.Student_id
    from student s join instructor_student si on s.Student_id = si.Student_id);