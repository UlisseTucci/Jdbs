-- Table: personal.regions

DROP TABLE IF EXISTS personal.regions;

CREATE TABLE IF NOT EXISTS personal.regions
(
    id integer NOT NULL,
    name character varying(80) COLLATE pg_catalog."default" NOT NULL,
    area_id integer NOT NULL,
    CONSTRAINT regions_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS personal.regions
    OWNER to postgres;