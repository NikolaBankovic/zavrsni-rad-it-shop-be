--liquibase formatted sql
--changeset nbankovic:product-table-22072024-01
CREATE TABLE public.product (
            product_type varchar(31) NOT NULL,
            id bigserial NOT NULL,
            description text NULL,
            image text NULL,
            "name" varchar(255) NULL,
            price float8 NOT NULL,
            times_visited int8 NULL,
            link_to_part_on_manufacturer_website varchar(255) NULL,
            manufacturer_catalogue_number varchar(255) NULL,
            manufacturer_name varchar(255) NULL,
            used_state varchar(255) NULL,
            warranty_length int8 NULL,
            pc_type_id int8 NULL,
            pc_part_type_id int8 NULL,
            peripheral_type_id int8 NULL,
            software_type_id int8 NULL,
            CONSTRAINT product_pkey PRIMARY KEY (id),
            CONSTRAINT product_used_state_check CHECK (((used_state)::text = ANY ((ARRAY['USED'::character varying, 'NEW'::character varying])::text[]))),
            CONSTRAINT pc_part_type_fk FOREIGN KEY (pc_part_type_id) REFERENCES public.pc_part_type(id),
            CONSTRAINT software_type_fk FOREIGN KEY (software_type_id) REFERENCES public.software_type(id),
            CONSTRAINT peripheral_type_fk FOREIGN KEY (peripheral_type_id) REFERENCES public.peripheral_type(id),
            CONSTRAINT pc_type_fk FOREIGN KEY (pc_type_id) REFERENCES public.pc_type(id)
            );
--rollback DROP TABLE public.product