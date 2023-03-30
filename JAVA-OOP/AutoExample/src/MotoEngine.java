public class MotoEngine extends Engine{
     String cooling;
    
    public MotoEngine(String name, int cc, int hp, String cooling) {
        super(name, cc, hp);
        this.cooling = cooling;
    }

    @Override
    public void on() {
        System.out.println("Accendo il motore della moto");
    }

    @Override
    public void off() {
        System.out.println("Spengo il motore della moto");
    }

    @Override
    public void increaseSpeed() {
        System.out.println("Accelero con la moto");
    }

    @Override
    public void decreaseSpeed() {
        System.out.println("Decelero con la moto e il motore si raffredda " + this.cooling);
    }

   

}
