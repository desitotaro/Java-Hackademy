public class App {
    public static void main(String[] args) throws Exception {
        GroceryFactory groc = new GroceryFactory();
        Fruit fr = groc.instanceCasting(GroceryComponentType.Fruit, Fruit.class);
        Vegetable veg = groc.instanceCasting(GroceryComponentType.Vegetable, Vegetable.class);

        Grocery shop = new Grocery(fr, veg);
        
    }
}
