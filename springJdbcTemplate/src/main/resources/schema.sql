
SET search_path TO public;

create table if not exists employee(
id integer primary key,
name character varying not null,
address character varying
);


CREATE  TABLE if not exists seat_allocation (
    id INT PRIMARY KEY,
    seat VARCHAR(20),
    user_id INT
);

--INSERT INTO seat_allocation (id, seat)
--SELECT
--    gs,
--    'A' || gs
--FROM generate_series(1, 100) gs;