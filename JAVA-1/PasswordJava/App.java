import java.util.Scanner;

class App {
  
  public static void main(String[] args){ 
    
    // PASSWORD
    // 1. Almeno 8 caratteri
    // 2. Almeno uno in uppercase
    // 3. Almeno un numero
    
    Boolean firstRule = false;
    Boolean secondRule = false;
    Boolean thirdRule = false;
    
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("Inserisci la password");
    
    String password = scanner.nextLine(); // Se inserisco un numero me lo converte in stringa
    // Blocca il programma, aspetta di ottenere l'input dalla command line 
    System.out.println("La password inserita è " + password);
    
    // CONTROLLO 1 
    if(password.length() >= 8) firstRule = true;
    
    // CONTROLLO 2
    for(int i = 0; i < password.length(); i++)
    {
      // Se voglio accedere al singolo carattere tramite indice di una stringa devo usare
      // charAt, ma cosa ritorna questa funzione? Se accedo tramite la funzione charAt al 
      // singolo carattere, questa funzione mi ritorna un tipo di dato diverso da String.
      // Quindi non posso usare controlli (funzioni) delle stringhe su un char. 
      
      if(Character.isUpperCase(password.charAt(i))) secondRule = true;
      // non metto l'else perché durante un ciclo, es. passWord, la W è sicuramente true,
      // ma quando continua il ciclo e arriva alla d, è in lowercase, quindi false.
      // quando ciclo una stringa, il tipo di dato non è più una stringa, ma un Char, che è 
      // un tipo di dato diverso da stringa. 
    }
    
    // CONTROLLO 3 
    
    for(int i = 0; i < password.length(); i++)
    {
      if(Character.isDigit(password.charAt(i))) secondRule = true;
    }
    
    if(firstRule && secondRule && thirdRule)
    {
      System.out.println("La password è corretta");
    } else {
      
      System.out.println("La password non è corretta");
      
    }
    
    
  }
}