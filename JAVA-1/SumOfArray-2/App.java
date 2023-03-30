import java.util.Scanner;

class App {
    public static void main(String[] args) {
    
       
        //(1)scrivere un programma che prenda in input un numero,
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero di quanti elementi vuoi inserire: ");
        int len = Integer.parseInt(scanner.nextLine());

        //(2)che crei un array di lunghezza pari al numero inserito
        int[] numbers = new int[len];
        int sum = 0;
        int average = 0;

        //(3)che chieda un numero di elementi pari al numero inserito
        for (int i = 0; i < len; i++) {
            System.out.println("Inserisci un numero: ");
            int a = Integer.parseInt(scanner.nextLine());
            numbers[i] = a;
        }

        //(4) e faccia la media
        for (int i = 0; i < numbers.length; i++) {
           sum = sum + numbers[i];
        }

        average = sum / numbers.length;

        System.out.println("La media dei numeri inseriti è : " + average);
    }

}