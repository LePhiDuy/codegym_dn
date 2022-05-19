create database quan_ly_sinh_vien;

use quan_ly_sinh_vien;

create table class(
id int primary key auto_increment,
name varchar(60) not null,
start_date datetime not null,
status bit
);

create table student(
id int auto_increment primary key,
name varchar(30) not null,
address varchar(50),
phone varchar(20),
status bit,
class_id int not null,
foreign key(class_id) references class(id)
);

create table subject(
id int auto_increment primary key,
name varchar(30) not null,
credit tinyint not null default 1 check (credit >= 1),
status bit default 1
);

create table mark(
id int auto_increment primary key,
subject_id int not null,
student_id int not null,
unique(subject_id, student_id),
mark float default 0 check (mark between 0 and 100),
exam_times tinyint default 1
);

alter table mark
add
foreign key (subject_id) references subject(id),
add foreign key (student_id) references student(id);
