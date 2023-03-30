public class Car extends Vehicle{

    int doors;

    public Car(String name, String color, Engine engine, int doors) {
        super(name, color, engine);
        this.setDoors(doors);
    }

/*     public void accendiAuto()
    {
        this.engine.on();
    }

    public void spengiAuto()
    {
        this.engine.off();
    }

    public void accelera()
    {
        this.engine.increaseSpeed();
    }

    public void decelera()
    {
        this.engine.decreaseSpeed();
    } */
    public void setDoors(int doorsNumber) 
    {
        if(doorsNumber < 3 || doorsNumber > 5) {
            System.out.println("Non ci sono auto con meno di 3 o più di 5");
        } else {
        this.doors = doorsNumber;
        }
    }
    public void start()
    {
        this.engine.on();
    }

    public void stop()
    {
        this.engine.off();
    }

    public void accelera()
    {
        this.engine.increaseSpeed();
    }

    public void decelera()
    {
        this.engine.decreaseSpeed();
    }
}
