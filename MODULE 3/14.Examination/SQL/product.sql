create  database if not exists product;
use product;
create table catelogy(
id_catelogy int not null primary key auto_increment,
name_catelogy varchar(45)
);

insert into catelogy(name_catelogy)
value('sonny'),('GL'),('Samsung');

create table products(
id int not null primary key auto_increment,
`name` varchar(45),
price double,
quanlity int,
color varchar(45),
decription varchar(45),
id_catelogy int,
foreign key(id_catelogy) references catelogy(id_catelogy)
);

insert into products(`name`,price,quanlity,color,decription,id_catelogy)
value('nokia',200,2,'red','JV',1),('samsung',300,5,'blu','KR',2),('iphone',500,5,'green','VN',3);

select pr.id,pr.`name`,pr.price,pr.quanlity,pr.color,c.name_catelogy
from products pr join catelogy c on pr.id_catelogy = c.id_catelogy;

select name_catelogy
from catelogy;

insert into products(`name`,price,quanlity,color,decription,id_catelogy)
value('nokia',200,2,'red','JV',1);

delete from products
where id = 4;

select pr.id,pr.`name`,pr.price,pr.quanlity,pr.color,c.name_catelogy
from products pr join catelogy c on pr.id_catelogy = c.id_catelogy
where pr.`name` like '%a%';

insert into products(`name`,price,quanlity,color,decription,id_catelogy)
value('nokiaxx',204,2,'red','VN',2);



