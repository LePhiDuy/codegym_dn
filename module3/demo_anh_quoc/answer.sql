use demo_anh_quoc;

create table student(
id int primary key,
`name` varchar(45),
age int,
address varchar(45),
class_id int not null,
foreign key (class_id) references class(id)
);

insert into class
values(1, 'A12'),
	  (2, 'A10'),
      (3, 'A08');
      
insert into student
values 
	(1, 'Chau', 20, 'A1', 1),
	(2, 'Anh', 18, 'A2', 2),
	(3, 'Son', 22, 'A3', 3),
	(4, 'Phuong', 22, 'A4', 1),
	(5, 'Lam', 22, 'A5', 1),
	(6, 'Linh', 21, 'A6', 1),
	(7, 'Huy', 20, 'A7', 2);
    
insert into student
values 
(9, 'Quoc', 21, 'A6', 1);
-- cau 1
select * from student 
where age >= (select max(age) from student);

-- cau 2
explain select * from student
where age = (select max(age) from student
where age < (select max(age) from student));

select * from student
group by age
order by age desc
limit 1,1;
