import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        //Creare delle (1)arrayList e delle (2)LinkedList e 
        //manipolarle con i vari metodi.
        
        //(1) 
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("Hello world!");
        arrayList.add("Java"); 
        System.out.println(arrayList);
        
        List<Integer> arrayList1 = new ArrayList<Integer>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);
        
        List<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(5);
        arrayList2.add(6);
        arrayList2.add(7);
        arrayList2.add(8);
        
        arrayList1.addAll(0, arrayList2);
        for(Integer item : arrayList1)
        {
            System.out.println("Added to position[0]: " + item);
        }

        //(2)
        LinkedList<Integer> LinkedList = new LinkedList<Integer>();
        LinkedList.add(1);
        LinkedList.add(2);
        LinkedList.add(3);
        LinkedList.add(4);

        for(Integer num : LinkedList) { System.out.println("Numeri iniziali: " + num );}
        LinkedList.removeFirst();
        LinkedList.addFirst(0);
        for(Integer num : LinkedList) { System.out.println("Numero aggiunto in prima posizione: " + num );}
        System.out.println(LinkedList.getLast()); // 4 
    }
}
