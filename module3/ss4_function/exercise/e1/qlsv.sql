USE quan_ly_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
SELECT * FROM `subject`
WHERE credit >= ALL (SELECT credit FROM `subject`);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
SELECT `subject`.*, mark FROM `subject` INNER JOIN mark ON `subject`.id = mark.subject_id
WHERE mark >= ALL (SELECT mark from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
SELECT student.*, AVG(mark) as DTB FROM student
INNER JOIN mark ON student.id = mark.student_id
GROUP BY student.id
ORDER BY DTB DESC;