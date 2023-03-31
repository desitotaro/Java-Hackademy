public class Tank extends Moveable implements CanAttack {

    @Override
    public void muovitiAvanti() { System.out.println("Rotolo in avanti"); }

    @Override
    public void muovitiIndietro() { System.out.println("Rotolo indietro"); }

    @Override 
    public void attacca() { System.out.println("Sparo un missile con il Tank "); }
}
