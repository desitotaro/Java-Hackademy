public class SensorExternalTempGetter implements PropertyGetter {
    public double getDoubleProperty(Object obj)
    {
        // L'interfaccia mi dice che posso implementare una funzione che prende un oggetto
        // e restituisce un double. Questa è l'implementazione per l'interfaccia sull'oggetto
        // sensor, e quando creerò un'altra classe simile a Sensor potrò utilizzarla anche 
        // sull'altra classe.
        Sensor s = (Sensor) obj;
        return s.getExternalTemp();
    }
}
