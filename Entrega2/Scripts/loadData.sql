\c voluntariado;

/* voluntario (30)*/
INSERT INTO public.voluntario (nombre, rut, email, telefono)
	VALUES
	('Hector Campos','20467238-5','tbrahim.amin.9630@gmail.com','25252655'),
	('Edgar Ruiz','10134071-6','jmalik1127c@live.cl','11225443'),
	('Arturo Garrido','22420886-3','cfilipe@googleappsmail.com','88451111'),
	('Dorotea Morales','8190374-3','4roka@hotmail.cl','25202222'),
	('Asunción Moreno','20595637-9','npetq@gmail.com','65565221'),
	('Reinaldo Mendez','9822228-6','pmeera.meen@hotmail.cl','85545451'),
	('Raul Suarez','16267818-3','zasdl593@dtecet.com','12125414'),
	('Juan Ferrer','12339396-1','4achraf_2000@dunsoi.com','14526385'),
	('Fermin Pascual','12659418-6','jhamalogo@webmhouse.com','25112441'),
	('Alberto Esteban','18864964-5','zalooshalsmawi9@rackabzar.com','55212332'),
	('Simón Perez','24936172-0','rbruno.b@poki.us','85554411'),
	('Marina Mora','6826443-k','isubin@audiophileusa.net','66332214'),
	('Almudena Hidalgo','15652736-k','0moham@rifo.ru','65252515'),
	('Manuela Ruiz','17053702-5','9rbnm@horizen.cf','78452102'),
	('Cirino Gutierrez','18186122-3','urehammansourrh@tubidu.com','56322412'),
	('Rufo Jiménez','14885956-6','wzaidjnpn@greendike.com','25143214'),
	('Ricardo Saez','15989338-3','2bihnam.attallahr@litrt.site','85454512'),
	('Ramiro Méndez','18569098-9','jerdenechuluun_eu@klttec.com','62625145'),
	('Efren Gomez','19132415-3','pjoce_fs22w@freeallapp.com','25145555'),
	('Eulalia Saez','13340059-1','anaka@cuenmex.com','20332000'),
	('Roque Santana','12119008-7','khaled.e@truelocksecurity.com','20252021'),
	('Rosario Díaz','9292755-5','1adm-1995t@kintil.buzz','53122033'),
	('Arnaldo Medina','6939362-4','6saak88z@mracc.it','15662005'),
	('Gustavo Arias','24612634-8','vsubhangahappy7p@gmailni.com','79155201'),
	('Esiquio Mora','15643796-4','5tofail.ahmed.98o@jantrawat.site','62521563'),
	('Ernesto Guerrero','23827802-3','abashar.yaser.71b@loviel.com','78521232'),
	('Reinaldo Medina','21589805-9','njokerbilel@rackabzar.com','52626255'),
	('Valentín Gutiérrez','8215459-0','mcha@luddo.me','55112211'),
	('Nicomedes Rubio','20433672-5','oimad.fagdu@system32.me','36652211'),
	('Camilo Muñoz','24977534-7','zmonsif_za@system32.me','78541201');

/* habilidad (8)*/
INSERT INTO public.habilidad(descrip)
	VALUES
	('Primeros auxilios'),
	('Rescate acuático'),
	('Manejo de incendios'),
	('Excavación'),
	('Busqueda con perros'),
	('Uso de maquinaria'),
	('Rescate en altura'),
	('No específica');
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
	

/* tarea (17)*/
INSERT INTO public.tarea(nombre, descrip, vol_requeridos, finicio, ffin, id_emergencia, id_estado)
	VALUES
	('Tarea 1' ,'desc 1' ,2,'2021-05-23',NULL,1,3),
	('Tarea 2' ,'desc 2' ,4,'2021-05-23',NULL,1,1),
	('Tarea 3' ,'desc 3' ,1,'2021-05-23',NULL,1,1),
	('Tarea 4' ,'desc 4' ,3,'2021-05-23',NULL,1,1),
	('Tarea 5' ,'desc 5' ,2,'2021-05-23',NULL,1,2),
	('Tarea 6' ,'desc 6' ,2,'2021-05-20',NULL,2,2),
	('Tarea 7' ,'desc 7' ,3,'2021-05-20',NULL,2,2),
	('Tarea 8' ,'desc 8' ,4,'2021-05-20',NULL,2,2),
	('Tarea 9' ,'desc 9' ,1,'2021-03-14','2016-03-15',3,2),
	('Tarea 10','desc 10',3,'2021-03-14','2016-03-16',3,2),
	('Tarea 11','desc 11',2,'2021-03-15','2016-03-16',3,2),
	('Tarea 12','desc 12',2,'2021-03-15','2016-03-16',3,3),
	('Tarea 13','desc 13',3,'2021-05-21',NULL,4,3),
	('Tarea 14','desc 14',3,'2021-05-21',NULL,4,3),
	('Tarea 15','desc 15',3,'2021-05-21',NULL,4,1),
	('Tarea 16','desc 16',4,'2021-04-10','2016-04-11',5,3),
	('Tarea 17','desc 17',1,'2021-04-10','2016-04-12',5,3);

/* ranking (30)*/
INSERT INTO public.ranking (puntaje, id_voluntario, id_tarea)
	VALUES
	(3,1,9),
	(2,2,10),
	(1,3,11),
	(0,4,12),
	(2,5,16),
	(2,6,17),
	(3,7,12),
	(1,8,1),
	(0,9,2),
	(3,10,11),
	(1,11,3),
	(2,12,4),
	(3,13,5),
	(2,14,6),
	(1,15,7),
	(1,16,8),
	(2,17,13),
	(3,18,14),
	(2,19,15),
	(3,20,3),
	(1,21,15),
	(3,22,1),
	(3,23,2),
	(1,24,13),
	(3,25,4),
	(3,26,5),
	(3,27,6),
	(2,28,7),
	(3,29,8),
	(2,30,15);

/* vol_tarea (21)*/
INSERT INTO public.vol_tarea (id_voluntario, flg_participa, id_estado, id_tarea)
	VALUES
	(1,'true',3,1),
	(2,'true',4,1),
	(5,'true',4,16),
	(6,'true',4,17),
	(7,'true',4,12),
	(10,'true',4,11),
	(12,'true',4,4),
	(13,'true',1,5),
	(14,'true',3,6),
	(17,'true',3,13),
	(18,'true',3,14),
	(19,'true',3,15),
	(20,'true',3,3),
	(22,'true',3,2),
	(23,'true',3,2),
	(25,'true',3,4),
	(26,'true',3,5),
	(27,'true',3,6),
	(28,'true',3,7),
	(29,'true',3,8),
	(30,'true',4,15);
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
	(30,7);

/* tarea_habilidad (17)*/
INSERT INTO public.tarea_habilidad (id_tarea, id_habilidad)
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
	(17,1);

/* emergencia (5)*/
INSERT INTO public.emergencia (nombre, descrip, finicio, ffin, id_institucion)
	VALUES
	('Terremoto','desc_eme 1','2021-05-23','2020-05-28',1),
	('Incendio','desc_eme 2','2021-05-20','2020-05-24',2),
	('Tsunami','desc_eme 3','2021-03-14','2020-03-16',3),
	('Incendio','desc_eme 4','2021-05-21','2020-05-26',1),
	('Inundación','desc_eme 5','2021-04-10','2020-04-16',2);

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
    WHERE id = IDT
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