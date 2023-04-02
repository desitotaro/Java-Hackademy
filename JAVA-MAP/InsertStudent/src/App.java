import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        // (1) Scrivere un programma che dichiari una lista di elementi di una determinata classe, 
        // (2) chiedere all’utente le informazioni per creare un nuovo oggetto e inserire l’oggetto nella lista.
        
        Student marco = new Student("Marco", "Rossi", "123245");
        Student desi = new Student("Desirée", "Totaro", "546354");
        Student luca = new Student("Luca","Rossi", "767673");
        Student giulia = new Student("Giulia","Rossi", "380683");
        
        Map<String, Student> listStudent = new HashMap<String, Student>();
        listStudent.put(marco.code, marco);
        listStudent.put(desi.code, desi);
        listStudent.put(luca.code, luca);
        listStudent.put(giulia.code, giulia); 
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert your name: ");
        String name = scanner.nextLine();
        System.out.println("Insert your surname: ");
        String surname = scanner.nextLine();
        System.out.println("Insert your serial number: ");
        String code = scanner.nextLine();
        Student student = new Student(name, surname, code);
        listStudent.put(student.code, student);
        scanner.close();

        
        System.out.println("Lista studenti presenti nel nostro database:");
        for(Student stud : listStudent.values())
        {
            System.out.println(stud.getName() + " , " + stud.getSurname() + " , " + stud.getCode());
        }
        
        
    }
}
