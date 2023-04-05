INSERT into prodotti(nome,descrizione,prezzo)
value ('Iphone 14', 'Smartphone Apple', 1200);

INSERT into prodotti(nome,descrizione,prezzo)
value ('Google Pixel 7', 'Smartphone di Google', 1200);

INSERT into immagini (tag, url, dimensione, prodotto_id)
value ('iphone', 'http://store.com/images/iphone1.png', 300, 1);

INSERT into immagini (tag, url, dimensione, prodotto_id)
value ('iphone retro', 'http://store.com/images/iphone2.png', 300, 1);

INSERT into immagini (tag, url, dimensione, prodotto_id)
value ('pixel', 'http://store.com/images/pixel1.png', 300, 2);

INSERT into immagini (tag, url, dimensione, prodotto_id)
value ('pixel retro', 'http://store.com/images/pixel2.png', 300, 2);

INSERT into fornitori (nome)
value ('Fornitore 1');

INSERT into fornitori (nome)
value ('Fornitore 2');

INSERT into fornitori_prodotti(fornitore_id, prodotto_id)
value(1, 2);

INSERT into fornitori_prodotti(fornitore_id, prodotto_id)
value(2, 2);