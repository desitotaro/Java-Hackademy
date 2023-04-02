public class Grocery {
    
    private Fruit fruit;
    private Vegetable vegetable;
    
    public Grocery(Fruit fruit, Vegetable vegetable) {
        this.fruit = fruit;
        this.vegetable = vegetable;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

}
