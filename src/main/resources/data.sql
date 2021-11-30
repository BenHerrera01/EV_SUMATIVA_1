INSERT INTO categorias (id, created_at, nombre, updated_at) VALUES
	(1, '2021-11-27 17:20:09.482000', 'Electro', NULL),
	(2, '2021-11-27 17:24:56.771000', 'Deportes', NULL),
	(3, '2021-11-28 00:13:47.819000', 'Ropa', NULL);


INSERT INTO productos (id, descripcion, nombre, precio, marca, created_at, updated_at) VALUES
	(4, 'Monitor gamer', 'Monitor', 109000, 'LG', NULL, NULL),
	(7, 'Headset ', 'Audifonos', 69990, 'Sennheiser', NULL, NULL),
	(8, 'Trotadora electrica', 'Trotadora', 300000, 'Atletis', '2021-11-27 17:28:35.421000', NULL),
	(9, 'Polera deportiva', 'Polera', 12000, 'Nike', '2021-11-28 00:14:18.328000', NULL),
	(10, 'mancuerna de metal', 'Mancuerna', 67990, 'ellos', '2021-11-29 15:41:51.470000', NULL);

INSERT INTO productos_categorias (producto_id, categoria_id) VALUES
	(4, 1),
	(7, 1),
	(8, 1),
	(8, 2),
	(9, 2),
	(9, 3),
	(10, 2);
