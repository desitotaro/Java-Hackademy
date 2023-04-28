CREATE TABLE books(
    id bigint auto_increment primary key,
    title varchar(120),
    author varchar(70),
    price float check (price > 0)
);

