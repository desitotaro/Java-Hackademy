public class Laser extends Arm {

    public Laser(String side) {
        super(side);
    }

    @Override
    public void attacca() { System.out.println("Brucio il nemico con il Laser " + this.side); }
    
}
