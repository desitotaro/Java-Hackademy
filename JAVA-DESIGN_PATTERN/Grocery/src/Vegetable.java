public class Vegetable implements CanBeBought{
   
    private String name;

    public Vegetable(String name) {
        this.name = name;
    }

    public void buy() {System.out.println("Ho comprato della verdura");}
}
