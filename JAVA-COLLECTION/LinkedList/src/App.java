import java.util.List;
import java.util.LinkedList;
public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Person> people = new LinkedList<Person>(
            List.of(
                new Person("Andrea", "Mininni", 29),
                new Person("Cosimo", "Di Lorenzo", 26),
                new Person("Riccardo", "Fusco", 19)
            )
        );

        System.out.println(people.get(2).getName());
        for(Person p : people){
            System.out.println(p.getName());
        }
        
        // (1) addFirst
        people.addFirst(new Person("Pippo", "Pippo", 20));
        for(Person p : people){
            System.out.println(p.getName());
        }

        // (2) add
        people.add(2, new Person("Gianni", "Bianco", 50));
        for(Person p : people){
            System.out.println(p.getName());
        }
    }
}
