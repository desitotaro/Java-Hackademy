public class Laser extends Arm{
  public Laser(String side) { super(side); }
  
  @Override
  public void attack() { System.out.println("Ti attacco con il Laser del braccio " + this.side);}
}
