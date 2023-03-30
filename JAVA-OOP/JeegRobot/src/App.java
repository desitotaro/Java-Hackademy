public class App {
    public static void main(String[] args) throws Exception {
        
        Arm armDx = new LanciaMissili("Destro");
        Arm armSx = new Trivella("Sinistro"); // Trivella extends Arm, nella generalizzazione
                                                // posso usare anche il figlio di Arm > polimorfismo e composition
        //Moveable legs = new Propulsori();
        Moveable legs = new Tank();
        Jeeg jeeg = new Jeeg(armDx, armSx, legs); //potevamo farte anche inline variable
        
        jeeg.goForward();
        jeeg.attack();
        jeeg.goBack();

/*         Jeeg jeeg2 = new Jeeg(new Trivella("Destro"), new Laser("Sinistro"), new Legs());
        jeeg.goForward();
        jeeg.attack();
        jeeg.goBack(); */
    }
}
