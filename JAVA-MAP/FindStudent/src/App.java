import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        //(1)creare una mappa con degli oggetti, (2)chiedere all’utente di inserire 
        //una chiave e provare a cercare l’oggetto corrispondente nella mappa.
        
        Student marco = new Student("Marco", "123245");
        Student desi = new Student("Desi", "546354");
        Student luca = new Student("Luca", "767673");
        Student giulia = new Student("Giulia", "380683");
        
        Map<String, Student> listStudent = new HashMap<String, Student>();
        listStudent.put(marco.code, marco);
        listStudent.put(desi.code, desi);
        listStudent.put(luca.code, luca);
        listStudent.put(giulia.code, giulia);
        
        System.out.println("Access your profile by entering your serial number: ");
        Scanner findStudent = new Scanner(System.in);
        String result = findStudent.nextLine();
        System.out.println("Hello" + listStudent.get(result).name);
        findStudent.close();
        
    }
}
