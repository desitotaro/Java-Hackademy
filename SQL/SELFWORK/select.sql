/* SELECT * from autori join libri on autori.id = libri.autore_id; */
SELECT * from editori e join editori_libri el on e.id = el.libro_id
join libri l on el.libro_id = l.id;