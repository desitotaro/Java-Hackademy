abstract public class Vehicle {
    String name;
    String color;
    Engine engine;
    
    public Vehicle(String name, String color, Engine engine) {
        this.name = name;
        this.color = color;
        this.engine = engine;
    }

    abstract void start();
    abstract void stop();
    abstract void accelera();
    abstract void decelera();
    
}
