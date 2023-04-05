package it.prova.model;

public class Suit {
    private String colore;
    private Mask mask;
    private Hook hook;
    
    public Suit(String colore, Mask mask, Hook hook) {
        this.colore = colore;
        this.mask = mask;
        this.hook = hook;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public Mask getMask() {
        return mask;
    }

    public void setMask(Mask mask) {
        this.mask = mask;
    }

    public Hook getHook() {
        return hook;
    }

    public void setHook(Hook hook) {
        this.hook = hook;
    }

}