--Create table
--Account table
create table account
(
	id serial ,
	account varchar(255) not null,
	pwd varchar(255) not null,
	primary key(id)
);

--Zoo table
CREATE TABLE Zoo
(
	_id serial,
	location varchar(255) not null,
	primary key (_id)
);

--Cage table
CREATE TABLE Cage
(
	_id serial,
	price bigint not null,
	hygiene bigint,
	zooID bigint not null,
	primary key (_id)
);

--Animal table

CREATE TABLE Animal
(
	_id serial,
	animal_type  varchar(255) not null,
	name varchar(255) not null,
	health bigint not null,
	cage_id bigint not null,
	primary key (_id)
);

--Plan table

CREATE TABLE Plan
(
	_id serial,
	title  varchar(255) not null,
	discount bigint not null,
	zoo_id bigint not null,
	primary key (_id)
);
-----------------

--INSERT DATA into account
insert into account (account, pwd)
values
('admin', 'admin'),
('chinhNguyen', 'chinhNguyen'),
('dieuDoan', 'dieuDoan');
--INSERT DATA INTO Zoo => there is only one zoo, so It's unnecessary

--INSERT DATA into Cage 

