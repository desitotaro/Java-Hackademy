import java.util.Scanner;

class App {

    public static void main(String[] args)
    {
        //Chiedere la stringa ad un utente
        //Dire se la stringa inseria è palindroma

        // (1) generare una stringa inversa
        // (2) controllare se combaciano

        String a = "";
        String b = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci una parola: ");
        a = scanner.nextLine();
        int len = a.length();
        // ciclare al contrario la stringa
        for(int i = len -1; i >= 0; i--)
        {
            b = b + a.charAt(i);
        }
        // inserisco ciao = oiac
        // le stringhe sono uguali?

        if(a.equalsIgnoreCase(b)) { System.out.println("E' palindroma"); } else { System.out.println("Non è palindroma"); }
    }



}