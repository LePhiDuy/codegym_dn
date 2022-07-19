create database exam;
use exam;

create table category
(
	id int primary key auto_increment,
    name varchar(30)
);

create table product
(
	id int primary key auto_increment,
    name varchar(50),
    price double,
    quantity int,
    color varchar(50),
    `desc` varchar(200),
    id_category int not null,
    foreign key (id_category) references category(id)
);

insert into category(name)
values	('Phone'),
		('Television'),
		('Camera'),
		('Laptop');
insert into product(name, price, quantity, color, `desc`, id_category)
values	('IPhone 11', 799, 12, 'Purple, Yellow, Green', "New 100%, Bảo hành 12 tháng", 1),
		('IPhone 11 Pro', 1100, 12, 'Green, Black, White', "New 99%, Bảo hành 10 tháng", 1),
        ('IPhone X', 749, 13, 'Coral, Black, Blue', "New 99%", 1),
        ('Smart TV màn hình cong 4K UHD 49 inch RU7300', 2000, 5, 'Black', "New 99%, Bảo hành 24 tháng", 2),
        ('SAMSUNG GALAXY S10 E', 499, 10, 'Purple, Yellow, Green', "New 99%, Bảo Hành 12 tháng", 1),
        ('Laptop NITRO 5', 499, 20, 'Black', "New 80%, Bảo hành 18 tháng", 4);
        
