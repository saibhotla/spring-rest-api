CREATE SEQUENCE public.restaurant_sequence;

ALTER SEQUENCE public.restaurant_sequence
OWNER TO nss_admin;

CREATE TABLE public.restaurant
(
  id bigint NOT NULL,
  name character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT restaurant_pkey PRIMARY KEY (id)
)
  WITH (
  OIDS = FALSE
       )
  TABLESPACE pg_default;

ALTER TABLE public.restaurant
  OWNER to nss_admin;