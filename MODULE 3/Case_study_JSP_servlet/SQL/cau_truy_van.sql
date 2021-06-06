select c.customer_id,ct.Customer_type_name,c.Customer_name,c.Customer_gender,c.Customer_phone,c.Customer_email,c.Customer_address
from customer c join customer_type ct on c.Customer_type_id = ct.Customer_type_id
where c.Customer_name like '%g%' ;

insert into Customer (Customer_type_id,Customer_name,Customer_birthday,Customer_gender,Customer_id_card,
Customer_phone,Customer_email,Customer_address)
value(2,'Nguyen van Hoa','1993-12-25','male','123456789','0373306101','hoa@gmail.com','Da Nang');

update customer
set Customer_type_id=1,Customer_name='binh',Customer_birthday='1998-02-02',Customer_gender='Male',Customer_id_card='125125125',
Customer_phone='0933252525',Customer_email='binh@gmail.com',Customer_address='Hue'
where customer_id =1;

select c.customer_id,ct.Customer_type_name,c.Customer_name,c.Customer_birthday,c.Customer_gender,c.Customer_id_card,c.Customer_phone,c.Customer_email,c.Customer_address
from customer c join customer_type ct on c.Customer_type_id = ct.Customer_type_id
where c.customer_id =3;

delete from customer
where customer_id =8;

insert into service
value(1,'villa',100,5000000,6,3,1,'high','pool',20,4);

select e.employee_id, e.employee_name, e.employee_phone, e.employee_address, p.Position_name, 
ed.Education_degree_name, d.Division_name
from employee e join position p on e.Position_id = p.Position_id
join education_degree ed on e.Education_degree_id = ed.Education_degree_id
join division d on e.Division_id = d.Division_id
join `user` u on u.username = e.username;

insert into employee(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,
 employee_email,employee_address,Position_id,Education_degree_id,Division_id,username)
 value('Le Khanh','1992-10-12','123222131',5500000,'0999252111','Khanh1@gmail.com','Quang Tri',2,1,1,'KhanhFurama');

insert into `User`
value('CuongFurama','123');

select e.employee_id, e.employee_name, e.employee_birthday,e.employee_id_card,e.employee_salary, e.employee_phone,
e.employee_email, e.employee_address, p.Position_name, ed.Education_degree_name, d.Division_name, e.username
from employee e join position p on e.Position_id = p.Position_id
join education_degree ed on e.Education_degree_id = ed.Education_degree_id
join division d on e.Division_id = d.Division_id
join `user` u on u.username = e.username
where e.employee_id =1;

update employee
set employee_name='Phan Hong', employee_birthday='1999-12-10',employee_id_card='222233334',
employee_salary=5700000, employee_phone = '0987654321',employee_email='hong@gmail.com',
 employee_address='Ha Noi', Position_id=1, Education_degree_id=1, Division_id=1
 where employee_id =12;

delete from employee
where employee_id=10;

select e.employee_id, e.employee_name, e.employee_phone, e.employee_address, p.Position_name, 
ed.Education_degree_name, d.Division_name
from employee e join position p on e.Position_id = p.Position_id
join education_degree ed on e.Education_degree_id = ed.Education_degree_id
join division d on e.Division_id = d.Division_id
join `user` u on u.username = e.username
where e.employee_name like '%a%';

select *
from customer_type;

select position.Position_name
from position;

select education_degree.Education_degree_name
from education_degree;

select *
from contract ct 

	