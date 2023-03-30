public class Jeeg {

    //Sono oggetti di classe Arm e Legs, quando accedo a armDx
    // accedo all'oggetto di classe Arm e quindi posso anche lanciare i suoi metodi
    private Arm armDx;
    private Arm armSx;
    private Moveable moveable;

    public Jeeg(Arm armDx, Arm armSx, Moveable moveable) { 
        this.armDx = armDx;
        this.armSx = armSx;
        this.moveable = moveable;
    }

    // Jeeg può attaccare e muoversi
    public void attack() {
        // attacca con le braccia che sono oggetti e implementa il metodo attacca
        this.armDx.attack();
        this.armSx.attack();
        this.armSx.attack();
        this.armDx.attack();
        Class<? extends Object> classe = moveable.getClass(); 
        if(classe.toString().equals("class Tank")){ // confronto tra una stringa e un qualcosa che non sa
            Tank t = (Tank) this.moveable;
            t.attack();
        }
   
    }

    public void goForward() { this.moveable.goForward(); }
    public void goBack() { this.moveable.goBack(); }

}
