abstract public class Engine {
    
    private String name;
    private int cc;
    private int hp;

    public Engine(String name, int cc, int hp) {
        this.name = name;
        this.cc = cc;
        this.hp = hp;
    }

    public abstract void on(); 
    public abstract void off(); 
    public abstract void increaseSpeed();
    public abstract void decreaseSpeed();


}
