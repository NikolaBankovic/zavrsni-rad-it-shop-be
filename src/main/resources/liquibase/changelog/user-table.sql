--liquibase formatted sql
--changeset nbankovic:user-table-22072024-01
CREATE TABLE public."user" (
            id bigserial NOT NULL,
            address varchar(255) NULL,
            email varchar(255) NULL,
            first_name varchar(255) NULL,
            last_name varchar(255) NULL,
            "password" varchar(255) NULL,
            phone_number varchar(255) NULL,
            "role" varchar(255) NULL,
            username varchar(255) NULL,
            CONSTRAINT user_pkey PRIMARY KEY (id),
            CONSTRAINT user_role_check CHECK (((role)::text = ANY ((ARRAY['ROLE_USER'::character varying, 'ROLE_ADMIN'::character varying, 'ROLE_SUPPLIER'::character varying])::text[])))
            );
--rollback DROP TABLE public."user"

--changeset nbankovic:user-table-22072024-02
INSERT INTO public."user" (address,email,first_name,last_name,"password",phone_number,"role",username) VALUES
    ('admin adress','admin@email.com','Admin','Admin','$2a$10$vLKFZ/yBiDyjqiItYgUrEuz3EzIF52xoRfjAfprHCZhJd/WMu8IN6','123654978','ROLE_ADMIN','admin'),
    ('supplier address','supplier@email.com','Supplier','','$2a$10$8VfJ7xYkiF1d89rtgWKVguq331IVen91MZfYMUJE0bNyfNepW2Pdu','123456798','ROLE_SUPPLIER','supplier'),
    ('user adress','user@mail.com','User','User','$2a$10$yjurChNd2wKlieX48q4A7./jKce2Wl2S6VfH6q0Cl4Bf0mt0e.Rem','989823312','ROLE_USER','user');
