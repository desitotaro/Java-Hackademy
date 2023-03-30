public class Restaurant {
    
    private String name;
    private Dish[] dishes;
    private Drink[] drinks;

    public Restaurant(String name, Dish[] dishes, Drink[] drinks) {
        this.name = name;
        this.dishes = dishes;
        this.drinks = drinks;
    }

    public void stampaMenu()
    {
        for (Dish dish: dishes) {
            System.out.println(dish.getName() + " , " + dish.getPrice() + " euro");
        }

        for (Drink drink: drinks) {
            System.out.println(drink.getName() + " , " + drink.getPrice()+ " euro");
        }
        
    }

    public String getName() { return name; };
    public Dish[] getDishes() { return dishes; };
    public Drink[] getDrinks() { return drinks;};

    public void setDishes(Dish[] dishes) { this.dishes = dishes;}
    public void setDrinks(Drink[] drinks) { this.drinks = drinks;}
    public void setName(String name) { this.name = name; }

}
