import java.util.ArrayList;
import java.util.List;
public class GenericArray<T> {
    
    T[] parametro;
    
    public GenericArray(T[] parametro) {
        this.parametro = parametro;
    }
    
    public List<T> onlyEven()
    {
        if(this.parametro == null || parametro.length == 0) return null;
        List<T> result = new ArrayList<T>();
        for(T item : parametro)
        {
            if((Integer)item % 2 == 0) result.add(item); //cast
        }
        
        return result;
    }
    
    public List<T> onlyOdd()
    {
        if(this.parametro == null || parametro.length == 0) return null;
        List<T> result = new ArrayList<T>();
        for(T item : parametro)
        {
            if((Integer)item % 2 != 0) result.add(item); //cast
        }
        
        return result;
    }
    
}