--liquibase formatted sql
--changeset nbankovic:pc-type-table-22072024-01
CREATE TABLE public.pc_type (
            id bigserial NOT NULL,
            type_name varchar(255) NULL,
            CONSTRAINT pc_type_pkey PRIMARY KEY (id)
            );
--rollback DROP TABLE public.pc_type

--changeset nbankovic:pc-type-table-22072024-02
INSERT INTO public.pc_type (type_name) VALUES
            ('Office'),
            ('Gaming'),
            ('Work Station'),
            ('Server');
