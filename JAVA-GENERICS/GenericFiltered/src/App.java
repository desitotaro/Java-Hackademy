import java.util.List;
public class App {
    public static void main(String[] args) throws Exception {
        
        //scrivere una classe generica che prenda in input un array e 
        //implementi dei metodi che ritornino degli elementi filtrati in 
        //base a delle caratteristiche ( numeri pari, numeri dispari, numeri primi )
        
        GenericArray<Integer> myArr = new GenericArray<Integer>(new Integer[]{
        1,
        45,
        32,
        67,
        88,
        10,
        9
        });
        
        List<Integer> evenList = myArr.onlyEven();
        System.out.println("Numeri pari : " + evenList);
        List<Integer> oddList = myArr.onlyOdd();
        System.out.println("Numeri dispari : " + oddList); 
    }
}
