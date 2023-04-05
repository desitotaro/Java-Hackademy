select p.nome, p.prezzo, f.nome
from prodotti p
join fornitori_prodotti fp on p.id = fp.prodotto_id
join fornitori f on fp.fornitore_id = f.id
