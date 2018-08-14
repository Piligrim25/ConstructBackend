create table image
(
	image_id int(5) auto_increment
		primary key,
	type_id int(5) not null,
	url varchar(50) not null
)
;

create index type_id
	on image (type_id, url)
;

create table type
(
	type_id int(5) auto_increment
		primary key,
	name varchar(50) null
)
;

