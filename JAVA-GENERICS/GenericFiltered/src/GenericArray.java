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
    
    public List<T> isPrime()
    {
        List<T> result = new ArrayList<T>();
        // Un numero è primo quando è divisibile per se stesso
        // Quando non è divisibile per tutti i numeri che vanno da 2 a n - 1
        
        return result;
    }
    
    public boolean isPrime(Integer num)
    {
        for (int i = 2; i < num / 2; i++) {
            //se il numero che sto controllando viene diviso dall'indice, allora ritorna false
            if(num % i == 0) return false;
        }
        return true;
    }
}