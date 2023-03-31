public class App {
    public static void main(String[] args) throws Exception {
// Per creare ora un oggetto e NON preoccuparmi del casting, devo usare
// la classe JeegFactoryPrototype
    JeegFactoryPrototype factory = new JeegFactoryPrototype();
    LanciaMissili lm = factory.instanceCasting(JeegComponentType.LanciaMissiliDx, LanciaMissili.class);
    Laser laser = factory.instanceCasting(JeegComponentType.LaserSx, Laser.class);
    Legs legs = factory.instanceCasting(JeegComponentType.Legs, Legs.class);    
    Jeeg j = new Jeeg(lm, laser, legs);
    j.muovitiAvanti();
    j.attacca();
    j.muovitiIndietro();

// SPRECO DI MEMORIA! Dobbiamo trovare un modo per generare un oggetto SOLO se non c'è un altro 
// oggetto con stessi attributi già salvato in memoria 

/*     LanciaMissili lm2 = factory.instanceCasting(JeegComponentType.LanciaMissiliDx, LanciaMissili.class);
    Laser laser2 = factory.instanceCasting(JeegComponentType.LaserSx, Laser.class);
    Tank tank = factory.instanceCasting(JeegComponentType.Tank, Tank.class);
    Jeeg j2 = new Jeeg(lm2, laser2, tank);
    j2.muovitiAvanti();
    j2.attacca();
    j2.muovitiIndietro();*/
} 
}
