USE quan_ly_sinh_vien;

-- Hiển thị danh sách tất cả các học viên
SELECT * FROM student;

-- Hiển thị danh sách các học viên đang theo học.
SELECT * FROM student
WHERE `status` = TRUE;

-- Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
SELECT *
FROM subject
WHERE credit < 10;

-- Hiển thị danh sách học viên lớp A1
SELECT student.* FROM student
INNER JOIN class ON class.id = student.id
WHERE class.`name` = 'A1';

-- Hiển thị điểm môn CF của các học viên.
SELECT student.`name`, mark.mark FROM student
INNER JOIN mark ON student.id = mark.student_id
INNER JOIN `subject` ON subject.id = mark.subject_id
AND `subject`.`name` = 'CF';

