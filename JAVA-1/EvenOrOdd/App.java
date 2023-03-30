import java.util.Scanner;

class App {
    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);
       System.out.println("Inserisci un numero: ");
       int num = Integer.parseInt(scanner.nextLine());
        System.out.println("Il numero che hai scelto è: " + num);
        if(num % 2 == 0) {
            System.out.println("Numero pari");
        } else {
            System.out.println("Numero dispari");
        }
    }
}