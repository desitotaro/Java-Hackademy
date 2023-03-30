import java.util.Scanner;

class App {

    public static void main(String[] args)
    {
        let reverse = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero")
        int number = scanner.nextInt();
        //estrarre l'ultima cifra, inserirla nel nuovo numero nella posizione
        //corretta, fino a quando non avrò estratto l'ultima cifra
        while(number =! 0){
            let digit = number % 10;
            reverse = (reverse * 10) + digit;
            number = number / 10;
        }
    }

    System.out.println("Il numero invertito è " + number)
}