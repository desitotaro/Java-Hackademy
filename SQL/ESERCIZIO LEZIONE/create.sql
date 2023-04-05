CREATE TABLE prodotti (
    id bigint auto_increment primary key,
    nome varchar(100),
    descrizione varchar(1000),
    prezzo int check (prezzo > 0)
);

CREATE TABLE immagini (
    id bigint auto_increment primary key,
    tag varchar(100),
    url varchar(300) default 'http://aulab.it/images/aulab_logo.png',
    dimensione int default 100 check (dimensione > 0),
    prodotto_id bigint references prodotti(id)
);

CREATE TABLE fornitori (
    id bigint auto_increment primary key,
    nome varchar(100)
);

CREATE TABLE fornitori_prodotti (
    fornitore_id bigint references fornitori(id),
    prodotto_id bigint references prodotti(id)
);