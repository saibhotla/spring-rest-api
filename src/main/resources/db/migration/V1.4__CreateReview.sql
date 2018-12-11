CREATE SEQUENCE public.review_sequence;

ALTER SEQUENCE public.review_sequence
OWNER TO nss_admin;

CREATE TABLE public.review
(
  id bigint NOT NULL,
  text character varying(255) COLLATE pg_catalog."default",
  restaurant_id bigint,
  CONSTRAINT restaurant_key FOREIGN KEY (restaurant_id)
    REFERENCES public.restaurant (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
)
  WITH (
  OIDS = FALSE
       )
  TABLESPACE pg_default;

ALTER TABLE public.review
  OWNER to nss_admin;