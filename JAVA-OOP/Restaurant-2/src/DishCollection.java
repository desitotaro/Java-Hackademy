public class DishCollection {
    
    Dish[] dishes;
    
    public DishCollection(Dish[] dishes) {
        this.dishes = dishes;
    }
    
    public void stampaPiatti(){
        System.out.println("I nostri piatti sono :");
        for(Dish d : dishes)
        {
            System.out.println(d.getName() + ": euro " + d.getPrice());
        }
    }
}
