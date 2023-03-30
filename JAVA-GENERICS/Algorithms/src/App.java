public class App {
    public static void main(String[] args) throws Exception {
        
        String[] nomi = new String[] {
            "Giancarlo",
            "Marco",
            "Paolo",
            "Luca",
            "Giulia",
            "Franco"
        };
        
        // Non abbiamo di fare la new perché è funzione statica
        String nomeMinimo = AlgorithmArray.min(nomi);
        System.out.println("Il nome minimo è " + nomeMinimo);
        
        String nomeMassimo = AlgorithmArray.max(nomi);
        System.out.println("Il nome massimo è " + nomeMassimo);
        
        Integer[] numbers = new Integer[] {
            100,
            400,
            30,
            1,
            50
        };
        
        //Per la type inference Java riconosce il tipo <T> anche se non lo dichiaro
        Integer numMin = AlgorithmArray.min(numbers);
        System.out.println("Il numero minimo è " + numMin); 
        
        Integer numMax = AlgorithmArray.max(numbers);
        System.out.println("Il numero massimo è " + numMax);
        
        
        
    }
}
