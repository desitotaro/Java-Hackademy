import java.util.HashMap;
import java.util.Set;
import java.util.Map;
public class App {
    public static void main(String[] args) throws Exception {

        Map<String, Person> rubrica = new HashMap<String, Person>();
        Person desi = new Person("Desi", "Totaro", "TTRDSR");
        rubrica.put(desi.cf, desi);
        Person mario = new Person("Mario", "Rossi", "MRIRSS");
        rubrica.put(mario.cf, mario);

        Set<String> keySet = rubrica.keySet();
        for(String key : keySet)
        {
            System.out.println(rubrica.get(key).name);
        }

        rubrica.remove(mario.cf);
    }
}
