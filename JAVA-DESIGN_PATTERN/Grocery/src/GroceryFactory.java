public class GroceryFactory{
    @SuppressWarnings("unchecked")    
    
    public <T> T instanceCasting(GroceryComponentType componentType, Class<T> classType)
    {
        Object shopped = null;
        switch(componentType)
        {
            case Fruit:
            shopped = new Fruit("Mela");
            break;
            case Vegetable:
            shopped = new Vegetable("Carota");
            break;
        }
        return (T) shopped;
    }

}
