use ssafyweb;
show tables;
drop table tb_customer;

create table tb_customer(
id varchar(10) primary key,
password varchar(10) not null,
name varchar(16));

select * from tb_customer;