public class App {
    public static void main(String[] args) throws Exception {
        var sensors = new Sensor[]{
            new Sensor(37, 55),
            new Sensor(28, 55),
            new Sensor(44, 55),
            new Sensor(25, 55),
            new Sensor(24, 55),
            
        };      
        
        var therms = new Thermometer[]{
            new Thermometer(37),
            new Thermometer(28),
            new Thermometer(44),
            new Thermometer(25),
            new Thermometer(24),
        };
        
        var frigoSensor = new SensoreFrigo[]{
            new SensoreFrigo(37),
            new SensoreFrigo(28),
            new SensoreFrigo(44),
            new SensoreFrigo(25),
            new SensoreFrigo(24),
        };   
        
        // prendi l'oggetto che ti passo, castalo in Sensor o Thermometer e restituisci 
        //externaltemp
        PropertyGetter pGetter = (Object obj) -> ((Sensor) obj).getExternalTemp();  
        PropertyGetter pGetterTherm = (Object obj) -> ((Thermometer) obj).getExternalTemp();
        System.out.println("Sensori " + averageExternalTemp(sensors, pGetter));
        // Potrei anche non instanziare pGetter
        //System.out.println("Sensori " + averageExternalTemp(sensors, (Object obj) -> ((Sensor) obj).getExternalTemp();));
        System.out.println("Termometri " + averageExternalTemp(therms, pGetterTherm));
        System.out.println("Sensori Frigo " + averageExternalTemp(frigoSensor,(Object obj) -> ((SensoreFrigo) obj).getExternalTemp()));
    }

    public static <T> double averageExternalTemp(T[] sensors, PropertyGetter pGetter)
    {
        double sum = 0;
        for(T sensor : sensors)
        {
            sum += pGetter.getDoubleProperty(sensor);
        }
        return (sum / sensors.length);
    }
}
