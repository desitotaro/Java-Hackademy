import java.util.Scanner;

class App {

// Cheidere all'utente di digitare un numero e ottenere la somma delle cifre inserite

public static void main(String[] args)
{
    int sum = 0;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Inserisci un numero");
    int number = Integer.parseInt(scanner.nextLine()); // tutto ciò che ricevi convertimelo in Int
    // accedere ad ogni singola cifra eliminarla dal numero inserito dall'utente
    // e sommarla a sum 
    while(number != 0)
    {
        // 123 
        // prendo l'ultima cifra
        int digit = number % 10;
        sum = sum + digit;
        //number è ancora 123, devo togliere quella estratta prima, il 3
        number = number / 10;
    }
 System.err.println("La somma è " + sum)

}


}