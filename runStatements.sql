/*inlcuir DB si se corre por consola */
\c db_deptos;


/* 1) Lista de departamentos morosos en gastos comunes de los últimos tres meses por
edificio (Javier S)*/
 
SELECT d.id AS Departamento_id, count(p.id) AS Morosidades
FROM departamento d, pago_gc_depto p
WHERE d.id=p.departamento_id AND p.pagado = false 
AND p.fecha_inicio >= (NOW() - interval '3 months')
GROUP BY d.id
ORDER BY count(p.id) DESC;

/* 2) Total recaudado en gastos comunes por edificio por mes(Javier S)*/

SELECT e.id as Edificio_id, SUM(tg.monto_asociado) AS Monto_GC
FROM edificio e, gasto_comun gc,tipo_gc tg
WHERE e.id = gc.edificio_id AND gc.tipo_gc_id = tg.id
GROUP BY e.id
ORDER BY SUM(tg.monto_asociado) DESC;



/*7) Departamento con más habitantes por piso, por edificio.(Daniel O.)*/

SELECT E.nombre_edificio, Z.numero, Z.habitantes
FROM edificio E
INNER JOIN (SELECT b.edificio_id, b.numero, max(b.habitantes) as habitantes
            FROM (SELECT DISTINCT *
    		       FROM departamento D
    		       ORDER BY D.habitantes DESC) b
            GROUP BY b.edificio_id) Z ON E.id = Z.edificio_id;


/*8) Lista de tipos de departamento por edificio, mostrar la cantidad de departamentos por tipo. (Jordan)*/

SELECT E.nombre_edificio as Nombre_edificio, Z.modelo as Modelo_departamento, COUNT(*) as Cantidad
FROM Edificio E
INNER JOIN (SELECT idEdificio, modelo
FROM Departamento D
INNER JOIN Tipo_Depto TD ON D.idTipoDpto = TD.id) Z ON E.id = Z.idEdificio
GROUP BY E.nombre_edificio, Z.modelo
ORDER BY E.id



/*9) Lista de edificios que más gasta por mes (Daniel O.).*/

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


/* 3) Total de gastos del edificio pagados por mes (Oscar) */

SELECT e.nombre_edificio AS Edificio, to_char(pge.fecha_inicio, 'Month') AS Mes, ge.monto AS Gastos
FROM edificio e, gasto_edificio ge, pago_gasto_edificio pge
WHERE e.id=pge.edificio_id AND pge.gasto_edificio_id=ge.id
ORDER BY Edificio;