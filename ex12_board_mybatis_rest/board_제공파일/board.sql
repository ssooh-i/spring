use ssafyweb;

create table board2(
	num       int        primary key auto_increment,
	writer    varchar(12)  not null,
	title     varchar(50)  not null,
	content   varchar(4000),
	pwd       varchar(12)  not null,
	hit       int       not null,
	regdate   date          not null
);

select * from board2;
update board2 set hit=0;
drop table board;