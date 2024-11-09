drop table IF EXISTS coin;
create TABLE coin (
    id long auto_increment primary key not null,
	code char(4),
	name varchar(100),
	symbol char(15),
	rate varchar(20),
	description varchar(100),
	rate_float decimal(10,4),
	update_time datetime default now()
);
