public class LanciaMissili extends Arm{

    public LanciaMissili(String side) {
        super(side);
    }
    
    @Override
    public void attack() {System.out.println("Ti lancio un missile dal braccio " + this.side);}
}
