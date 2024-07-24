--liquibase formatted sql
--changeset nbankovic:order-item-table-22072024-01
CREATE TABLE public.order_item (
            id bigserial NOT NULL,
            price float8 NOT NULL,
            quantity int4 NOT NULL,
            order_id int8 NULL,
            product_id int8 NULL,
            CONSTRAINT order_item_pkey PRIMARY KEY (id),
            CONSTRAINT product_id_fk FOREIGN KEY (product_id) REFERENCES public.product(id),
            CONSTRAINT order_id_fk FOREIGN KEY (order_id) REFERENCES public."order"(id)
            );
--rollback DROP TABLE public.order_item