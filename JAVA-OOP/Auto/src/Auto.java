import java.util.Scanner;
public class Auto {
    
    //ATTRIBUTI
    private String name;
    private String color;
    private int price;
    private int rata = 0;  
    
    //CONSTRUCTOR
    public Auto(String name, String color, int price) {
        this.setName(name);
        this.setColor(color);
        this.setPrice(price);
    }
    
    //GETTER
    public String getName() { return this.name; }
    public String getColor() { return this.color; } 
    public int getPrice() { return this.price; } 
    public int getRata() {return this.rata; }
    
    //SETTER 
    public void setName(String name) { this.name = name; }
    
    public void setColor(String color) {
        if (!color.equals("Bianca") && !color.equals("Nera") && !color.equals("Grigia")) {
            System.out.println("Non è un colore esistente");
        } else { 
            this.color = color;  
        }
    }
    
    public void setPrice(int price) { 
        if(price < 1000) { System.out.println("Il prezzo deve essere superiore"); } else { this.price = price; }
    }
    
    public void setRata()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("In quanti mesi vuoi pagare la macchina?");
        int mesi = sc.nextInt();
        this.rata = (rata + price) / mesi;
        System.out.println("Pagherai " + this.rata + " all'anno");
    } 
    
    
    // OVERRIDE DEL METODO EQUALS SOLO SU OBJECTS 
    @Override
    public boolean equals(Object myObj){ 
        if(this == myObj) return true;
        if(myObj == null || this.getClass() != myObj.getClass()) return false;
        Auto other = (Auto) myObj;
        if(this.name == other.name &&
        this.color == other.color &&
        this.price == other.price) return true;
        
        return false;
    }
    
    //Prezzo della macchina a rate
    
    
}
