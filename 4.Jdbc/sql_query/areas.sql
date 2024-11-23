-- Table: personal.areas

DROP TABLE IF EXISTS personal.areas;

CREATE TABLE IF NOT EXISTS personal.areas
(
    id integer NOT NULL,
    name character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT areas_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS personal.areas
    OWNER to postgres;