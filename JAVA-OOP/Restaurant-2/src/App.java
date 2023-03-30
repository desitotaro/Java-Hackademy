public class App {
    public static void main(String[] args) throws Exception {

        Dish d1 = new Dish("Carbonara", 12, new String[] {"Pasta", "Uova", "Guanciale", "Pepe"});
        Dish d2 = new Dish("Pasta all'uovo", 12, new String[] {"Pasta", "Salsa", "Mozzarella", "Pepe"});
        Drink b1 = new Drink("Acqua", 2);
        Drink b2 = new Drink("Vino", 5); 
        Drink b3 = new Drink("Coca-Cola", 3);

        // metto tutto in un array, sia piatti che bevande
        Dish[] dishes = new Dish[] {d1,d2};
        DishCollection dc = new DishCollection(dishes);
        Drink[] drinks = new Drink[] {b1,b2, b3};
        DrinkCollection ds = new DrinkCollection(drinks);

        // ora posso creare il ristorante    
        System.out.println("Menu di oggi");   
        Restaurant r = new Restaurant("McJava", dc, ds);
        r.stampaMenu();

        d1 = new Dish("Risotto crema di scampi", 15, new String[] {"Riso", "Scampi", "Concentrato di Pomodoro"});
        d2 = new Dish("Tagliata di manzo", 15, new String[] {"Manzo", "Rucola", "Pomodorini"});
        dc = new DishCollection(new Dish[]{d1, d2});
        r = new Restaurant("McJava", dc, ds);
        System.out.println("Menu di domani");
        r.stampaMenu();
    }
}
