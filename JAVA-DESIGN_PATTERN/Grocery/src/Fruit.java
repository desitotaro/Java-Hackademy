public class Fruit implements CanBeBought {
    
    private String name;
    
    public Fruit(String name) {
        this.name = name;
    }
    
    public void buy() {System.out.println("Ho comprato della frutta");}
    // FACTORY > List (all'interno frutta / verdura generata )
    // Oggetto > "Mela" | equals() hashcode ? : lo devo aggiungere  
}
