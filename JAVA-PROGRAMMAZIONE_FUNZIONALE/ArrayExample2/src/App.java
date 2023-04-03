import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) throws Exception {
       //(1) Filtrare le parole in base alla lunghezza
        List<String> wordList = Arrays.asList("parolauno", "Andrea", "ciao", "pippo", "parolalunga", "test", "miotest");
        List<String> paroleLunghe = wordList.stream().filter(word -> word.length() > 4).toList();
        // funziona anche con le liste!
        System.out.println(String.join("," , paroleLunghe));

        //(2) Funzione di ordine superiore che prenda in input la lista da filtrare ed una lambda
        //che contenga la logica per cui devo filtrare
        // indexOf ritorna l'indice da dove parte una determinata stringa, quindi se test = 0,
        // mi ritornerà solo miotest.
        List<String> filtered = filter(wordList, a -> a.indexOf("test") > 0);
        System.out.println(String.join(",", filtered));
    }
    
    // prende in input i values della Lista da filtrare ed una lambda che rispetti un predicato
    // che ora non abbiamo, quindi creiamo un'interfaccia che generalizzi il predicato stesso. 
    public static <T> List<T> filter(List<T> values, Predicate<T> p)
    {
        List<T> result = new ArrayList<>();
        for(T value : values)
        { // se la funzione sul predicato ritorna true, aggiungi a result value
            // p test è una qualsiasi lambda che passiamo noi
            if(p.test(value)) result.add(value);
        }
        return result;
    } 
}
