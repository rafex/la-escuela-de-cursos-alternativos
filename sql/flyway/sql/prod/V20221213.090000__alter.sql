ALTER TABLE IF EXISTS public.t_calificaciones
    ADD CONSTRAINT unq_calificaciones UNIQUE (id_t_materias, id_t_usuarios);