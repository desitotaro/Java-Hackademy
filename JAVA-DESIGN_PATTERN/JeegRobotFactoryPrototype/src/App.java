public class App {
    public static void main(String[] args) throws Exception {

     /* LanciaMissili lm = new LanciaMissili("destro");
        Laser laser = new Laser("sinistro");
        Moveable legs = new Legs();
        Jeeg j = new Jeeg(lm, laser, legs); */

    //Uso della FACTORY - devo caricare in memoria un oggetto che mi permetta
    //di lanciare la funzione istance 
        JeegFactory factory = new JeegFactory();
    // ora posso chiedere alla factory di ritornarmi un nuovo oggetto:
    // Non devo più fare la new, chiedo a factory di lanciare il metodo instance e 
    // passo il case, ora mi dà errore perché instance deve RITORNARE UN OGGETTO,
    //usiamo il casting.
    // LanciaMissili lm = factory.instance("LanciaMissiliDx");
    LanciaMissili lm = (LanciaMissili)factory.instance(JeegComponentType.LanciaMissiliDx);
    Laser laser = (Laser)factory.instance(JeegComponentType.LaserSx);
    Legs legs = (Legs)factory.instance(JeegComponentType.Legs);    
    Jeeg j = new Jeeg(lm, laser, legs);
    j.muovitiAvanti();
    j.attacca();
    j.muovitiIndietro();

    }
}
