
import java.util.Set;
import java.util.TreeSet;
public class App {
    public static void main(String[] args) throws Exception {
       
        Set<Integer> number = new TreeSet<Integer>(
            Set.of(7,9,3,2,1,5,6)
        );

        // Me li ordina in automatico
        System.out.println(number);

        Set<String> names = new TreeSet<String>(
            Set.of("Desi", "Andrea", "Marco", "paolo")
        );

        System.out.println(names);

        // Pointer3DComparator
        Set<Pointer3D> points = new TreeSet<Pointer3D>(new Pointer3DCompare());
        points.addAll(Set.of(
          new Pointer3D(0, 0, 0),
          new Pointer3D(5, 5, 5),
          new Pointer3D(2, 2, 2),
          new Pointer3D(1, 1, 1)
          )
      );

      for(Pointer3D p : points){
        System.out.println(p.print());
      }

    }
    
}