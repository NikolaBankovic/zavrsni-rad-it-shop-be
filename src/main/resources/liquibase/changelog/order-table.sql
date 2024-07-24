--liquibase formatted sql
--changeset nbankovic:order-table-22072024-01
CREATE TABLE public."order" (
            id bigserial NOT NULL,
            total_price float8 NOT NULL,
            user_id int8 NULL,
            CONSTRAINT order_pkey PRIMARY KEY (id),
            CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES public."user"(id)
            );
--rollback DROP TABLE public."order"