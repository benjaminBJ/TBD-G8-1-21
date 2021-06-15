\c voluntariado;


/* Dogs Prueba (5)*/
INSERT INTO public.dog (name, descrip,location)
	VALUES
	('Chamullo','Manso',ST_GeomFromText('POINT(-72.928177 -41.474096)',4326)),
	('Pedro','jugueton',ST_GeomFromText('POINT(-71.080 -33.941)',4326)),
	('Pascal',NULL,ST_GeomFromText('POINT( -72.413 -35.347)',4326));

/* voluntario (30)*/
INSERT INTO public.voluntario (nombre, rut, email, telefono,location)
	VALUES
	('Hector Campos','20467238-5','tbrahim.amin.9630@gmail.com','25252655',ST_GeomFromText('POINT(-72.928177 -41.474096)',4326)),
	('Edgar Ruiz','10134071-6','jmalik1127c@live.cl','11225443',ST_GeomFromText('POINT(-71.080 -33.941)',4326)),
	('Arturo Garrido','22420886-3','cfilipe@googleappsmail.com','88451111',ST_GeomFromText('POINT( -72.413 -35.347)',4326)),
	('Dorotea Morales','8190374-3','4roka@hotmail.cl','25202222',NULL),
	('Asunción Moreno','20595637-9','npetq@gmail.com','65565221',NULL),
	('Reinaldo Mendez','9822228-6','pmeera.meen@hotmail.cl','85545451',NULL),
	('Raul Suarez','16267818-3','zasdl593@dtecet.com','12125414',NULL),
	('Juan Ferrer','12339396-1','4achraf_2000@dunsoi.com','14526385',NULL),
	('Fermin Pascual','12659418-6','jhamalogo@webmhouse.com','25112441',NULL),
	('Alberto Esteban','18864964-5','zalooshalsmawi9@rackabzar.com','55212332',NULL),
	('Simón Perez','24936172-0','rbruno.b@poki.us','85554411',NULL),
	('Marina Mora','6826443-k','isubin@audiophileusa.net','66332214',NULL),
	('Almudena Hidalgo','15652736-k','0moham@rifo.ru','65252515',NULL),
	('Manuela Ruiz','17053702-5','9rbnm@horizen.cf','78452102',NULL),
	('Cirino Gutierrez','18186122-3','urehammansourrh@tubidu.com','56322412',NULL),
	('Rufo Jiménez','14885956-6','wzaidjnpn@greendike.com','25143214',NULL),
	('Ricardo Saez','15989338-3','2bihnam.attallahr@litrt.site','85454512',NULL),
	('Ramiro Méndez','18569098-9','jerdenechuluun_eu@klttec.com','62625145',NULL),
	('Efren Gomez','19132415-3','pjoce_fs22w@freeallapp.com','25145555',NULL),
	('Eulalia Saez','13340059-1','anaka@cuenmex.com','20332000',NULL),
	('Roque Santana','12119008-7','khaled.e@truelocksecurity.com','20252021',NULL),
	('Rosario Díaz','9292755-5','1adm-1995t@kintil.buzz','53122033',NULL),
	('Arnaldo Medina','6939362-4','6saak88z@mracc.it','15662005',NULL),
	('Gustavo Arias','24612634-8','vsubhangahappy7p@gmailni.com','79155201',NULL),
	('Esiquio Mora','15643796-4','5tofail.ahmed.98o@jantrawat.site','62521563',NULL),
	('Ernesto Guerrero','23827802-3','abashar.yaser.71b@loviel.com','78521232',NULL),
	('Reinaldo Medina','21589805-9','njokerbilel@rackabzar.com','52626255',NULL),
	('Valentín Gutiérrez','8215459-0','mcha@luddo.me','55112211',NULL),
	('Nicomedes Rubio','20433672-5','oimad.fagdu@system32.me','36652211',NULL),
	('Camilo Muñoz','24977534-7','zmonsif_za@system32.me','78541201',NULL);

/* habilidad (8)*/
INSERT INTO public.habilidad(descrip)
	VALUES
	('Primeros auxilios'),
	('Rescate acuatico'),
	('Manejo de incendios'),
	('Excavacion'),
	('Busqueda con perros'),
	('Uso de maquinaria'),
	('Rescate en altura'),
	('No especifica');
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
	

/* tarea (10)*/
INSERT INTO public.tarea(nombre, descrip, vol_requeridos, finicio, ffin, id_emergencia, id_estado,location)
	VALUES
	('Tarea 1' ,'Limpieza de escombros' ,3,'2021-05-23',NULL,1,3,ST_GeomFromText('POINT(-72.928177 -41.474096)',4326)),
	('Tarea 2' ,'Manejo de maquinaria' ,4,'2021-05-23',NULL,1,3,ST_GeomFromText('POINT(-71.080 -33.941)',4326)),
	('Tarea 3' ,'Coordinaar auxiliares' ,1,'2021-05-23',NULL,2,3,ST_GeomFromText('POINT( -72.413 -35.347)',4326)),
	('Tarea 4' ,'Preparacion de perros',3,'2021-05-23',NULL,5,3,NULL),
	('Tarea 5' ,'Preparacion de insumos',2,'2021-05-23',NULL,5,3,NULL),
	('Tarea 6' ,'Busqueda de supervivientes' ,2,'2021-05-20',NULL,5,3,NULL),
	('Tarea 7' ,'Controlar incendios' ,3,'2021-05-20',NULL,4,3,NULL),
	('Tarea 8' ,'Apagar amago de incendio' ,4,'2021-05-20',NULL,4,3,NULL),
	('Tarea 9' ,'Suturacion de heridas' ,1,'2021-03-14',NULL,4,3,NULL),
	('Tarea 10','Dar RCP',3,'2021-03-14',NULL,5,3,NULL);
	

/* ranking (30)*/
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
	(3,20,3),
	(1,21,10),
	(3,22,1),
	(3,23,2),
	(1,24,1),
	(3,25,4),
	(3,26,5),
	(3,27,6),
	(2,28,7),
	(3,29,8),
	(2,30,2);

/* vol_tarea (21)*/
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
	(20,'true',3,8),
	(21,'true',3,9);
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
	(20,4),
	(21,5),
	(22,6),
	(23,7),
	(24,8),
	(25,1),
	(26,2),
	(27,3),
	(28,4),
	(29,5),
	(30,6);

/* tarea_habilidad (17)*/
INSERT INTO public.tarea_habilidad (id_tarea, id_habilidad)
	VALUES
	(1,1),
	(1,2),
	(2,3),
	(2,4),
	(3,5),
	(3,6),
	(4,7),
	(4,8),
	(5,1),
	(5,2),
	(6,3),
	(6,4),
	(7,5),
	(7,6),
	(8,7),
	(9,8),
	(10,1);

/* emergencia (5)*/
INSERT INTO public.emergencia (nombre, descrip, finicio, ffin, id_institucion,location)
	VALUES
	('Terremoto','Sismo de mediana a alta magnitud en las cercanias','2021-05-23','2020-05-28',1,ST_GeomFromText('POINT(-72.928177 -41.474096)',4326)),
	('Incendio','Incendio que cubre varias manzanas a la redonda','2021-05-20','2020-05-24',2,ST_GeomFromText('POINT(-71.080 -33.941)',4326)),
	('Tsunami','Alerta Tsunami decretada por la onemi','2021-03-14','2020-03-16',3,ST_GeomFromText('POINT( -72.413 -35.347)',4326)),
	('Incendio','Incendio de alta magnitud en un bosque cercano','2021-05-21','2020-05-26',1,NULL),
	('Inundacion','Comunidad devastada por una inundacion','2021-04-10','2020-04-16',2,NULL);

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