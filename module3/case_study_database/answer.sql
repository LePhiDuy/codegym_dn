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
hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hdct.ma_hop_dong_chi_tiet,
(IFNULL(dv.chi_phi_thue,0) + IFNULL(hdct.so_luong, 0) * IFNULL(dvdk.gia, 0)) AS tong_tien
FROM (khach_hang as kh INNER JOIN loai_khach as lk ON kh.ma_loai_khach = lk.ma_loai_khach)
LEFT JOIN hop_dong as hd ON hd.ma_khach_hang = kh.ma_khach_hang
LEFT JOIN dich_vu as dv ON dv.ma_dich_vu = hd.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet as hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
LEFT JOIN  dich_vu_di_kem as dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem;


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
    
    
