use quan_ly_ban_hang;

-- Thêm dữ liệu vào bảng customer
INSERT INTO customer(`name`, age)
VALUES ('Minh Quan', 10),
	   ('Ngoc Oanh', 20),
       ('Hong Ha', 50);
SELECT * FROM customer;

-- Thêm dữ liệu vào bảng Order
INSERT INTO `order`(customer_id, `date`, total_price)
VALUES (1, '2006/03/21', null);
INSERT INTO `order`(customer_id, `date`, total_price)
VALUES (2, '2006/03/23', null),
	   (1, '2003/03/16', null);
SELECT * FROM `order`;

-- Thêm dữ liệu vào bảng product
INSERT INTO product(`name`, price)
VALUES ('May Giat', 3),
	   ('Tu Lanh', 5),
       ('Dieu Hoa', 7),
       ('Quat', 1),
       ('Bep Dien', 2);
SELECT * FROM product;

-- Thêm dữ lệu vào bảng order_detail
INSERT INTO order_detail
VALUES (1, 1, 3),
	   (1, 3, 7),
       (1, 4, 2),
       (2, 1, 1),
       (3, 1, 8),
       (2, 5, 4),
       (2, 3, 3);
SELECT * FROM order_detail;

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT id, `date`, total_price FROM `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách

SELECT c.`name`, p.`name` FROM customer as c
INNER JOIN `order` as o ON c.id = o.customer_id
INNER JOIN `order_detail` as od ON o.id = od.order_id
INNER JOIN product as p ON p.id = od.product_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT c.`name` FROM customer as c
WHERE c.`name` NOT IN (SELECT c1.`name` FROM customer as c1
INNER JOIN `order` as o ON c1.id = o.customer_id
INNER JOIN `order_detail` as od ON o.id = od.order_id
INNER JOIN product as p ON p.id = od.product_id);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)
SELECT o.id, o.`date`, sum(p.price * quantity) as total_price FROM `order` as o
INNER JOIN order_detail as od ON od.order_id = o.id
INNER JOIN product as p ON p.id = od.product_id
GROUP BY o.id;
