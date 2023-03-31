public abstract class Arm implements CanAttack {
    
    protected String side;
    
    public Arm(String side) {
        this.side = side;
    }

    //avendo messo classe astratta 
    /* public void attacca()
    {System.out.println("Ti attacco con il braccio " + this.side);} */

    public abstract void attacca();
    
}
