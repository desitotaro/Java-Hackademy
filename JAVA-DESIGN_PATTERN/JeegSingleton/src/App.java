public class App {
    public static void main(String[] args) throws Exception {
        JeegFactorySingleton jeegf = new JeegFactorySingleton();
        LanciaMissili lm = (LanciaMissili) jeegf.instance(JeegComponentType.LanciaMissiliDx);
        LanciaMissili lm2 = (LanciaMissili) jeegf.instance(JeegComponentType.LanciaMissiliDx);
        
        // RESTITUISCE LO STESSO OGGETTO! Non ne crea uno nuovo, ho restituito quello che già c'è
        System.out.println(lm); // return > LanciaMissili@2ff4acd0
        System.out.println(lm2);// return > LanciaMissili@2ff4acd0
        
        
    } 
}
