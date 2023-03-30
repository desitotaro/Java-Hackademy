import java.util.Scanner;

class App {
    //Scrivere un programma che prenda in input dall’utente 
    //un numero peso e un numero altezza e calcoli il BMI. 
    //Formula BMI => peso / (altezza * altezza) * 703
    public static void main(String[] args) {
        
        //(1) Scrivere un programma che prenda in input dall’utente un numero peso
        System.out.println("Inserisci il tuo peso: ");
        Scanner scanner = new Scanner(System.in);
        int weight = Integer.parseInt(scanner.nextLine());
        //(2) e un numero altezza
        System.out.println("Inserisci l'altezza: ");
        int height = Integer.parseInt(scanner.nextLine());
        System.out.println("Il tuo peso è di: " + weight + "kg" + ", la tua altezza è di " + height + "cm.");
        //(3) e calcoli il BMI
        float bmi = (100*100*weight)/(height*height);
        System.out.println("Il tuo bmi è di: " + bmi);

    }
}