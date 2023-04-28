package it.demo.springweb.model;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornitori")
public class Fornitore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;


    //Abbiamo varie strategie per usare la relazione
    //Usiamo la join table proprio sulla tabella che abbiamo usato
    //Per gestire la relazione ManyToMany
	@ManyToMany
	@JoinTable(name = "fornitori_prodotti", 
	joinColumns = @JoinColumn(name = "fornitore_id"), 
	inverseJoinColumns = @JoinColumn(name = "prodotto_id"))
    private List<Prodotto> prodotti = new ArrayList<Prodotto>();

    public Fornitore() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }
    
}
