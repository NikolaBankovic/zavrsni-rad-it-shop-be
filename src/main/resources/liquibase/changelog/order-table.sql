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

--changeset nbankoivc:order-table-01082024-01
ALTER TABLE public."order"
ADD COLUMN credit_card_number VARCHAR(8) NOT NULL DEFAULT 'unknown',
ADD COLUMN order_date TIMESTAMP NOT NULL DEFAULT NOW();
--rollback ALTER TABLE public."order" DROP COLUMN credit_card_number, DROP COLUMN order_date;

--changeset nbankovic:order-table-01082024-02
UPDATE public."order"
SET credit_card_number = 'unknown'
WHERE credit_card_number IS NULL;

--changeset nbankovic:order-table-01082024-03
UPDATE public."order"
SET order_date = NOW()
WHERE order_date IS NULL;