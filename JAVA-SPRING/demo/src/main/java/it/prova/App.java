package it.prova;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.prova.model.Batman;
import it.prova.model.Batmobile;
import it.prova.model.Suit;
import it.prova.service.BatmanService;
import it.prova.model.Mask;


/**
* Hello world!
*
*/
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Batman batman = context.getBean("batman", Batman.class);
        Batmobile batmobile = context.getBean("batmobile", Batmobile.class);
        System.out.println(batman.getBatmobile()); //stessa reference
        System.out.println(batmobile); //stessa reference
        Suit suit = context.getBean("suit", Suit.class);
        Mask mask = context.getBean("mask", Mask.class);
        System.out.println(suit.getMask()); //reference diverse
        System.out.println(mask); // reference diverse
        
        BatmanService service = context.getBean("batmanService", BatmanService.class);
        service.climb();
        service.attack();
        service.goForwardWithBatmobile();
        service.goBackWithBatmobile();
    }
}
