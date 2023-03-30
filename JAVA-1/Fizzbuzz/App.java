class App {
    public static void main(String[] args) {
        
        // Fizz se è divisibile per 3
        // Buzz se è divisibile per 5
        // FizzBuzz se è divisibile per 3 e 5 
        
      
        for (int i = 1; i <= 50; i++) {
            
            if(i % 3 == 0 && i % 5 == 0)
            {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }

     /*    for (int i = 1; i <= 100; i++) {
            String a = (i % 15 == 0) ? "Fizzbuzz" : ((i % 5 == 0) ? "buzz" : ((i % 3 == 0) ? "Fizz" : String.valueOf(i)));
            System.out.println(a);
        } */
    }
}