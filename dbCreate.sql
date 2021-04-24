CREATE DATABASE db_deptos;

\c db_deptos;

CREATE TABLE comuna(
	id SERIAL PRIMARY KEY,
	nombre character varying(100) NOT NULL,
	provincia character varying(100) Not NULL
);

CREATE TABLE administrador(
	id SERIAL PRIMARY KEY,
	nombre character varying(100) NOT NULL,
	rut character varying(100) NOT NULL,
	email character varying(100) NOT NULL,
	telefono character varying(100) NOT NULL
);

CREATE TABLE gasto_edificio(
	id SERIAL PRIMARY KEY,
	tipo character varying(100) NOT NULL,
	monto INT NOT NULL
);

CREATE TABLE edificio(
	id SERIAL PRIMARY KEY,
	nombre_edificio character varying(100) NOT NULL,
	numeracion INT NOT NULL,
	direccion character varying(100) NOT NULL,
	comuna_id SERIAl references comuna(id),
	administrador_id SERIAL references administrador(id)
);

CREATE TABLE pago_gasto_edificio(
	id SERIAL PRIMARY KEY,
	fecha_inicio TIMESTAMP NOT NULL,
	fecha_termino TIMESTAMP NOT NULL,
	edificio_id SERIAL references edificio(id),
	gasto_edificio_id SERIAL references gasto_edificio(id)
);

CREATE TABLE tipo_gc(
	id SERIAL PRIMARY KEY,
	tipo character varying(100) NOT NULL,
	monto_asociado INT NOT NULL
);

CREATE TABLE gasto_comun(
	id SERIAL PRIMARY KEY,
	edificio_id SERIAL references edificio(id),
	tipo_gc_id SERIAL references edificio(id)

);

CREATE TABLE tipo_depto(
	id SERIAL PRIMARY KEY,
	modelo character varying(100) NOT NULL,
	tamano REAL NOT NULL,
	tipo_gc_id SERIAL references tipo_gc(id)
);

CREATE TABLE departamento(
	id SERIAL PRIMARY KEY,
	numero INT NOT NULL,
	piso INT NOT NULL,
	dueno character varying(100) NOT NULL,
	habitantes INT NOT NULL,
	edificio_id SERIAL references edificio(id),
	tipo_depto_id SERIAL references tipo_depto(id)
);

CREATE TABLE pago_gc_depto(
	id SERIAL PRIMARY KEY,
	fecha_inicio TIMESTAMP NOT NULL,
	fecha_termino TIMESTAMP NOT NULL,
	pagado BOOLEAN NOT NULL,
	departamento_id SERIAL references departamento(id),
	gasto_comun_id SERIAL references gasto_comun(id)
);
