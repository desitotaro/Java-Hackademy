import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Person> people = new ArrayList<Person>(); //dichiarazione Lista vuota, ricorda di importare List
        // OPERAZIONI
        // (1) add
        people.add(new Person("Desi", "Totaro", 24));
        people.add(new Person("Marco", "Rossi", 22));
        people.add(new Person("Mario", "Bianchi", 35));
        // per accedere ad un singolo elemento:
        // - Metodo lungo
        /*Iterator<Person> it = people.iterator();
            while(it.hasNext()){
            Person p = it.next(); 
            System.out.println(p.getName()); 
            }
        */
        // - Ciclo for
        for(Person p : people)
        {
            System.out.println(p.getName());
        }

        // (2) set
        people.set(1, new Person("Stefano", "Rossi", 20));
        for(Person p : people)
        {
            System.out.println(p.getName());
        }

        // (3) remove
        people.remove(0);
        for(Person p : people)
        {
            System.out.println(p.getName());
        }
        
        // (4) clear, elimina tutto
        people.clear();

    }
}
