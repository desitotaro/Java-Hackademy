public class JeegFactory {
    // questa classe ritornerà gli oggetti con cui creo Jeeg tramite una funzione
    
    public Object instance(JeegComponentType componentType) 
    // deve ritornare, ma cosa? inseriamo un Object generico, che parte da null e poi torna in component
    // esempio, gli passo Legs > mi ritorna un oggetto di classe laser
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
            // Arm non è istanziabile, non posso creare un Arm generico
        }

        return component;
    }
}
