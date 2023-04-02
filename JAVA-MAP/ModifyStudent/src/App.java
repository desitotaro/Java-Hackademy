import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        //Scrivere un programma Java per aggiornare un elemento della lista specifico 
        //in base al suo indice. esempio, create una lista di persone, chiedete all’utente 
        //quale persona vuole modificare, chiedete i dati e aggiornate quell’elemento della lista.
        
        // (1) Lista già esistente di studenti:
        List<String> students = new ArrayList<String>();
        students.add("Desirée Totaro");
        students.add("Luca Rossi");
        students.add("Marco Bianchi");
        students.add("Andrea Gialli");
        students.add("Giulia Verdi");
        students.add("Alberto Lupo");

        System.out.println("Ecco la lista degli studenti presenti:");
        for(String student : students)
        {
            System.out.println("[" + students.indexOf(student) + "]" + " " + student);
        }

        // (2) Inserisci l'indice per modificare lo studente:
        System.out.println("Modifica le credenziali inserendo l'indice: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        for(String student : students)
        {
            if(index == students.indexOf(student))
            {
                System.out.println("Modifica di: " + student);
            }
        }
        scanner.nextLine();
        // (3) Modifica effettiva dello studente: 
        String change = scanner.nextLine();
        scanner.close();
        students.set(index, change);
        
        // (4) Lista aggiornata degli studenti:
        System.out.println("Lista aggiornata degli studenti: ");
        for(String student : students)
        {
            System.out.println("[" + students.indexOf(student) + "]" + " " + student);
        }
        
    }
}
