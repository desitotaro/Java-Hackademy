public class App {
    public static void main(String[] args) throws Exception {
        //DISHES
        Dish dish = new Dish("Lasagna", 9.50);
        Dish dish2 = new Dish("Carbonara", 7.50);
        Dish dish3 = new Dish("Cacio e Pepe", 7.00);
        Dish dish4 = new Dish("Patatine Fritte", 3.00);
        Dish dish5 = new Dish("Polpette al sugo", 8.00);
        Dish dish6 = new Dish("Risotto alla milanese", 8.50);

        //DRINKS
        Drink drink = new Drink("Coca-cola", 1.50);
        Drink drink2 = new Drink("Birra", 3.00);
        Drink drink3 = new Drink("Fanta", 1.30);
        Drink drink4 = new Drink("Sprite", 1.30);
        Drink drink5 = new Drink("Thè alla pesca", 2.50);
        Drink drink6 = new Drink("Chinotto", 2.00);

        //ARRAY OF DISHES AND DRINKS
        Dish[] allDish = new Dish[] {dish, dish2, dish3, dish4, dish5, dish6};
        Drink[] allDrinks = new Drink[] {drink, drink2, drink3, drink4, drink5, drink6};

        //RESTAURANT
        Restaurant restaurant = new Restaurant("Ristorante", allDish, allDrinks);
        restaurant.stampaMenu();
    }
}
