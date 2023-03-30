import java.util.List;
import java.util.ArrayList;

public class GenericClass<T extends Comparable<T>>{
    
    T[] myArr; 
    T min;
    T max;
    
    public GenericClass(T[] myArr, T min, T max) {
        this.myArr = myArr;
        this.min = min;
        this.max = max;
    }


    public List<T> minAndMax(){
        //(1)Scrivere una classe generica che prenda in input un array e altri 
        //(2)due parametri interi che fungeranno da indice superiore e indice 
        //inferiore e ritorni un (3)sottoarray nel range indice inferiore indice 
        //superiore
        List<T> result = new ArrayList<T>();
        for(T item : myArr)
        {
            if(item.compareTo(min) > 0 && item.compareTo(max) < 0) result.add(item);
        }
        return result;
    }



}
