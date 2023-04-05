INSERT into autori(nome, cognome)
value('J.K', 'Rowling');

INSERT into autori(nome, cognome)
value('Agatha', 'Christie');

INSERT into autori(nome, cognome)
value('Dan', 'Brown');

INSERT into libri(titolo, prezzo, autore_id)
value('Harry Potter e la Pietra Filosofale', 10, 1);

INSERT into libri(titolo, prezzo, autore_id)
value('Harry Potter e la Camera dei Segreti', 10, 1);

INSERT into libri(titolo, prezzo, autore_id)
value('Angeli e Demoni', 12, 3);

INSERT into libri(titolo, prezzo, autore_id)
value('Inferno', 12, 3);

INSERT into libri(titolo, prezzo, autore_id)
value('Dieci piccoli indiani', 13, 2);

INSERT into libri(titolo, prezzo, autore_id)
value('Poirot sul Nilo', 13, 2);

INSERT into editori(nome)
value('Hoepli');

INSERT into editori(nome)
value('Mondadori');

INSERT into editori(nome)
value('Einaudi editore');

INSERT into editori_libri(editore_id, libro_id)
value(1,1);

INSERT into editori_libri(editore_id, libro_id)
value(1,2);

INSERT into editori_libri(editore_id, libro_id)
value(2,3);

INSERT into editori_libri(editore_id, libro_id)
value(2,4);

INSERT into editori_libri(editore_id, libro_id)
value(3,5);

INSERT into editori_libri(editore_id, libro_id)
value(3,6);