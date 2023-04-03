import java.util.Comparator;

public class MyComparator {
    public static <T> Comparator<T> reverse(Comparator<T> comp)
    {
        //implementiamo una lambda che rispetti la comparazione
        //per ora ordina come tutti gli altri 
        //return (a,b) -> comp.compare(a, b);
        // ora lo facciamo reverse, basta mettere -1 * 
        return (a,b) -> -1 * comp.compare(a, b);
        
    }
}
