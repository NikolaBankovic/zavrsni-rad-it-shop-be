--liquibase formatted sql
--changeset nbankovic:peripheral-type-table-22072024-01
CREATE TABLE public.peripheral_type (
            id bigserial NOT NULL,
            type_name varchar(255) NULL,
            CONSTRAINT peripheral_type_pkey PRIMARY KEY (id)
            );
--rollback DROP TABLE public.peripheral_type

--changeset nbankovic:peripheral-type-table-22072024-02
INSERT INTO public.peripheral_type (type_name) VALUES
            ('Keyboard'),
            ('Mouse'),
            ('Mouse Mat'),
            ('Speakers'),
            ('Headphones'),
            ('Microphone'),
            ('Web Cam'),
            ('Monitor'),
            ('Cable'),
            ('Adapter');