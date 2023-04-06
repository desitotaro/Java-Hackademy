package it.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import it.jdbc.model.Prodotto;

@Component
public class ProdottoDao implements Dao<Prodotto>{
    
    @Autowired // La classe ProdottoDao ha una dipendenza, cioè ha bisogno di un jdbcTemplate
    // Con Autowired > cerca un Bean all'interno delle dipendenze e restituisci l'oggetto di classe
    // jdbc, ma questo Autowired già esiste. 
    // La query la fa JDBC TEMPLATE, perché comunica con il db. 
    private JdbcTemplate jdbcTemplate;
    
    // metodo non implementato dalla classe astratta
    
    public List<Prodotto> getGreaterThanPrezzo(Float minPrezzo) {
        return jdbcTemplate.query("SELECT * FROM prodotti WHERE prezzo > ?",
        new BeanPropertyRowMapper<Prodotto>(Prodotto.class), minPrezzo);
    }
    
    @Override
    public Integer count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM prodotti", Integer.class);
    }
    
    @Override
    public Prodotto getOneObject(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM prodotti WHERE id = ?",
        new BeanPropertyRowMapper<Prodotto>(Prodotto.class), id); // id quante volte c'è il ?
    }
    
    @Override
    public List<Prodotto> getObjects() { //Restituisci tutti i prodotti
        return jdbcTemplate.query("SELECT * FROM prodotti", //query indica più oggetti
        new BeanPropertyRowMapper<Prodotto>(Prodotto.class));
    }
    
    @Override
    public boolean insert(Prodotto model) {
        int result = jdbcTemplate.update("INSERT INTO prodotti (nome, descrizione, prezzo) value (?, ?, ?)",
        model.getNome(),
        model.getDescrizione(), model.getPrezzo());
        return result > 0; //insert di solito ritorna sempre a 0, per questo mettiamo > 0.
    }
    
    @Override
    public boolean update(Long id, Prodotto model) {
        int result = jdbcTemplate.update("UPDATE prodotti SET nome = ?, descrizione = ?, prezzo = ? WHERE id = ?",
        model.getNome(), model.getDescrizione(), model.getPrezzo(), id);
        return result > 0;
    }
    
    @Override
    public boolean delete(Long id) {
        int result = jdbcTemplate.update("DELETE FROM prodotti WHERE id = ?",
        id);
        return result > 0;
    }
    
    
    
}
