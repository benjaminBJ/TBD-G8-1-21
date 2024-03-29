\c db_deptos;

--1) Lista de departamentos morosos en gastos comunes de los últimos tres meses por edificio
 
SELECT d.id AS Departamento_id, count(p.id) AS Morosidades
FROM departamento d, pago_gc_depto p
WHERE d.id=p.departamento_id AND p.pagado = false 
AND p.fecha_inicio >= (NOW() - interval '3 months')
GROUP BY d.id
ORDER BY count(p.id) DESC;

--2) Total recaudado en gastos comunes por edificio por mes

SELECT e.id as Edificio_id, SUM(tg.monto_asociado) AS Monto_GC
FROM edificio e, gasto_comun gc,tipo_gc tg
WHERE e.id = gc.edificio_id AND gc.tipo_gc_id = tg.id
GROUP BY e.id
ORDER BY SUM(tg.monto_asociado) DESC;

--3) Total de gastos del edificio pagados por mes

SELECT e.nombre_edificio AS Edificio, to_char(pge.fecha_inicio, 'Month') AS Mes, ge.monto AS Gastos
FROM edificio e, gasto_edificio ge, pago_gasto_edificio pge
WHERE e.id=pge.edificio_id AND pge.gasto_edificio_id=ge.id
ORDER BY Edificio;

--4) Tipo de depto con los gastos comunes más caros

SELECT td.id, td.modelo, MAX(monto_asociado) AS monto
FROM tipo_depto td
LEFT JOIN tipo_gc tg ON tg.id=td.tipo_gc_id
GROUP BY td.id
ORDER BY monto DESC;


--5) Lista de edificios por comuna con la cantidad de departamentos

SELECT co.nombre as comuna, ed.id as id_edificio, ed.departamentos
FROM comuna co
INNER JOIN ( SELECT e.id, count(d.id) AS departamentos, e.comuna_id
        FROM edificio e
        LEFT JOIN departamento d ON e.id = d.edificio_id
        GROUP BY e.id
        ORDER BY count(d.id) DESC ) AS ed
ON ed.comuna_id = co.id
ORDER BY co.nombre;

--6) Administrador con más edificios a cargo.

SELECT ad.id, ad.nombre, COUNT(e.id) as cargos
FROM edificio e
INNER JOIN administrador ad ON e.administrador_id = ad.id
GROUP BY ad.id
ORDER BY cargos DESC
LIMIT 1;


--7) Departamento con más habitantes por piso, por edificio.

SELECT DISTINCT *
FROM (SELECT ED.edificio_id, ED.piso, ED.numero, ED.habitantes, ED.nombre_edificio
	  FROM (SELECT *
			FROM (SELECT D.id as idDepto, D.piso, D.numero, D.habitantes, D.edificio_id
			      FROM departamento D
			      ORDER BY D.habitantes DESC) D
	  INNER JOIN edificio E on D.edificio_id = E.id) ED) FI
ORDER BY FI.habitantes DESC;


--8) Lista de tipos de departamento por edificio, mostrar la cantidad de departamentos por tipo (modelo depto). 


SELECT E.nombre_edificio as Nombre_edificio, Z.modelo as Modelo_departamento, COUNT(*) as Cantidad
FROM edificio E
INNER JOIN (SELECT edificio_id, modelo
FROM departamento D
INNER JOIN tipo_depto TD ON D.tipo_depto_id = TD.id) Z ON E.id = Z.edificio_id
GROUP BY E.nombre_edificio, Z.modelo
ORDER BY E.nombre_edificio;


--9) Lista de edificios que más gasta por mes

SELECT *
FROM(SELECT E.nombre_edificio, ET.total
     FROM edificio E
     INNER JOIN(SELECT GA.edificio_id, SUM(GA.monto) as total
                FROM (SELECT PGE.edificio_id, GE.monto
                      FROM pago_gasto_edificio PGE
                      INNER JOIN (SELECT ge.id as idGasto, ge.monto
                                  FROM gasto_edificio ge
                                  ORDER BY ge.monto DESC) GE ON PGE.gasto_edificio_id = GE.idGasto) GA
                GROUP BY GA.edificio_id) ET ON E.id = ET.edificio_id) E
ORDER BY E.total DESC;

--10) Lista de tipos de departamentos más pequeños por edificio.

SELECT e.id as Edificio, min(td.tamano) as menor_tamano
FROM   Tipo_Depto td, Departamento d, Edificio e
WHERE (e.id=d.edificio_id) and (d.tipo_depto_id=td.id)
GROUP BY e.id
ORDER BY e.id;



