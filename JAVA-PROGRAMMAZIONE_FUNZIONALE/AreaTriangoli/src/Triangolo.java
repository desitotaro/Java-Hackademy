public abstract class Triangolo {
    
    protected int height;
    protected int base;
    
    public Triangolo(int height, int base) {
        this.height = height;
        this.base = base;
    }

    abstract public int getBase(); //Bisogna dichiararla perché anche se abbiamo dichiarato i triangoli che estendono classe triangolo, 
    // non riconosce la funzione getBase, va dichiarata qui nell'abstract. Ora si fida che tutti gli oggetti che estendono triangolo 
    // hanno funzione getBase. 
    abstract public int getHeight();
}
