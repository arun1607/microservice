INSERT INTO category (description, name)
VALUES
  ('All kind of books', 'Book'),
  ('All kind of electronics', 'Electronics'),
  ('All kind of home appliances', 'Home appliances');

INSERT INTO product (id, description, name, category_id)
VALUES
  (1, 'Electric Iron', 'Phillips Express', 2),
  (2, 'Electric Juicer Grinder', 'Maharaja Whiteline', 3),
  (3, 'Electric Coffee Maker', 'Nova Instant', 3);

INSERT INTO vendor (id, email, name)
VALUES
  (1, 'phillips@hostmail.com', 'Phillips India Pvt Ltd'),
  (2, 'maharaja@hostmail.com', 'Maharaja Electronics Pvt Ltd');

INSERT INTO product_detail (id, color, manufacturing_date, model_number, product_id, vendor_id)
VALUES
  (4, 'White', '2013-09-23 00:00:00', 'WH-450', 1, 1),
  (5, 'White', '2013-03-20 00:00:00', 'MX-300', 2, 2);

INSERT INTO product_pricing (id, discount, price, product_id)
VALUES
  (1, 0, 800, 1),
  (2, 0, 3000, 2),
  (3, 0, 500, 3);
  
  INSERT INTO inventory_item (id, quantity, product_id)
VALUES
	(1, 5000, 1),
	(2, 3000, 2),
	(3, 2000, 3);








