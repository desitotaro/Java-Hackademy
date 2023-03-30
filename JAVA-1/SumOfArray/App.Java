import java.util.Scanner;

class App {
// (1) Chiedo all'utente quanti numeri vuole inserire, (2)dobbiamo chiedere tutti 
// i numeri uno alla volta e (3)metterli in un array
// dobbiamo effettuare una sommatoria
    public static void main(String[] args)
    {

        System.out.println("Quanti numeri vuoi inserire?")
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        // 1 
        int[] numbers = new Int[len];
        int sum = 0;
        // Ciclo di tutti i numeri per riempire l'array
        for(int i = 0; i < len; i++)
        {
            System.out.println("Inserisci un numero:");
            int x = Integer.parseInt(scanner.nextLine());
            numbers[i] = x;
        }

        for(int i = 0; i < numbers.length; i++)
        {
            sum = sum + numbers[i];
        }
    }

    System.out.println("La somma dei numeri è " + sum);

}