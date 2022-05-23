USE quan_ly_sinh_vien;

-- Hiển thị số lượng sinh viên ở từng nơi
SELECT address, COUNT(*) FROM student
GROUP BY address;

-- Tính điểm trung bình các môn học của mỗi học viên
SELECT student.*, AVG(mark) as DTB FROM student
INNER JOIN mark ON student.id = mark.student_id
GROUP BY student.id;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
SELECT student.*, AVG(mark) as DTB FROM student
INNER JOIN mark ON student.id = mark.student_id
GROUP BY student.id
HAVING AVG(mark) > 15;

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
SELECT student.*, AVG(mark) as DTB FROM student
INNER JOIN mark ON student.id = mark.student_id
GROUP BY student.id
HAVING DTB >= ALL (SELECT AVG(mark) FROM mark GROUP BY mark.student_id);