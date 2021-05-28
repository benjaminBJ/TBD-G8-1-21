
DROP DATABASE voluntariado;

CREATE DATABASE voluntariado;

\c voluntariado;


-- prueba
CREATE TABLE public.dog(
	id SERIAL PRIMARY KEY,
	name character varying(100) NOT NULL,
    descrip character varying(400) NOT NULL
);
ALTER TABLE public.dog OWNER TO postgres;

CREATE TABLE public.institucion (
    id SERIAL PRIMARY KEY,
    nombre character varying(100) NOT NULL,
    descrip character varying(400) NOT NULL
);

ALTER TABLE public.institucion OWNER TO postgres;


CREATE TABLE public.emergencia (
    id SERIAL PRIMARY KEY,
    nombre character varying(100) NOT NULL,
    descrip character varying(400) NOT NULL,
    finicio date NOT NULL,
    ffin date,
    id_institucion SERIAl references institucion(id)
);

ALTER TABLE public.emergencia OWNER TO postgres;


CREATE TABLE public.habilidad (
    id SERIAL PRIMARY KEY,
    descrip character varying(100) NOT NULL
);

ALTER TABLE public.habilidad OWNER TO postgres;

CREATE TABLE public.eme_habilidad (
    id SERIAL PRIMARY KEY,
    id_emergencia SERIAl references emergencia(id),
    id_habilidad SERIAl references habilidad(id)
);

ALTER TABLE public.eme_habilidad OWNER TO postgres;

CREATE TABLE public.estado_tarea (
    id SERIAL PRIMARY KEY,
    descrip character varying(20) NOT NULL
);

ALTER TABLE public.estado_tarea OWNER TO postgres;


CREATE TABLE public.tarea (
    id SERIAL PRIMARY KEY,
    nombre character varying(60) NOT NULL,
    descrip character varying(300) NOT NULL,
    vol_requeridos numeric(4,0) NOT NULL,
    id_emergencia numeric(6,0) NOT NULL,
    finicio date NOT NULL,
    ffin date,
    id_estado SERIAl references estado_tarea(id)
);

ALTER TABLE public.tarea OWNER TO postgres;


CREATE TABLE public.tarea_habilidad (
    id SERIAL PRIMARY KEY,
    id_tarea SERIAl references tarea(id),
    id_habilidad SERIAl references habilidad(id)
);


ALTER TABLE public.tarea_habilidad OWNER TO postgres;

CREATE TABLE public.voluntario (
    id SERIAL PRIMARY KEY,
    nombre character varying(100) NOT NULL,
    rut character varying(12) NOT NULL,
    email character varying(100) NOT NULL,
    telefono character varying(100) NOT NULL
);


ALTER TABLE public.voluntario OWNER TO postgres;

CREATE TABLE public.vol_habilidad (
    id SERIAL PRIMARY KEY,
    id_voluntario SERIAl references voluntario(id),
    id_habilidad SERIAl references habilidad(id)
);

ALTER TABLE public.vol_habilidad OWNER TO postgres;

CREATE TABLE public.vol_tarea (
    id SERIAL PRIMARY KEY,
    flg_participa boolean NOT NULL,
    id_estado numeric(2,0) ,
    id_voluntario SERIAl references voluntario(id),
    id_tarea SERIAl references tarea(id)
);

ALTER TABLE public.vol_tarea OWNER TO postgres;


CREATE TABLE public.ranking (
    id SERIAL PRIMARY KEY,
    puntaje numeric(3,0) NOT NULL,
    id_voluntario SERIAl references voluntario(id),
    id_tarea SERIAl references tarea(id)
);


ALTER TABLE public.ranking OWNER TO postgres;


