SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.'; 
explain SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.'; 
alter table customers 
add index idx_customer(customerName);
explain SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.'; 
alter table customers 
add index idx_full_name(contactFirstName,contactLastName);
explain SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King'; 
alter table customers 
drop index idx_full_name;