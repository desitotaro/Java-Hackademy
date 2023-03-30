
public class AlgorithmArray {
    
    //(1)Vogliamo prendere il valore minore all'interno dell'array, che è il primo [0]
    // Avendo fatto due funzioni uguali, dove cambia solo il tipo di dato che accetta,
    // sto violando il concetto DRY
    /*     public static String min(String[] values)
    {
        if(values == null || values.length == 0) return null; // se l'array è vuoto non posso calcolare il min
        String min = values[0];
        
        for(String item : values){
            if(item.compareTo(min) < 0){
                min = item;
            }
        }
        return min;
    }
    
    public static Integer min(Integer[] values) //prende un array di interi di nome values
    {
        if(values == null || values.length == 0) return null;
        Integer min = values[0];
        for(Integer item : values)
        {
            if(item.compareTo(min) < 0) min = item;
        }
        return min;
    } */
    
    // CREO UNA GENERALIZZAZIONE 
    
    public static <T extends Comparable<T>> T min(T[] values){ 
        if(values == null || values.length == 0) return null;
        T min = values[0];
        for(T item : values)
        {
            if(item.compareTo(min) < 0) min = item;
        }
        return min;
    }
    
    public static <T extends Comparable<T>> T max(T[] values)
    {
        if(values == null || values.length == 0) return null;
        T max = values[0];
        for(T item : values)
        {
            if(item.compareTo(max) > 0) max = item;
        }
        return max;
    }

}
