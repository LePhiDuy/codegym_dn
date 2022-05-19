CREATE DATABASE QuanLyDiemThi;	
use QuanLyDiemThi;

CREATE TABLE hoc_sinh(
maHS INT auto_increment primary key,
tenHS varchar(5),
ngay_sinh DATE,
lop varchar(20),
gioi_tinh BIT
);

create table mon_hoc(
maMH int auto_increment primary key,
tenMH varchar(50),
maGV int not null 
);

create table bang_diem(
maHS int,
maMH int,
diem_thi float,
ngay_KT DATE,
primary key(maHS, maMH)
);

create table giao_vien(
maGV int auto_increment primary key,
tenGV varchar(50),
sdt varchar(10)
);

ALTER table mon_hoc
ADD foreign key (maGV) references giao_vien(maGV);

ALTER table bang_diem
ADD
foreign key (maHS) references hoc_sinh(maHS),
ADD foreign key (maMH) references mon_hoc(maMH);