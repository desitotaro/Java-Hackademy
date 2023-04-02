import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        
        //(1) Creare delle set con e senza ripetizioni con oggetti custom che 
        //siano diversi da quelli visti a lezione, (2) sovrascrivere la funzione equals e 
        //hashcode.
        
        Triangle t1 = new Triangle(3, 5);
        Triangle t2 = new Triangle(4, 5);
        Triangle t3 = new Triangle(6, 5);
        Triangle t4 = new Triangle(8, 5);
        Triangle t5 = new Triangle(8, 5); // duplicate element
        //Triangle t5 = t4; // NON CONSENTITO
        //System.out.println(t4.equals(t5)); // true
        System.out.println(t4.hashCode());
        System.out.println(t5.hashCode());
        
        Set<Triangle> triangles = Set.of(
        t1,
        t2,
        t3,
        t4
        );
        
        for(Triangle tr : triangles)
        {
            System.out.println(tr.getArea());
            //System.out.println(tr.hashCode());
        } 
    }
}
