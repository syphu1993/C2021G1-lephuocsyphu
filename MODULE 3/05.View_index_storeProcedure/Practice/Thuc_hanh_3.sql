SELECT * FROM classicmodels.customers;
DELIMITER //
create procedure getCusById(in IdCus int(11))
begin
select * from customers 
where customerNumber = IdCus;
end //
DELIMITER ;
call getCusById(175);
DELIMITER //
drop procedure if exists `GetCustomersCountByCity` //
create procedure GetCustomersCountByCity(in In_city varchar(255), out total int)
begin
select count(customerNumber) into total
from customers 
where city = In_city;
end //
DELIMITER ;
CALL GetCustomersCountByCity('Lyon',@total);
select @total;

