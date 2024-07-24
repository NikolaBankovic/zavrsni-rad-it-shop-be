--liquibase formatted sql
--changeset nbankovic:cart-item-table-22072024-01
CREATE TABLE public.cart_item (
        id bigserial NOT NULL,
        quantity int4 NOT NULL,
        cart_id int8 NULL,
        product_id int8 NULL,
        CONSTRAINT cart_item_pkey PRIMARY KEY (id),
        CONSTRAINT cart_id_fk FOREIGN KEY (cart_id) REFERENCES public.cart(id),
        CONSTRAINT product_id_fk FOREIGN KEY (product_id) REFERENCES public.product(id)
        );
--rollback DROP TABLE public.cart_item