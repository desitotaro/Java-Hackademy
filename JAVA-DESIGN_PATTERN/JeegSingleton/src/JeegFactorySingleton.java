import java.util.HashMap;
import java.util.Map;
public class JeegFactorySingleton {
   
    // (1) controllare ad ogni richiesta di un nuovo componente se 
    // questo è presente già in memoria, creo una Map con Oggetto JeegCompType e un
    // oggetto generico, perché ogni volta sarà diverso. E' come se fosse un registro 
    // di memoria per controllare che non ci siano altri oggetti uguali. 
    private Map<JeegComponentType, Object> registry = new HashMap<JeegComponentType, Object>();

    public Object instance(JeegComponentType componentType) 
    {
        switch(componentType)
        {
            case Legs: 
            //prima di restituire Legs, controllo se esiste già nel mio registro
            // se registry non contiene una chiave Legs contenuta nell'oggetto JeegCompType
            // lo devi creare e aggiungere alla Map, se esiste devi restituirmi quello che già c'è nel registro
            if(!registry.containsKey(componentType)) { registry.put(componentType, new Legs()); }
            break;
            case Tank: 
            if(!registry.containsKey(componentType)) { registry.put(componentType, new Tank()); }
            break;
            case LanciaMissiliDx: 
            if(!registry.containsKey(componentType)) { registry.put(componentType, new LanciaMissili("Destro")); }
            break;
            case LanciaMissiliSx: 
            if(!registry.containsKey(componentType)) { registry.put(componentType, new LanciaMissili("Sinistro")); }
            break;
            case LaserDx: 
            if(!registry.containsKey(componentType)) { registry.put(componentType, new Laser("Destro")); }
            break;
            case LaserSx: 
            if(!registry.containsKey(componentType)) { registry.put(componentType, new Laser("Sinistro")); }
            break;

        }
        
        return registry.get(componentType); // Se esiste già ritorna al registro dove è già salvato l'oggetto 
    }

}
