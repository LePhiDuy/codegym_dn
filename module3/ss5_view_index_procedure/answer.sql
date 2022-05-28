create database demo;
use demo;

create table products(
id int primary key auto_increment,
product_code int unique,
product_name varchar(45),
product_price float,
product_amount int,
product_description varchar(45),
product_status bit
);

insert into products
values
	(1, 1, 'abc', 12, 10, 'aaa', 1),
	(2, 2, 'def', 13, 11, 'bbb', 1),
	(3, 3, 'egh', 42, 1, 'ccc', 0),
	(4, 4, 'jhk', 15, 15, 'ddd', 1),
	(5, 5, 'lko', 16, 9, 'aaa', 0),
	(6, 6, 'qwe', 17, 8, 'bcv', 1),
	(7, 7, 'rty', 18, 7, 'gag', 0),
	(8, 8, 'yui', 19, 6, 'kaka', 1),
	(9, 9, 'lok', 121, 5, 'hahah', 0),
	(10, 10, 'pol', 121, 11, 'haha', 1),
	(11, 11, 'lok', 123, 18, 'klo', 1),
	(12, 12, 'mnb', 124, 20, '123', 0),
	(13, 13, 'zxc', 125, 10, 'aaa', 1);

CREATE UNIQUE INDEX index_product_code ON products(product_code);
