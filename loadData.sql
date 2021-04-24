\c db_deptos;


INSERT INTO public.comuna (nombre, provincia)
VALUES ('Cerrillos','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Cerro Navia','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Conchali','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('El Bosque','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Estacion Central','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Huechuraba','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Independencia','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('La Cisterna','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('La Florida','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('La Granja','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('La Pintana','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('La Reina','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Las Condes','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Lo Barnechea','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Lo Espejo','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Lo Prado','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Macul','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Maipu','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Nunoa','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Pedro Aguirre Cerda','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Penalolen','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Providencia','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Pudahuel','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Quilicura','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Quinta Normal','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Recoleta','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Renca','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('San Joaquin','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('San Miguel','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('San Ramon','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Santiago','Santiago');
INSERT INTO public.comuna (nombre, provincia)
VALUES ('Vitacura','Santiago');

/*administrador (8)*/
INSERT INTO administrador(nombre, rut, email, telefono)
VALUES('Oliva Vergara','21540887-6','silyas_milano3@jimong.com','48251685');
INSERT INTO administrador(nombre, rut, email, telefono)
VALUES('Pepe Morilla','13554694-1','5ayman.ayman.19v@billseo.com','25614822');
INSERT INTO administrador(nombre, rut, email, telefono)
VALUES('Angustias Salinas','17706247-2','bthul@miekering.buzz','55224153');
INSERT INTO administrador(nombre, rut, email, telefono)
VALUES('Fatima Ribes','22842203-7','geleanorr@filel.site','89215423');
INSERT INTO administrador(nombre, rut, email, telefono)
VALUES('Berta Cardenas','21126639-2','flashandrah@googl.win','20032101');
INSERT INTO administrador(nombre, rut, email, telefono)
VALUES('Tatiana Llanos','14691511-6','4bassamziad1993f@cakk.us','78412211');
INSERT INTO administrador(nombre, rut, email, telefono)
VALUES('Adolfo Mata','23565443-1','hamza-r@convitco.com','66524113');
INSERT INTO administrador(nombre, rut, email, telefono)
VALUES('Cipriano Valdes','15375724-0','uanass@humsito.com','58552112');

/*edificio (16)*/
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre A1',23,'Avenida Pedro De Valdivia',1,5);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre B1',504,'Calle Villaseca',1,8);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre C1',778,'Calle Larrain',13,7);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre D1',3222,'Calle Castellón',2,6);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre A2',211,'Avenida Gran Av.josé M.carrera',4,5);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre B2',20,'Pasaje Aurora De Chile',6,4);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre C2',5432,'Calle Padre Tadeo',4,3);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre D2',433,'Avenida Vitacura',3,2);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre A3',2001,'Calle Laguna San Rafael',11,1);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre B3',4345,'Avenida Presidente Kennedy',12,6);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre C3',34,'Avenida Francisco Bilbao',10,6);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre D3',875,'Calle San Diego',9,8);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre A4',565,'Avenida Tomás Moro',4,4);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre B4',653,'Pasaje 48',5,6);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre C4',8987,'Avenida Apoquindo',4,2);
INSERT INTO edificio(nombre_edificio, numeracion, direccion, comuna_id, administrador_id)
VALUES('Torre D4',123,'Calle Martín De Poveda',3,1);

/*gasto_edificio (64)*/
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',100000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',400000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Reparaciones',300000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',130000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',400000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',410000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',400000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',420000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',600000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Reparaciones',800000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',400000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',600000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',420000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',600000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',700000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Reparaciones',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',390000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',700000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',100000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',400000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Reparaciones',300000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',130000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',400000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',410000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',400000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',420000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',600000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Reparaciones',800000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',400000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',600000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',420000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',600000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',700000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Reparaciones',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',390000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',700000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',100000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',400000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Reparaciones',300000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',130000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',400000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',410000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',400000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',420000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',500000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Seguridad',600000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Reparaciones',800000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Mantención',400000);
INSERT INTO gasto_edificio(tipo, monto)
VALUES('Limpieza',500000);



/*pago_gasto_edificio (64)*/
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',1,1);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',1,2);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',1,3);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',1,4);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',2,5);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',2,6);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',2,7);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',2,8);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',3,9);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',3,10);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',3,11);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',3,12);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',4,13);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',4,14);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',4,15);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',4,16);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',5,17);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',5,18);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',5,19);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',5,20);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',6,21);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',6,22);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',6,23);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',6,24);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',7,25);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',7,26);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',7,27);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',7,28);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',8,29);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',8,30);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',8,31);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',8,32);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',9,33);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',9,34);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',9,35);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',9,36);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',10,37);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',10,38);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',10,39);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',10,40);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',11,41);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',11,42);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',11,43);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',11,44);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',12,45);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',12,46);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',12,47);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',12,48);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',13,49);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',13,50);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',13,51);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',13,52);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',14,53);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',14,54);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',14,55);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',14,56);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',15,57);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',15,58);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',15,59);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',15,60);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-08-01 12:00:00','2020-08-30 12:00:00',16,62);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-09-01 12:00:00','2020-09-30 12:00:00',16,62);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-10-01 12:00:00','2020-10-30 12:00:00',16,63);
INSERT INTO pago_gasto_edificio(fecha_inicio, fecha_termino, edificio_id, gasto_edificio_id)
VALUES('2020-11-01 12:00:00','2020-11-30 12:00:00',16,64);


