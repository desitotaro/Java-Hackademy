import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        // (1) Array sort
        Integer[] ints = new Integer[]{8,4,2,6,7,10};
        Arrays.sort(ints, (a,b) -> Integer.compare(a, b));
        // (1.1) mostra i numeri con ciclo for
        for(Integer i : ints)
        {
            System.out.println(i);
        }
        // (1.2) crea una lista ordinata a partire da ints e stampala
        List.of(ints).stream().forEach(el -> System.out.println(el));
        
        // (2) Array sort con una join 
        String[] names = new String[]{"Desi", "Marco", "Luca", "Andrea"};
        Arrays.sort(names, (a,b) -> a.length() - b.length());
        System.out.println(String.join(",", names));
        
        //(3) Creiamo un array di persone con classe Persona
        Persona[] people = new Persona[]{
            new Persona(24, "Pippo", "Disney"),
            new Persona(48, "Pluto", "Disney"),
            new Persona(35, "Mickey", "Disney"),
        };
        
        Arrays.sort(people, (a,b) -> a.getAge() - b.getAge());
        System.out.println(Arrays.toString(people));

        //(4) Sort con il Compare, il risultato è lo stesso
        Persona[] people1 = new Persona[]{
            new Persona(24, "Pippo", "Disney"),
            new Persona(48, "Pluto", "Disney"),
            new Persona(35, "Mickey", "Disney"),
        };
        Arrays.sort(people1, Comparator.comparing(a -> a.getAge()));
        System.out.println(Arrays.toString(people1));

        //(5) Possiamo creare anche noi il nostro comparatore
        Persona[] people2 = new Persona[]{
            new Persona(24, "Pippo", "Disney"),
            new Persona(48, "Pluto", "Disney"),
            new Persona(35, "Mickey", "Disney"),
        };
        Arrays.sort(people2, MyComparator.reverse((a,b) -> a.getAge() - b.getAge()));
        System.out.println(Arrays.toString(people2));
        
    }
}
