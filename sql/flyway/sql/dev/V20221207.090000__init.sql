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


