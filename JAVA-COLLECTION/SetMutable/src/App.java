import java.util.HashSet;
import java.util.Set;
public class App {
    public static void main(String[] args) throws Exception {
        
        Pointer3D p1 = new Pointer3D(10, 20, 30);
        Pointer3D p2 = new Pointer3D(40, 50, 60);
        Pointer3D p3 = new Pointer3D(70, 80, 90);
        
        HashSet<Pointer3D> points = new HashSet<Pointer3D>(
        Set.of(
        p1,p2,p3 
        )
        );
        
        points.add(new Pointer3D(2, 3, 4));
        
        for(Pointer3D p : points)
        {
            System.out.println(p.print());
        }
    }
    
}