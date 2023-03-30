public class App {
    public static void main(String[] args) throws Exception {
        
      /*   Engine engine = new Engine("V4", 100, 60); */
/*         Car car = new Car("Panda", "Bianco", 3, engine);
        car.accendiAuto();
        car.accelera();
        car.decelera();
        car.spengiAuto(); */

        Engine engine = new MotoEngine("V4", 1000, 60, "Ad aria");
        Engine engine2 = new AutoEngine("V4", 3000, 400, 6);
        Car car = new Car("M3", "Blu", engine2, 6);
        car.accelera();
        Moto moto = new Moto("R1", "Blu", engine, "nero", false);
        moto.decelera();
    }
}
