import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // Dati dei triangoli, calcolarne l'area
        List<Equilatero> equilateri = List.of(
        new Equilatero(2, 2),
        new Equilatero(3, 2),
        new Equilatero(4, 2),
        new Equilatero(5, 2)
        );
        
        double risultato = getArea(equilateri);
        System.out.println(risultato);
    }
    
    public static<T> double getArea(List<T> triangles) 
    //Non passiamo più la propertyGetter perché abbiamo dichiarato entrambe le propertyGetter dentro la funzione.
    {
        double result = 0;
        for(T triangle : triangles)
        {
            double height = getValue(triangle, new HeightPropertyGetter());
            double base = getValue(triangle, new BasePropertyGetter());
            result += (base * height)/2; 
        }
        return result;
    }
    
    public static<T> double getValue(T triangle, PropertyGetter prop)
    {
        //generalizzazione del valore -> height se passo HeightPropertyGetter o viceversa
        return prop.getDoubleProperty(triangle);
    }

}
