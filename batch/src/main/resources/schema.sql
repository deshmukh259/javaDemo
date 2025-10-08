
create table if not EXISTS dog (

id serial primary key,
name text not null,
owner text   null,
description text not null
);