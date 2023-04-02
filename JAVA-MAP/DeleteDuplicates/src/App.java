import java.util.HashMap;
import java.util.Map;
public class App {
    public static void main(String[] args) throws Exception {
        //scrivere un programma che crei una lista di elementi e 
        //che ne rimuova i duplicati
        Student luca = new Student("Luca", "Bianchi", "1");
        StudentKey key1 = new StudentKey(luca.code, 10);
        Student marco = new Student("Marco", "Rossi", "2");
        StudentKey key2 = new StudentKey(marco.code, 1);
        Student franco = new Student("Franco", "Gialli", "3");
        StudentKey key3 = new StudentKey(franco.code, 1);
        Student giulia = new Student("Giulia", "Verdi", "4");
        StudentKey key4 = new StudentKey(giulia.code, 1);
        Student giulia1 = new Student("Giulia", "Verdi", "4");
        StudentKey key5 = new StudentKey(giulia1.code, 1);
      

        
        Map<StudentKey, Student> students = new HashMap<StudentKey, Student>();
        students.put(key1, luca);
        students.put(key2, marco);
        students.put(key3, franco);
        students.put(key4, giulia);
        students.put(key5, giulia1);


        for(StudentKey key : students.keySet())
        {
            System.out.println(students.get(key).name);
        }
    }
}
