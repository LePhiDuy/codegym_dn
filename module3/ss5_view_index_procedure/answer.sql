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

CREATE INDEX index_name_price ON products(product_name, product_price);

EXPLAIN SELECT * FROM products where product_code = 5;

CREATE OR REPLACE VIEW product_view
AS
	SELECT product_code, product_name, product_price, product_status FROM products;
    
SELECT * FROM product_view;

SELECT * FROM information_schema.views WHERE table_schema = 'demo';

UPDATE product_view SET product_price = 50 WHERE product_price = 12;

DROP VIEW product_view;

-- store procedure
DELIMITER $$ -- //
CREATE PROCEDURE infor()
BEGIN
	SELECT * FROM products;
END $$
DELIMITER ;

call infor();

DELIMITER $$
CREATE PROCEDURE add_product(in `code` int, in `name` varchar(45), in price float, in amount int, in description varchar(45), in `status` bit)
BEGIN
	INSERT INTO products(product_code, product_name, product_price, product_amount, product_description, product_status) 
    VALUES(`code`, `name`, price, amount, description, `status`);
END; $$
DELIMITER ;

call add_product(20, 'ABCD', 10, 10, 'HEHEHE', 1);

DELIMITER $$
CREATE PROCEDURE update_product(in pid int, in `code` int, in `name` varchar(45), in price float, in amount int, in description varchar(45), in `status` bit)
BEGIN
	UPDATE products SET product_code = `code`, product_name = `name`, product_price = price, product_amount = amount, product_description = description, product_status = `status`
    WHERE id = pid;
END; $$
DELIMITER ;

call update_product(1, 55, 'lephiduy', 90, 10, 'huhu', 0);

DELIMITER $$
CREATE PROCEDURE delete_product(in pid int)
BEGIN 
	DELETE FROM products where id = pid;
END; $$
DELIMITER ;

call delete_product(5);

DELIMITER //
CREATE PROCEDURE delete_product2(in pid int)
BEGIN 
	DELETE FROM products where id = pid;
END; //
DELIMITER ;

call delete_product2(4);

