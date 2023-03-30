public class AutoEngine extends Engine{
    int numeroCilindri;

    public AutoEngine(String name, int cc, int hp, int numeroCilindri) {
        super(name, cc, hp);
        this.numeroCilindri = numeroCilindri;
    }

    @Override
    public void on() {
       System.out.println("Accendo il motore della macchina");
    }

    @Override
    public void off() {
       System.out.println("Spengo il motore della macchina");
    }

    @Override
    public void increaseSpeed() {
        System.out.println("Accelero la macchina tramite i miei" + numeroCilindri + " cilindri");
    }

    @Override
    public void decreaseSpeed() {
       System.out.println("Decelero la macchina");
    }

    
}
