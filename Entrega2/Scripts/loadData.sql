\c voluntariado;


/* Dogs Prueba (3)*/
INSERT INTO public.dog (name, descrip,location)
	VALUES
	('Chamullo','Manso',ST_GeomFromText('POINT(-72.928177 -41.474096)',4326)),
	('Pedro','jugueton',ST_GeomFromText('POINT(-71.080 -33.941)',4326)),
	('Pascal',NULL,ST_GeomFromText('POINT( -72.413 -35.347)',4326));

/* voluntario (20)*/
INSERT INTO public.voluntario (nombre, rut, email, telefono,location)
	VALUES
	('Hector Campos','20467238-5','tbrahim.amin.9630@gmail.com','25252655',ST_GeomFromText('POINT(-69.111 -22.699)',4326)),
	('Edgar Ruiz','10134071-6','jmalik1127c@live.cl','11225443',ST_GeomFromText('POINT(-69.968 -23.255)',4326)),
	('Arturo Garrido','22420886-3','cfilipe@googleappsmail.com','88451111',ST_GeomFromText('POINT( -65.360 -24.254)',4326)),
	('Dorotea Morales','8190374-3','4roka@hotmail.cl','25202222',ST_GeomFromText('POINT( -65.360 -24.254)',4326)),
	('Asunción Moreno','20595637-9','npetq@gmail.com','65565221',ST_GeomFromText('POINT( -70.605 -26.351)',4326)),
	('Reinaldo Mendez','9822228-6','pmeera.meen@hotmail.cl','85545451',ST_GeomFromText('POINT( -70.331 -27.036)',4326)),
	('Raul Suarez','16267818-3','zasdl593@dtecet.com','12125414',ST_GeomFromText('POINT( -70.777 -28.572)',4326)),
	('Juan Ferrer','12339396-1','4achraf_2000@dunsoi.com','14526385',ST_GeomFromText('POINT( -71.242 -29.905)',4326)),
	('Fermin Pascual','12659418-6','jhamalogo@webmhouse.com','25112441',ST_GeomFromText('POINT( -70.681 -30.037)',4326)),
	('Alberto Esteban','18864964-5','zalooshalsmawi9@rackabzar.com','55212332',ST_GeomFromText('POINT( -71.475 -30.285)',4326)),
	('Simón Perez','24936172-0','rbruno.b@poki.us','85554411',ST_GeomFromText('POINT( -71.083 -30.229)',4326)),
	('Marina Mora','6826443-k','isubin@audiophileusa.net','66332214',ST_GeomFromText('POINT( -71.214 -30.615)',4326)),
	('Almudena Hidalgo','15652736-k','0moham@rifo.ru','65252515',ST_GeomFromText('POINT( -73.216 -39.864)',4326)),
	('Manuela Ruiz','17053702-5','9rbnm@horizen.cf','78452102',ST_GeomFromText('POINT( -72.811 -39.870)',4326)),
	('Cirino Gutierrez','18186122-3','urehammansourrh@tubidu.com','56322412',ST_GeomFromText('POINT( -72.853 -40.082)',4326)),
	('Rufo Jiménez','14885956-6','wzaidjnpn@greendike.com','25143214',ST_GeomFromText('POINT( -73.051 -40.312)',4326)),
	('Ricardo Saez','15989338-3','2bihnam.attallahr@litrt.site','85454512',ST_GeomFromText('POINT( -72.980 -40.425)',4326)),
	('Ramiro Méndez','18569098-9','jerdenechuluun_eu@klttec.com','62625145',ST_GeomFromText('POINT( -73.142 -40.593)',4326)),
	('Efren Gomez','19132415-3','pjoce_fs22w@freeallapp.com','25145555',ST_GeomFromText('POINT( -73.050 -41.124)',4326)),
	('Eulalia Saez','13340059-1','anaka@cuenmex.com','20332000',ST_GeomFromText('POINT( -73.050 -41.124)',4326));
	

/* habilidad (31)*/
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
	('Uso de maquinaria'),
	('Rescate en altura'),
	('Tener Auto'),
	('Poseer condicion fisica'),
	('Capacitacion'),
	('Poseer equipamiento de Bombero'),
	('Poseer equipamiento de Rescate'),
	('Poseer equipamiento de Supervivencia'),
	('Vacunado contra el tetanos'),
	('Afinidad con los animales'),
	('Tener jaulas para mascotas'),
	('Capacidad para dirigir'),
	('Liderazgo'),
	('Responsabilidad'),
	('Fuerza de voluntad'),
	('Capacidad de organizacion'),
	('Creatividad'),
	('Trabajar en espacios elevados'),
	('Mantener la calma'),
	('Comunicacion efectiva');

/* institucion (3)*/
INSERT INTO public.institucion (nombre, descrip)
	VALUES
	('Bomberos de Chile','Emergencia y rescates...'),
	('Instituto de Emergencia y Rescate','Emergencia y rescates...'),
	('K-SAR Chile','Busqueda y rescate con perros...');

/* estado_tarea (3)*/
INSERT INTO public.estado_tarea (descrip)
	VALUES
	('Aceptada'),
	('Rechadazada'),
	('Pendiente'),
	('Finalizado');
	

/* tarea (25)*/
INSERT INTO public.tarea(nombre, descrip, vol_requeridos, finicio, ffin, id_emergencia, id_estado,location)
	VALUES
	('Tarea 1' ,'Limpieza de escombros' ,3,'2021-05-23',NULL,1,3,ST_GeomFromText('POINT(-72.768 -36.345)',4326)),
	('Tarea 2' ,'Manejo de maquinaria' ,4,'2021-05-23',NULL,1,3,ST_GeomFromText('POINT(-72.935 -36.579)',4326)),
	('Tarea 3' ,'Busqueda terrestre' ,3,'2021-05-23',NULL,1,3,ST_GeomFromText('POINT( -73.015 -36.617)',4326)),
	('Tarea 4' ,'Busqueda de sobrevivientes ' ,3,'2021-05-23',NULL,1,3,ST_GeomFromText('POINT( -73.015 -36.617)',4326)),
	('Tarea 5' ,'Coordinacion de personal',1,'2021-05-23',NULL,1,3,ST_GeomFromText('POINT( -73.049 -36.832)',4326)),
	('Tarea 6' ,'Controlar incendios',3,'2021-05-23',NULL,2,3,ST_GeomFromText('POINT(-70.746 -33.683)',4326)),
	('Tarea 7' ,'Preparacion de equipos',2,'2021-05-23',NULL,2,3,ST_GeomFromText('POINT(-70.546 -33.283)',4326)),
	('Tarea 8' ,'Busqueda de supervivientes' ,2,'2021-05-20',NULL,2,3,ST_GeomFromText('POINT(-70.846 -33.283)',4326)),
	('Tarea 9' ,'proveer  primeros auxilios' ,3,'2021-05-20',NULL,2,3,ST_GeomFromText('POINT(-70.946 -33.383)',4326)),
	('Tarea 10' ,'Apagar amago de incendio' ,4,'2021-05-20',NULL,2,3,ST_GeomFromText('POINT(-70.546 -33.383)',4326)),
	('Tarea 11' ,'Limpieza de escombros' ,1,'2021-03-14',NULL,3,3,ST_GeomFromText('POINT(-72.945 -36.623)',4326)),
	('Tarea 12' ,'Busqueda maritima' ,1,'2021-03-14',NULL,3,3,ST_GeomFromText('POINT(-73.188 -36.702)',4326)),
	('Tarea 13' ,'Coordinacion de busqueda maritima' ,1,'2021-03-14',NULL,3,3,ST_GeomFromText('POINT(-73.079 -36.780)',4326)),
	('Tarea 14' ,'Coordinacion de recursos' ,1,'2021-03-14',NULL,3,3,ST_GeomFromText('POINT(-73.044 -36.805)',4326)),
	('Tarea 15' ,'Aletar a la poblacion' ,1,'2021-03-14',NULL,3,3,ST_GeomFromText('POINT(-73.158 -37.018)',4326)),
	('Tarea 16' ,'Aletar a la poblacion' ,1,'2021-03-14',NULL,4,3,ST_GeomFromText('POINT(-72.222 -39.282)',4326)),
	('Tarea 17' ,'Busqueda de supervivientes' ,1,'2021-03-14',NULL,4,3,ST_GeomFromText('POINT(-72.106 -39.434)',4326)),
	('Tarea 18' ,'Primeros auxilios' ,1,'2021-03-14',NULL,4,3,ST_GeomFromText('POINT(-72.154 -39.484)',4326)),
	('Tarea 19' ,'Evacuacion de la poblacion' ,1,'2021-03-14',NULL,4,3,ST_GeomFromText('POINT(-71.957 -39.290)',4326)),
	('Tarea 20' ,'Controlar posibles incendios' ,1,'2021-03-14',NULL,4,3,ST_GeomFromText('POINT(-71.917 -39.356)',4326)),
	('Tarea 21' ,'Evacuar a la poblacion' ,1,'2021-03-14',NULL,5,3,ST_GeomFromText('POINT(-73.215 -39.837)',4326)),
	('Tarea 22' ,'Busqueda de supervivientes' ,1,'2021-03-14',NULL,5,3,ST_GeomFromText('POINT(-73.221 -39.848)',4326)),
	('Tarea 23' ,'Creacion de campamentos temporales' ,1,'2021-03-14',NULL,5,3,ST_GeomFromText('POINT(-73.226 -39.782)',4326)),
	('Tarea 24' ,'Coordinacion de equipos de busqueda' ,1,'2021-03-14',NULL,5,3,ST_GeomFromText('POINT(-73.186 -39.880)',4326)),
	('Tarea 25','Dar RCP',3,'2021-03-14',NULL,5,3,ST_GeomFromText('POINT(-73.223 -39.847)',4326));
	

/* ranking (20)*/
INSERT INTO public.ranking (puntaje, id_voluntario, id_tarea)
	VALUES
	(3,1,9),
	(2,2,10),
	(1,3,1),
	(0,4,2),
	(2,5,3),
	(2,6,4),
	(3,7,5),
	(1,8,1),
	(0,9,2),
	(3,10,6),
	(1,11,3),
	(2,12,4),
	(3,13,5),
	(2,14,6),
	(1,15,7),
	(1,16,8),
	(2,17,7),
	(3,18,8),
	(2,19,9),
	(3,20,3);

/* vol_tarea (20)*/
INSERT INTO public.vol_tarea (id_voluntario, flg_participa, id_estado, id_tarea)
	VALUES
	(1,'true',3,1),
	(2,'true',3,1),
	(3,'true',3,1),
	(4,'true',3,2),
	(5,'true',3,2),
	(5,'true',3,3),
	(7,'true',3,4),
	(8,'true',1,5),
	(9,'true',3,6),
	(10,'true',3,7),
	(11,'true',3,7),
	(12,'true',3,8),
	(13,'true',3,3),
	(14,'true',3,2),
	(15,'true',3,2),
	(16,'true',3,4),
	(17,'true',3,5),
	(18,'true',3,6),
	(19,'true',3,7),
	(20,'true',3,8);

/* vol_habilidad (30)*/
INSERT INTO public.vol_habilidad (id_voluntario, id_habilidad)
	VALUES
	(1,1),
	(2,2),
	(3,3),
	(4,4),
	(5,5),
	(6,6),
	(7,7),
	(8,8),
	(9,1),
	(10,2),
	(11,3),
	(12,4),
	(13,5),
	(14,6),
	(15,7),
	(16,8),
	(17,1),
	(18,2),
	(19,3),
	(20,4);

/* tarea_habilidad (x)*/
INSERT INTO public.tarea_habilidad (id_tarea, id_habilidad)
	VALUES
	(1,14),
	(1,15),
	(1,16),
	(1,25),
	(1,30),
	(2,8),
	(2,12),
	(2,15),
	(2,25),
	(3,1),
	(3,9),
	(3,10),
	(3,14),
	(3,15),
	(3,16),
	(3,20),
	(3,21),
	(3,22),
	(3,23),
	(3,24),
	(3,25),
	(3,26),
	(3,30),
	(4,1),
	(4,2),
	(4,9),
	(4,10),
	(4,14),
	(4,15),
	(4,16),
	(4,18),
	(4,19),
	(4,20),
	(4,21),
	(4,22),
	(4,23),
	(4,24),
	(4,25),
	(5,16),
	(5,24),
	(5,25),
	(5,26),
	(5,27),
	(5,28),
	(5,30),
	(5,31),
	(6,7),
	(6,15),
	(6,16),
	(6,17),
	(6,31),
	(6,30),
	(6,26),
	(7,24),
	(7,25),
	(7,26),
	(7,28),
	(7,30),
	(7,31),
	(7,16),
	(8,1),
	(8,2),
	(8,9),
	(8,10),
	(8,14),
	(8,15),
	(8,16),
	(8,18),
	(8,19),
	(8,20),
	(8,21),
	(8,22),
	(8,23),
	(8,24),
	(8,25),
	(9,1),
	(9,16),
	(9,24),
	(9,25),
	(9,26),
	(9,30),
	(10,7),
	(10,15),
	(10,16),
	(10,24),
	(10,25),
	(10,26),
	(11,14),
	(11,15),
	(11,16),
	(11,25),
	(11,30),
	(12,1),
	(12,3),
	(12,5),
	(12,6),
	(12,18),
	(12,24),
	(12,25),
	(13,16),
	(13,24),
	(13,25),
	(13,26),
	(13,27),
	(13,30),
	(13,31),
	(14,16),
	(14,23),
	(14,24),
	(14,25),
	(14,26),
	(14,27),
	(15,16),
	(15,23),
	(15,24),
	(15,25),
	(15,31),
	(16,28),
	(16,16),
	(16,23),
	(16,24),
	(16,25),
	(16,31),
	(16,28),
	(17,1),
	(17,2),
	(17,18),
	(17,19),
	(17,25),
	(17,24),
	(17,26),
	(18,1),
	(18,16),
	(18,26),
	(18,30),
	(19,16),
	(19,24),
	(19,25),
	(19,27),
	(19,30),
	(19,31),
	(20,1),
	(20,1),
	(20,1),
	(20,1),
	(20,1),
	(20,1),
	(20,1),
	(20,1),
	(20,1),
	(20,1),
	(20,1),
	(20,1),
	(20,1),
	(20,1),
	(21,16),
	(21,24),
	(21,25),
	(21,27),
	(21,30),
	(21,31),
	(22,1),
	(22,2),
	(22,18),
	(22,19),
	(22,25),
	(22,24),
	(22,26),
	(23,1),
	(23,8),
	(23,12),
	(23,14),
	(23,15),
	(24,24),
	(24,25),
	(24,26),
	(24,31),
	(25,1),
	(25,5),
	(25,2),
	(25,16),
	(25,24),
	(25,25);
	


/* emergencia (5)*/
INSERT INTO public.emergencia (nombre, descrip, finicio, ffin, id_institucion,location)
	VALUES
	('Terremoto','Sismo de mediana a alta magnitud en las cercanias','2021-05-23','2020-05-28',1,ST_GeomFromText('POINT(-73.062 -35.897)',4326)),
	('Incendio','Incendio que cubre varias manzanas a la redonda','2021-05-20','2020-05-24',2,ST_GeomFromText('POINT(-70.646 -33.483)',4326)),
	('Tsunami','Alerta Tsunami decretada por la onemi','2021-03-14','2020-03-16',3,ST_GeomFromText('POINT( -72.002 -34.394)',4326)),
	('Erupcion de volcan','Erupcion de volcan dentro de la zona','2021-05-21','2020-05-26',1,ST_GeomFromText('POINT( -71.93963539779801 -39.41966956602668)',4326)),
	('Inundacion','Comunidad devastada por una inundacion','2021-04-10','2020-04-16',2,ST_GeomFromText('POINT( -73.247 -39.836)',4326));

/* eme_habilidad (17)*/
INSERT INTO public.eme_habilidad (id_emergencia, id_habilidad)
	VALUES
	(1,1),
	(1,4),
	(1,6),
	(1,5),
	(1,8),
	(2,3),
	(2,6),
	(2,1),
	(3,1),
	(3,2),
	(3,6),
	(3,8),
	(4,1),
	(4,3),
	(4,7),
	(5,6),
	(5,8);


--- procedimiento

CREATE OR REPLACE PROCEDURE public.cerrar_tarea(
	idt integer,
	idv integer)
AS $$
DECLARE
		IDT  ALIAS FOR $1 ;
		IDV  ALIAS FOR $2;
        V_COUNT_TAREA INTEGER;
        V_COUNT_VOL INTEGER;
        V_COUNT_VOL_FINALIZA INTEGER;

BEGIN

-- lo primeo a realizar es actualizar la tabla de vol_tarea 
UPDATE vol_tarea
    SET id_estado = 4
    WHERE id_tarea = IDT
    AND id_voluntario = IDV;

-- Con esto vemos si la tarea se encuentre o no en proceso --
SELECT COUNT(*) INTO V_COUNT_TAREA
FROM tarea as t
WHERE t.id = IDT AND id_estado = 3;

Raise Notice 'V_COUNT_TAREA es: %',V_COUNT_TAREA;

IF V_COUNT_TAREA !=1 then
    raise notice 'La tarea no se encuentra en proceso';
ELSE
    raise notice 'a';

-- participantes totales en la tarea entregada

SELECT COUNT(*) INTO V_COUNT_VOL
FROM vol_tarea as vt
WHERE vt.id_tarea = IDT AND flg_participa = true;

Raise Notice 'V_COUNT_VOL es: %',V_COUNT_VOL;

--Numero de participantes que cerraron la tarea 
SELECT COUNT(*) INTO V_COUNT_VOL_FINALIZA
FROM vol_tarea as vt
WHERE vt.id_tarea = IDT AND flg_participa = true AND id_estado = 4;

Raise Notice 'V_COUNT_VOL_FINALIZA es: %',V_COUNT_VOL_FINALIZA;

IF V_COUNT_VOL = V_COUNT_VOL_FINALIZA then
    -- Si coinciden cerramos
    raise notice 'Tarea con id: % cerrada ',IDT;
    UPDATE tarea 
        SET 
        id_estado = 4,
        ffin = NOW()::timestamp
        WHERE id = IDT;
ELSE
    -- Sino no, no cerramos
    raise notice 'Tarea aún no cerrada por todos, aun no se puede cerrar';
END IF;
END IF;
END;
$$ LANGUAGE 'plpgsql';