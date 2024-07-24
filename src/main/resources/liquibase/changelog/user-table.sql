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
           ('J.J.Strossmayera','nikica444@gmail.com','Nikola','Bankovic','$2a$10$lqBHR3Hid93l6jlzqc3N7enLW0umgGoisPIWk07A6vL0VXUH/8SbK','0992633128','ROLE_ADMIN','nikica'),
           ('J.J.Strossmayera','bankovic55@gmail.com','Filip','Bankovic','$2a$10$QKSV8TXoJq7Rz59xBRtnyeOGcWwUeD8MrR8X/46AqGpFmeGmmbvqW','0992624531','ROLE_USER','fico'),
           ('Zagrebacka cesta Ivek','tova.tovs@gmail.com','Nikola','Tovernic','$2a$10$DS0bkMiK5X57TqatkdoMg.6V8KEnjdGP1n8xPpO6dgC.boRE5eYkK','0912345678','ROLE_ADMIN','tova'),
           ('slavonski put 123','Triki@triki.triki','Triki','Triki','$2a$10$wEYusJVGDr.rUXslzQjzvOaTMR4Y3VweA3xhVed2OKht8WbZPnTSK','09912332123','ROLE_USER','triki');
