public class ThermometerExternalTempGetter implements PropertyGetter{
    public double getDoubleProperty(Object obj)
    {
        Thermometer t = (Thermometer) obj;
        return t.getExternalTemp();
    }
}
