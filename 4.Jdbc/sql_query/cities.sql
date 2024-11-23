-- Table: personal.cities

DROP TABLE IF EXISTS personal.cities;

CREATE TABLE IF NOT EXISTS personal.cities
(
    id integer NOT NULL,
    name character varying(80) COLLATE pg_catalog."default" NOT NULL,
    capital boolean NOT NULL,
    cadastral character(4) COLLATE pg_catalog."default" NOT NULL,
    acronym character(2) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT cities_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS personal.cities
    OWNER to postgres;