-- Table: personal.provinces

DROP TABLE IF EXISTS personal.provinces;

CREATE TABLE IF NOT EXISTS personal.provinces
(
    acronym character(2) COLLATE pg_catalog."default" NOT NULL,
    name character varying(80) COLLATE pg_catalog."default" NOT NULL,
    region_id integer NOT NULL,
    CONSTRAINT provinces_pkey PRIMARY KEY (acronym)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS personal.provinces
    OWNER to postgres;