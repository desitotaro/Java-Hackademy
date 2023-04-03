public class HeightPropertyGetter implements PropertyGetter{
    @Override
    public <T extends Triangolo> double getDoubleProperty(Object obj)
    {
        T casted = (T) obj;
        return casted.getHeight();
    }
}
