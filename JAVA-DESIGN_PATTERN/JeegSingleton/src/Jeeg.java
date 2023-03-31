public class Jeeg {

    private Arm armDx;
    private Arm armSx;
    private Moveable moveable;
    //dopo aver fatto il setter, inserisco la logica nel 
    // costruttore. Le stringhe però non sono super affidabili,
    //quindi usiamo un nuovo metodo, enum 
    public Jeeg(Arm armDx, Arm armSx, Moveable moveable) {
        this.setArm(armDx, Side.Dx); // mi dà errore, modifica parametro di setArm 
        this.setArm(armSx, Side.Sx);
        this.setMoveable(moveable); 
    }

    public Arm getArmDx() {
        return armDx;
    }

    // refactoring del setter
    public void setArm(Arm newArm, Side side) {
        if(side == Side.Sx) {this.armSx = newArm;} 
        else {this.armDx = newArm;}
    }

    public Arm getArmSx() {
        return armSx;
    }

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public void attacca()
    {
        this.armDx.attacca();
        this.armSx.attacca();
        this.armSx.attacca();
        this.armDx.attacca();
        if(this.moveable instanceof Tank) { 
            Tank t = (Tank) moveable;
            t.attacca();  //castare moveable in Tank perché il metodo attacca() non è definito
        }
    }
    
    public void muovitiAvanti()
    { this.moveable.muovitiAvanti();}
    
    public void muovitiIndietro()
    { this.moveable.muovitiIndietro();}
}
