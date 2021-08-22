
-- Drop si ya existia
DROP DATABASE voluntariado;

-- Crear Base de datos
CREATE DATABASE voluntariado;

\c voluntariado;

--Crear extension postgis
CREATE EXTENSION postgis;

-- prueba
CREATE TABLE public.dog(
	id SERIAL PRIMARY KEY,
	name character varying(100) NOT NULL,
    descrip character varying(400) 
);
-- Agregar geometria
SELECT
AddGeometryColumn('dog','location','4326','point',2);

ALTER TABLE public.dog OWNER TO postgres;

CREATE TABLE public.habilidad (
    id SERIAL PRIMARY KEY,
    descrip character varying(100) NOT NULL
);

ALTER TABLE public.habilidad OWNER TO postgres;

CREATE TABLE public.voluntario0 (
    id SERIAL PRIMARY KEY,
    nombre character varying(100) NOT NULL,
    rut character varying(12) NOT NULL,
    email character varying(100) NOT NULL,
    telefono character varying(100) NOT NULL,
    tabla character varying(100) NOT NULL
);

ALTER TABLE public.voluntario0 OWNER TO postgres;

CREATE TABLE public.voluntario1 (
    id SERIAL PRIMARY KEY,
    nombre character varying(100) NOT NULL,
    rut character varying(12) NOT NULL,
    email character varying(100) NOT NULL,
    telefono character varying(100) NOT NULL,
    tabla character varying(100) NOT NULL
);

ALTER TABLE public.voluntario1 OWNER TO postgres;

CREATE TABLE public.voluntario2 (
    id SERIAL PRIMARY KEY,
    nombre character varying(100) NOT NULL,
    rut character varying(12) NOT NULL,
    email character varying(100) NOT NULL,
    telefono character varying(100) NOT NULL,
    tabla character varying(100) NOT NULL
);

ALTER TABLE public.voluntario2 OWNER TO postgres;

CREATE TABLE public.vol_habilidad0 (
    id SERIAL PRIMARY KEY,
    id_voluntario integer,
    id_habilidad integer,
    tabla character varying(100) NOT NULL
);
ALTER TABLE public.vol_habilidad0 OWNER TO postgres;

CREATE TABLE public.vol_habilidad1 (
    id SERIAL PRIMARY KEY,
    id_voluntario integer,
    id_habilidad integer,
    tabla character varying(100) NOT NULL
);
ALTER TABLE public.vol_habilidad1 OWNER TO postgres;

CREATE TABLE public.vol_habilidad2 (
    id SERIAL PRIMARY KEY,
    id_voluntario integer,
    id_habilidad integer,
    tabla character varying(100) NOT NULL
);
ALTER TABLE public.vol_habilidad2 OWNER TO postgres;
