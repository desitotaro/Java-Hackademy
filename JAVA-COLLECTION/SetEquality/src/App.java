import java.util.Set;
public class App {
    public static void main(String[] args) throws Exception {
        
        Pointer3D p1 = new Pointer3D(10, 20, 30);
        Pointer3D p2 = new Pointer3D(5, 5, 5);
        Pointer3D p3 = new Pointer3D(20, 30, 40);
        Pointer3D p4 = new Pointer3D(20, 30, 40);
        
        Set<Pointer3D> points = Set.of(
        p1,
        p2,
        p3,
        p4
        );
        
        // (1) equals in obj
        /* System.out.println(p3.equals(p4)); */
        // (2) hashCode
        /* System.out.println(new Pointer3D(0, 0, 0).hashCode());
        System.out.println(new Pointer3D(0, 0, 0).hashCode()); */
    }
}
