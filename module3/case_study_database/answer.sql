use furama_management;
/*
2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
*/
SELECT * FROM nhan_vien;
SELECT * FROM nhan_vien
WHERE substring_index(ho_ten, ' ', -1) REGEXP '^[HTK]' AND CHARACTER_LENGTH(ho_ten) <= 15;
-- Cách 2:
SELECT * FROM nhan_vien
WHERE substring_index(ho_ten, ' ', -1) LIKE 'H%' OR substring_index(ho_ten, ' ', -1) LIKE 'T%' 
OR substring_index(ho_ten, ' ', -1) LIKE 'K%' AND CHARACTER_LENGTH(ho_ten) <= 15;
/*
3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
*/

SELECT * FROM khach_hang;

SELECT * FROM khach_hang
WHERE ((YEAR(CURRENT_DATE) - YEAR(ngay_sinh)) BETWEEN 18 AND 50) 
AND dia_chi LIKE '%Đà Nẵng' OR dia_chi LIKE '%Quảng Trị';

-- Cách 2:
SELECT * FROM khach_hang
WHERE ((YEAR(CURRENT_DATE()) - YEAR(ngay_sinh)) BETWEEN 18 AND 50) 
AND substring_index(dia_chi, ',', -1) = 'Đà Nẵng' OR substring_index(dia_chi, ',', -1) = 'Quảng Trị';

SELECT DISTINCT substring_index(dia_chi, ',', -1) as 'Tỉnh' FROM khach_hang;

/*
4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
*/
SELECT ho_ten, COUNT(khach_hang.ma_loai_khach) AS so_lan_dat_phong FROM (khach_hang
INNER JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach)
INNER JOIN hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
WHERE ten_loai_khach = 'Diamond'
GROUP BY hop_dong.ma_khach_hang
ORDER BY so_lan_dat_phong;

/*
5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
(Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, 
với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. 
(những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
*/

SELECT * FROM hop_dong;

SELECT kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, 
hd.ngay_lam_hop_dong, hd.ngay_ket_thuc,
(IFNULL(tmp.chi_phi_thue,0) + SUM(IFNULL(hdct.so_luong, 0) * IFNULL(dvdk.gia, 0))) AS tong_tien
FROM (khach_hang as kh INNER JOIN loai_khach as lk ON kh.ma_loai_khach = lk.ma_loai_khach)
LEFT JOIN hop_dong as hd ON hd.ma_khach_hang = kh.ma_khach_hang
LEFT JOIN dich_vu as dv ON dv.ma_dich_vu = hd.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet as hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
LEFT JOIN  dich_vu_di_kem as dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
LEFT JOIN 
(SELECT kh1.ma_khach_hang, SUM(dv1.chi_phi_thue) as chi_phi_thue
FROM khach_hang as kh1 INNER JOIN hop_dong as hd1 ON kh1.ma_khach_hang = hd1.ma_khach_hang
INNER JOIN dich_vu as dv1 ON hd1.ma_dich_vu = dv1.ma_dich_vu
GROUP BY kh1.ma_khach_hang) as tmp ON tmp.ma_khach_hang = kh.ma_khach_hang
GROUP BY hd.ma_khach_hang;
	


SELECT kh.ma_khach_hang, kh.ho_ten, sum(hdct.so_luong * dvdk.gia)+ tmp.chi_phi_thue FROM khach_hang kh
LEFT JOIN hop_dong hd on hd.ma_khach_hang= kh.ma_khach_hang
LEFT JOIN dich_vu dv on dv.ma_dich_vu= hd.ma_hop_dong
LEFT JOIN hop_dong_chi_tiet hdct on hdct.ma_hop_dong= hd.ma_hop_dong
LEFT JOIN dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
LEFT JOIN 
(SELECT
	kh1.ma_khach_hang as ma_khach_hang,
	kh1.ho_ten, sum(dv1.chi_phi_thue) as chi_phi_thue
	FROM khach_hang kh1
	JOIN hop_dong hd1 on hd1.ma_khach_hang = kh1.ma_khach_hang
	JOIN dich_vu dv1 on dv1.ma_dich_vu= hd1.ma_hop_dong
	GROUP BY kh1.ma_khach_hang) tmp on tmp.ma_khach_hang = kh.ma_khach_hang
	GROUP BY hd.ma_khach_hang;

/*
6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
*/

SELECT dv.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu FROM dich_vu as dv
INNER JOIN loai_dich_vu as ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
INNER JOIN hop_dong as hd ON hd.ma_dich_vu = dv.ma_dich_vu
WHERE DATE(hd.ngay_lam_hop_dong) NOT BETWEEN '2021-01-01' AND '2021-03-31';

SELECT DATE(ngay_lam_hop_dong) FROM hop_dong;

/* 7.Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021. */

SELECT dv.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu FROM dich_vu as dv
INNER JOIN loai_dich_vu as ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
INNER JOIN hop_dong as hd ON hd.ma_dich_vu = dv.ma_dich_vu
WHERE YEAR(hd.ngay_lam_hop_dong) = 2020 AND YEAR(hd.ngay_lam_hop_dong) <> 2021
GROUP BY dv.ma_dich_vu;

/* 8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau. */
SELECT DISTINCT ho_ten FROM khach_hang;

-- C2
SELECT ho_ten FROM khach_hang GROUP BY ho_ten;

-- C3
SELECT ho_ten FROM khach_hang
UNION SELECT ho_ten FROM khach_hang;

/* 9.Thực hiện thống kê doanh thu theo tháng, 
nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
*/
SELECT tmp.`month`, IFNULL(hop_dong1.doanh_thu,0) FROM 
(SELECT 1 AS `month` 
UNION SELECT 2 AS `month` 
UNION SELECT 3 AS `month` 
UNION SELECT 4 AS `month` 
UNION SELECT 5 AS `month` 
UNION SELECT 6 AS `month` 
UNION SELECT 7 AS `month` 
UNION SELECT 8 AS `month` 
UNION SELECT 9 AS `month` 
UNION SELECT 10 AS `month` 
UNION SELECT 11 AS `month` 
UNION SELECT 12 AS `month`) AS tmp
LEFT JOIN  
(SELECT MONTH(ngay_lam_hop_dong) AS `month`, count(ma_khach_hang) as doanh_thu FROM hop_dong
			WHERE YEAR(ngay_lam_hop_dong) = '2021' 
            GROUP BY `month`) as hop_dong1 ON tmp.`month` = hop_dong1.`month`;
            
/* 10.Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
(được tính dựa trên việc sum so_luong ở dich_vu_di_kem).*/

SELECT hd.ma_hop_dong, count(hdct.ma_hop_dong_chi_tiet) FROM hop_dong as hd
LEFT JOIN hop_dong_chi_tiet as hdct
ON hd.ma_hop_dong = hdct.ma_hop_dong
GROUP BY hd.ma_hop_dong;

/* 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” 
và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
*/
SELECT 
    dvdk.*
FROM
    dich_vu_di_kem AS dvdk
        INNER JOIN
    hop_dong_chi_tiet AS hdct ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
        INNER JOIN
    hop_dong AS hd ON hd.ma_hop_dong = hdct.ma_hop_dong
        INNER JOIN
    khach_hang AS kh ON hd.ma_khach_hang = kh.ma_khach_hang
        INNER JOIN
    loai_khach AS lk ON lk.ma_loai_khach = kh.ma_loai_khach
WHERE
    lk.ten_loai_khach = 'Diamond'
        AND (kh.dia_chi LIKE '%Vinh'
        OR kh.dia_chi LIKE '%Quảng Ngãi')
 
 /*
 12.Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng),
 ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc 
 của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020
 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021. */
 
 SELECT hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu, COUNT(ma_hop_dong_chi_tiet) as so_luong_dich_vu_di_kem FROM hop_dong as hd 
 JOIN khach_hang as kh ON kh.ma_khach_hang = hd.ma_khach_hang
 JOIN nhan_vien as nv ON nv.ma_nhan_vien = hd.ma_nhan_vien
 JOIN dich_vu as dv ON dv.ma_dich_vu = hd.ma_dich_vu
 JOIN hop_dong_chi_tiet as hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
 WHERE (hd.ngay_lam_hop_dong BETWEEN '2020-10-1' AND '2020-12-31') 
		AND (hd.ngay_lam_hop_dong NOT BETWEEN '2021-01-1' AND '2020-06-30') 
 GROUP BY hd.ma_hop_dong;
 
 /* 
 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
 (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
 */
 
SELECT dvdk.*, count(dvdk.ma_dich_vu_di_kem) as so_lan_su_dung FROM dich_vu_di_kem as dvdk
INNER JOIN hop_dong_chi_tiet as hdct
ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
WHERE so_lan_su_dung >= 1
GROUP BY dvdk.ma_dich_vu_di_kem;
ALL (SELECT count(dvdk.ma_dich_vu_di_kem) FROM dich_vu_di_kem as dvdk
INNER JOIN hop_dong_chi_tiet as hdct
ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY dvdk.ma_dich_vu_di_kem);
-- ALL (SELECT MAX(tmp.so_lan_su_dung) FROM tmp);




