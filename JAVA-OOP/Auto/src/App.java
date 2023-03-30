import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        
        // Equals to
        Auto auto1 = new Auto("Bmw", "Bianca", 30000, 0);
        Auto auto2 = new Auto("Bmw", "Bianca", 30000, 0);
        
        System.out.println(auto1.equals(auto2)); /*returns true */
        /*System.out.println(auto1.name);  returns to not visible */
        
        System.out.println(auto1.getName());
        System.out.println(auto2.getPrice()); 
        
        // Faccio il controllo sulla possibilità che la stringa "Rossa" possa essere inserita, 
        // non sto facendo il controllo su un OGGETTO!
        auto2.setColor("Rossa"); /* returns to not existing color */
        System.out.println(auto2.getColor()); /* returns to "Bianca" */
        auto2.setPrice(35000);
        System.out.println(auto2.getPrice());
        
        Auto auto3 = new Auto("Panda", "Rossa", 12000, 0);
        /* auto3.setRata(); */
       
    }
}

