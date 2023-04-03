public class App {
    public static void main(String[] args) throws Exception {
        // Dati dei sensori, prenda la temperatura esterna da ognugno
        // di essi e ritorni la temperatura media
        // creiamo una lista o array di sensori che inizializziamo
        
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
        
        

        // quando uso i sensori, passo SensorExternal, quando uso i termometri uso ThermometrerExternal,
        // la funzione va comunque
        System.out.println("Sensori " + averageExternalTemp(sensors, new SensorExternalTempGetter()));
        System.out.println("Termometri " + averageExternalTemp(therms, new ThermometerExternalTempGetter()));
    }
    
// Dopo aver creato un'astrazione su come accediamo al dato dei sensori, la funzione getDouble property,
// andiamo ad astrarre anche il tipo di dato, che sarà generico. 
// ora farà il casting automatico di sensors (T[] sensors)
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
