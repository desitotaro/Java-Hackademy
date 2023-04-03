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
        
        
        
        System.out.println("Sensori " + averageExternalTemp(sensors, new SensorExternalTempGetter()));
        System.out.println("Termometri " + averageExternalTemp(therms, new ThermometerExternalTempGetter()));
    }
    
    // Versione brutta
    /*  double sum = 0;
    for(Sensor sensor : sensors)
    {
        sum += sensor.getExternalTemp();
    }
    
    System.out.println("La temperatura media esterna è di" + (sum / sensors.length) + " gradi"); */
    

    public static double averageExternalTemp(Sensor[] sensors, PropertyGetter pGetter)
    {
        double sum = 0;
        for(Sensor sensor : sensors)
        {
            sum += pGetter.getDoubleProperty(sensor);
            // non ho effettuato l'accesso diretto all'oggetto sensor, ma l'ho fatto fare 
            // ad una classe che implementa l'interfaccia PropertyGetter, prende un 
            // oggetto e restituisce un double. 
        }
        return (sum / sensors.length);
    }
    
    public static double averageExternalTemp(Thermometer[] therms, PropertyGetter pGetter)
    {
        //gli passo un altro tipo di dato, ma le funzioni sono le stesse
        double sum = 0;
        for(Thermometer therm : therms)
        {
            sum += pGetter.getDoubleProperty(therm);
        }
        return (sum / therms.length);
    }
}
