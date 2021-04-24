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


