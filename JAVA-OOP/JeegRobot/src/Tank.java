public class Tank extends Moveable implements CanAttack{
    
    @Override
    public void goBack() {
        System.out.println("Mi muovo indietro con i cingoli");
    }
    
    @Override
    public void goForward() {
        System.out.println("Mi muovo in avanti con i cingoli");  
    }

    public void attack() {
        System.out.println("Ti sparo con il Tank");
    }
    
}
