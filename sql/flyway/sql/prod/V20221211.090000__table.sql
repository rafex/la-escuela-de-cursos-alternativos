-- Table: public.t_alumnos_materias

-- DROP TABLE IF EXISTS public.t_alumnos_materias;

CREATE TABLE IF NOT EXISTS public.t_alumnos_materias
(
    id_t_materias integer NOT NULL,
    id_t_usuarios integer NOT NULL,
    CONSTRAINT t_alumnos_materias_materias_fkey FOREIGN KEY(id_t_materias) REFERENCES t_materias(id_t_materias),
    CONSTRAINT t_alumnos_materias_alumnos_fkey FOREIGN KEY(id_t_usuarios) REFERENCES t_alumnos(id_t_usuarios)
) TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.t_alumnos_materias
    OWNER to postgres;
