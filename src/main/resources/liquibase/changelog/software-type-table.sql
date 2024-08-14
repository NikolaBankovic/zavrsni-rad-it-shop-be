--liquibase formatted sql
--changeset nbankovic:software-type-table-22072024-01
CREATE TABLE public.software_type (
            id bigserial NOT NULL,
            type_name varchar(255) NULL,
            CONSTRAINT software_type_pkey PRIMARY KEY (id)
            );
--rollback DROP TABLE public.software_type

--changeset nbankovic:software-type-table-22072024-02
INSERT INTO public.software_type (type_name) VALUES
            ('OS'),
            ('Application'),
            ('Security'),
            ('Game');