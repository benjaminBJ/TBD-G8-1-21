\c voluntariado;

/* Dogs Prueba (3)*/
INSERT INTO public.dog (name, descrip,location)
	VALUES
	('Chamullo','Manso',ST_GeomFromText('POINT(-72.928177 -41.474096)',4326)),
	('Pedro','jugueton',ST_GeomFromText('POINT(-71.080 -33.941)',4326)),
	('Pascal',NULL,ST_GeomFromText('POINT( -72.413 -35.347)',4326));

/* voluntario0 */
INSERT INTO public.voluntario0 (nombre, rut, email, telefono, tabla)
	VALUES
	('Ramiro Méndez','18569098-9','jerdenechuluun_eu@klttec.com','62625145','voluntario0'),
	('Efren Gomez','19132415-3','pjoce_fs22w@freeallapp.com','25145555','voluntario0'),
	('Eulalia Saez','13340059-1','anaka@cuenmex.com','20332000','voluntario0');

/* voluntario0 */
INSERT INTO public.voluntario1 (nombre, rut, email, telefono, tabla)
	VALUES
	('Marina Mora','6826443-k','isubin@audiophileusa.net','66332214','voluntario1'),
	('Almudena Hidalgo','15652736-k','0moham@rifo.ru','65252515','voluntario1'),
	('Manuela Ruiz','17053702-5','9rbnm@horizen.cf','78452102','voluntario1');

/* voluntario2 */
INSERT INTO public.voluntario2 (nombre, rut, email, telefono, tabla)
	VALUES
	('Cirino Gutierrez','18186122-3','urehammansourrh@tubidu.com','56322412','voluntario2'),
	('Rufo Jiménez','14885956-6','wzaidjnpn@greendike.com','25143214','voluntario2'),
	('Ricardo Saez','15989338-3','2bihnam.attallahr@litrt.site','85454512','voluntario2');


/* habilidad */
INSERT INTO public.habilidad(descrip)
	VALUES
	('Primeros auxilios'),
	('Tener entrenamiento de Rescate'),
	('Tener entrenamiento de Buceo'),
	('Tener entrenamiento de Alpinismo'),
	('Tener entrenamiento de Busqueda'),
	('Rescate acuatico'),
	('Manejo de incendios'),
	('Excavacion'),
	('Busqueda con perros'),
	('Preparacion canina'),
	('Equipo de perros de rescate '),
	('Uso de maquinaria');
	

/* vol_habilidad0 */
INSERT INTO public.vol_habilidad0 (id_voluntario, tabla_voluntario, id_habilidad, tabla)
	VALUES
	(1,'voluntario0',1,'vol_habilidad0'),
	(1,'voluntario1',2,'vol_habilidad0'),
	(2,'voluntario0',2,'vol_habilidad0'),
	(2,'voluntario1',3,'vol_habilidad0'),
	(3,'voluntario0',1,'vol_habilidad0'),
	(3,'voluntario1',2,'vol_habilidad0'),
	(3,'voluntario2',3,'vol_habilidad0');

/* vol_habilidad1 */
INSERT INTO public.vol_habilidad1 (id_voluntario, tabla_voluntario, id_habilidad, tabla)
	VALUES
	(1,'voluntario0',4,'vol_habilidad1'),
	(2,'voluntario0',5,'vol_habilidad1'),
	(3,'voluntario0',6,'vol_habilidad1'),
	(3,'voluntario1',7,'vol_habilidad1');

/* vol_habilidad2 */
INSERT INTO public.vol_habilidad2 (id_voluntario, tabla_voluntario, id_habilidad, tabla)
	VALUES
	(1,'voluntario0',8,'vol_habilidad2'),
	(2,'voluntario1',9,'vol_habilidad2'),
	(3,'voluntario2',10,'vol_habilidad2');
