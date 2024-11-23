-- Table: public.numeri_telefonici

-- DROP TABLE IF EXISTS public.numeri_telefonici;

CREATE TABLE IF NOT EXISTS public.numeri_telefonici
(
    id integer NOT NULL,
    prefisso character varying(5) COLLATE pg_catalog."default",
    numero character varying(15) COLLATE pg_catalog."default" NOT NULL,
    id_contatto integer NOT NULL,
    CONSTRAINT numeri_telefonici_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.numeri_telefonici
    OWNER to postgres;