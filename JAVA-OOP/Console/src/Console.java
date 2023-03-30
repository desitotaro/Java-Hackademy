public class Console {
    
    private String name;
    private int price;
    private int quantity;
    
    public Console(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    //GETTER
    public String getName() { return this.name; }
    public int getPrice() { return this.price; } 
    public int getQuantity() { return this.quantity; } 

    
    //SETTER 
    public void setName(String name) {this.name = name;}
    public void setPrice(int price) {if (price != this.price) { System.out.println("Non puoi cambiare il prezzo!"); } else { this.price = price; }}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void addQuantity(int num) {
        setQuantity(this.quantity + num);
    }
    
    @Override
    public boolean equals(Object myObj){ 
        if(this == myObj) return true;
        if(myObj == null || this.getClass() != myObj.getClass()) return false;
        Console other = (Console) myObj;
        if(this.name == other.name &&
        this.price == other.price) return true;
        
        return false;
    }
    
    
    
    
}
