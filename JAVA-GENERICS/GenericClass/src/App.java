public class App {
    public static void main(String[] args) throws Exception {
       
        /* GenericClass gen = new GenericClass("Generica");
        System.out.println(gen.getData()); */
       
        GenericClass<String> gen = new GenericClass<String>("Generica");
        System.out.println(gen.getData());
       
        GenericClass<Integer> genInt = new GenericClass<Integer>(5);
        System.out.println(genInt.getData());

        //Posso rendere il concetto ancora più forte, dichiarando <String> come tipo
        // di dato e voglio che mi lavorerà con le stringhe
        Pair<String> p1 = new Pair<String>("String1", "String2");
        System.out.println(p1.getS1() + " : " + p1.getS2());
        
    }
}
