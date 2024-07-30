--liquibase formatted sql
--changeset nbankovic:pc-part-type-table-22072024-01
CREATE TABLE public.pc_part_type (
             id bigserial NOT NULL,
             type_name varchar(255) NULL,
             CONSTRAINT pc_part_type_pkey PRIMARY KEY (id)
            );
--rollback DROP TABLE public.pc_part_type

--changeset nbankovic:pc-part-type-table-22072024-02
INSERT INTO public.pc_part_type (type_name) VALUES
            ('Processor'),
            ('Motherboard'),
            ('Graphics Card'),
            ('RAM'),
            ('SSD'),
            ('HDD'),
            ('Power Supply'),
            ('Case'),
            ('Cooler'),
            ('Liquid Cooling'),
            ('Optical Drive'),
            ('Fan'),
            ('Thermal Paste'),
            ('Audio Card');
