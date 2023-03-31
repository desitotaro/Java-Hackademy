public class JeegFactoryPrototype {
    // ANNOTATION
    @SuppressWarnings("unchecked")
    // ritorna l'oggetto già castato
    // usiamo il metodo generic
    public <T> T instanceCasting(JeegComponentType componentType, Class<T> classType)
    {
        Object component = null;
        switch(componentType)
        {
            case Legs: 
            component = new Legs();
            break;
            case Tank:
            component = new Tank();
            break;
            case LanciaMissiliDx:
            component = new LanciaMissili("Destro");
            break;
            case LanciaMissiliSx:
            component = new LanciaMissili("Sinistro");
            break;
            case LaserDx:
            component = new Laser("Destro");
            break;
            case LaserSx:
            component = new Laser("Sinistro");
            break;
        }
        
        return (T) component; //sarebbe es. return (Legs) component > CASTING 
        //Ci avvisa che non è sicura questa cosa, perché
        // cerchiamo di castare un Object che il programma non conosce ancora.
        // Lo stiamo scrivendo noi il codice, siamo sicuri sia giusto, facciamo una 
        // soppression del warning.
    }
}
