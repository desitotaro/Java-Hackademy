import java.util.List;
public class App {
    public static void main(String[] args) throws Exception {
        
        //(1)Scrivere una classe generica che prenda in input un array e altri 
        //(2)due parametri interi che fungeranno da indice superiore e indice 
        //inferiore e ritorni un (3)sottoarray nel range indice inferiore indice 
        //superiore
        
        GenericClass<Integer> myList = new GenericClass<Integer>(new Integer[]{
            2,
            3,
            54,
            98,
            1,
            32,
            40,
            43,
            10}, 1, 54);
            
            List<Integer> numbers = myList.minAndMax();
            System.out.println(numbers);
            for(Integer item : numbers)
            {
                System.out.println(item);
            }
            
            
            GenericClass<String> strList = new GenericClass<String>(new String[]{
                "Andrea",
                "Franco",
                "Giovanni",
                "Pippo",
                "Desi",
                "Gianvito",
                "Alfredo",
                "Zorro"
            }, "Andrea", "Pippo");
            
            List<String> stringhe = strList.minAndMax();
            System.out.println(stringhe);
            for(String item : stringhe)
            {
                System.out.println(item);
            }
            
        }
    }
    