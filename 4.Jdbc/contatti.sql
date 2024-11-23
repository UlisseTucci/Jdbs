-- Table: public.contatti

-- DROP TABLE IF EXISTS public.contatti;

CREATE TABLE IF NOT EXISTS public.contatti
(
    id integer NOT NULL,
    nome character varying(20) COLLATE pg_catalog."default" NOT NULL,
    cognome character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT contatti_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.contatti
    OWNER to postgres;