CREATE TABLE public.t_alumnos
(
	    id_t_usuarios integer NOT NULL,
	    nombre character varying(80),
	    ap_paterno character varying(80),
	    activo boolean,
	    PRIMARY KEY (id_t_usuarios)
);

ALTER TABLE IF EXISTS public.t_alumnos
    OWNER to postgres;

CREATE SEQUENCE public.s_alumno
    INCREMENT 1
    START 1
    OWNED BY t_alumnos.id_t_usuarios;

ALTER SEQUENCE public.s_alumno
    OWNER TO postgres;
