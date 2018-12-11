CREATE SEQUENCE public.review_sequence;

ALTER SEQUENCE public.review_sequence
OWNER TO nss_admin;

CREATE TABLE public.review
(
  id bigint NOT NULL,
  name character varying(255) COLLATE pg_catalog."default",
  restaurant_id bigint REFERENCES restaurant(id),
  CONSTRAINT review_pkey PRIMARY KEY (id),
  CONSTRAINT restaurant_fkey FOREIGN KEY (restaurant_id)

)
  WITH (
  OIDS = FALSE
       )
  TABLESPACE pg_default;

ALTER TABLE public.review
  OWNER to nss_admin;