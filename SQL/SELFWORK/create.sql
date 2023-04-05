CREATE TABLE autori (
    id bigint auto_increment primary key,
    nome varchar(20),
    cognome varchar(20)
);

CREATE TABLE libri (
    id bigint auto_increment primary key,
    titolo varchar(50),
    prezzo int check (prezzo > 0),
    autore_id bigint references autori(id)
);

CREATE TABLE editori(
    id bigint auto_increment primary key,
    nome varchar(30)
);

CREATE TABLE editori_libri (
   editore_id bigint references editori(id),
   libro_id bigint references libri(id)
);
