import java.util.Scanner;

class App {
    public static void main(String[] args) {   
        //(1)scrivere un programma che prenda in input un numero
        System.out.println("Inserisci un numero: ");
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        //(2) che crei un array di lunghezza pari al numero inserito
        int[] elements = new int[num];
        //(3) che chieda un numero di elementi pari al numero inserito
        for (int i = 0; i < num; i++) {
            System.out.println("Inserisci elementi: ");
            int x = Integer.parseInt(scanner.nextLine());
            elements[i] = x;
        }
        
        //(4)e stampi solo gli elmenti in posizione pari
        for(int i = 0; i < elements.length; i = i+2) {
            System.out.println(elements[i]);  
        } 
        
    }
}