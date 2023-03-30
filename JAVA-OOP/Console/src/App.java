public class App {
    public static void main(String[] args) throws Exception {
        
        Console playStation = new Console("PlayStation 5", 500, 20);
        Console playStation2 = new Console("PlayStation 5", 500, 20);
        Console nintendoSwitch = new Console("Nintendo Switch", 400, 0);
        
        System.out.println(playStation.equals(playStation2));
        playStation2.setPrice(250);
        System.out.println(playStation2.getPrice());
        
        nintendoSwitch.setQuantity(20);
        System.out.println(playStation2.getQuantity());
        nintendoSwitch.addQuantity(20);
        System.out.println(nintendoSwitch.getQuantity());
    }
}
