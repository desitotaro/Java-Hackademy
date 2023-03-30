package ESERCIZI.AutomorphicNumber;
import java.util.Scanner;


class App {
    public static void main(String[] args) {
        
        // un numero è automorfo se le cifre finali del suo quadrato
        // sono uguali al numero stesso es. 76^2 = 5776
        
        System.out.println("Inserisci un numero, check automorfo: ");
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        // calcolo il quadrato
        int squared = number * number;
        System.out.println(squared);
        
        // controllare le ultime due cifre
        int numLength = String.valueOf(number).length(); // Lo devo rendere stringa
        // prendere una sottostringa che va dall'ultimo carattere fino alla lunghezza del
        // numero inserito all'inizio
        String lastNumbers = String.valueOf(squared).substring(String.valueOf(squared).length() - numLength, String.valueOf(squared).length()); 
        System.out.println("Le ultime cifre sono:" + lastNumbers);
        /*         if(lastNumbers.equals(String.valueOf(number))) {
            System.out.println("Il numero" + number + "è automorfo");
        } else {
            System.out.println("Il numero" + number + "non è automorfo");
        } */

        // due modi di risolvere, uno dei due va convertito! 

        if(Integer.parseInt(lastNumbers) == number)
        {
            System.out.println("Il numero " + number + " è automorfo");
        } else {
            System.out.println("Il numero " + number + " non è automorfo");
        } 
    }    
}
