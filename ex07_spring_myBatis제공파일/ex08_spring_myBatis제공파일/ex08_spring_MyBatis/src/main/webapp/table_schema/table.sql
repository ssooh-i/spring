use ssafyweb;
show tables;

drop table emp;

create table emp(
eno int primary key auto_increment,
ename varchar(20) not null,
phone varchar(20),
dept varchar(20));

select * from emp;
delete from emp;
select * from emp where eno<=3 and dept like '%업%';

set autocommit=1;