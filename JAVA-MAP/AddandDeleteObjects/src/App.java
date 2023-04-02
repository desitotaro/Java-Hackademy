import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {

        //(1)Scrivere un programma che dichiari una mappa con chiave di tipo
        //string e oggetto a vostra discrezione che prenda in input dei valori, 
        //crei un oggetto e aggiunga l’oggetto alla mappa. 
        
        Car volvo = new Car("Volvo", "1");
        Car audi = new Car("Audi", "2");
        Car polo = new Car("Polo", "3");
        Car panda = new Car("Panda", "4");

        Map<String, Car> cars = new HashMap<String, Car>();
        cars.put(volvo.price, volvo);
        cars.put(audi.price, audi);
        cars.put(polo.price, polo);
        cars.put(panda.price, panda);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto nel nostro portale! Aggiungi la marca della macchina:");
        String name = scanner.nextLine();
        System.out.println("Inserisci il prezzo:");
        String price = scanner.nextLine();
        Car car = new Car(name, price);
        cars.put(car.price, car);
        System.out.println("Macchine nella nostra lista:");
        for(Car item : cars.values())
        {
            System.out.println(item.getName() + " , " + item.getPrice());
        }
        scanner.close();
        
        //(2)Dopo provare a rimuovere l’oggetto e cercare nuovamente l’oggetto nella mappa.
        cars.remove("120");
        for(Car item : cars.values())
        {
            System.out.println(item.getName() + " , " + item.getPrice());
        }

    }
    
}
