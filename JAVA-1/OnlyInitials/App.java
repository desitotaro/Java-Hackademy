import java.util.Scanner;

class App {
    
    public static void main(String[] args) {
        //scrivere un programma che chieda all’utente una stringa e ritorni le iniziali di ogni parola con il .
        // Esempio: “Ciao sono una stringa” => c.s.u.s
        System.out.println("Inserisci una frase: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] words = str.split(" ");
        String[] initials = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            char initial = words[i].charAt(0);
             initials[i] = Character.toString(initial);
        }
        String result = String.join(".", initials);
        System.out.println(result);
    }
}

