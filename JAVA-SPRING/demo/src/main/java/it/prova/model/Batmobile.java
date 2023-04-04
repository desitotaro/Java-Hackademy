package it.prova.model;

public class Batmobile {
    
    private String colore;
    
    public Batmobile(String colore) {
        System.out.println("Creo Batmobile");
        this.colore = colore;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }
   
}
