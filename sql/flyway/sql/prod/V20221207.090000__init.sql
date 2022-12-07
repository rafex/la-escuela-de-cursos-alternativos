-- Table: public.t_alumnos

-- DROP TABLE IF EXISTS public.t_alumnos;

CREATE TABLE IF NOT EXISTS public.t_alumnos
(
    id_t_usuarios integer NOT NULL,
    nombre character varying(80) COLLATE pg_catalog."default",
    ap_paterno character varying(80) COLLATE pg_catalog."default",
    ap_materno character varying(80) COLLATE pg_catalog."default",
    activo boolean,
    CONSTRAINT t_alumnos_pkey PRIMARY KEY (id_t_usuarios)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.t_alumnos
    OWNER to postgres;

CREATE SEQUENCE public.s_alumno
    INCREMENT 1
    START 1
    OWNED BY t_alumnos.id_t_usuarios;

ALTER SEQUENCE public.s_alumno
    OWNER TO postgres;

-- Table: public.t_materias

-- DROP TABLE IF EXISTS public.t_materias;

CREATE TABLE IF NOT EXISTS public.t_materias
(
    id_t_materias integer NOT NULL,
    nombre character varying(80) COLLATE pg_catalog."default",
    activo boolean,
    CONSTRAINT t_materias_pkey PRIMARY KEY (id_t_materias)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.t_materias
    OWNER to postgres;

CREATE SEQUENCE public.s_materia
    INCREMENT 1
    START 1
    OWNED BY t_materias.id_t_materias;

ALTER SEQUENCE public.s_materia
    OWNER TO postgres;

-- Table: public.t_calificaciones

-- DROP TABLE IF EXISTS public.t_calificaciones;

CREATE TABLE IF NOT EXISTS public.t_calificaciones
(
    id_t_calificaciones integer NOT NULL,
    id_t_materias integer NOT NULL,
    id_t_usuarios integer NOT NULL,
    calificacion numeric(10,2),
    CONSTRAINT t_calificaciones_pkey PRIMARY KEY (id_t_calificaciones),
    CONSTRAINT t_calificaciones_materias_fkey FOREIGN KEY(id_t_materias) REFERENCES t_materias(id_t_materias),
    CONSTRAINT t_calificaciones_alumnos_fkey FOREIGN KEY(id_t_usuarios) REFERENCES t_alumnos(id_t_usuarios),
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.t_calificaciones
    OWNER to postgres;

CREATE SEQUENCE public.s_calificaciones
    INCREMENT 1
    START 1
    OWNED BY t_calificaciones.id_t_calificaciones;

ALTER SEQUENCE public.s_materia
    OWNER TO postgres;