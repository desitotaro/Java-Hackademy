package it.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.jdbc.model.Prodotto;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProdottoDao dao = context.getBean(ProdottoDao.class);
        Prodotto p = dao.getOneObject(1L);
        /*      System.out.println("id " + p.getId());
        System.out.println("nome " + p.getNome());
        System.out.println("descrizione " + p.getDescrizione());
        System.out.println("prezzo  " + p.getPrezzo());
        */
        List<Prodotto> all = dao.getObjects();
        
        for(Prodotto prod : all)
        {
            System.out.println("id " + prod.getId());
            System.out.println("nome " + prod.getNome());
            System.out.println("descrizione " + prod.getDescrizione());
            System.out.println("prezzo " + prod.getPrezzo());
            System.out.println();
        }
        
        // Inserire nuovo prodotto, quando poi ristampo togliere dao.insert
        Prodotto newProdotto = new Prodotto();
        newProdotto.setNome("Nuovo");
        newProdotto.setDescrizione("Descrizione");
        newProdotto.setPrezzo(30F); //30Float
        dao.insert(newProdotto);
        System.out.println(dao.count()); 
        
        //Delete
        dao.delete(5L);
        System.out.println(dao.count()); 
        
        //Update
        p.setDescrizione("Questa è una nuova descrizione");
        dao.update(p.getId(), p);
        
        List<Prodotto> maggioridiCento = dao.getGreaterThanPrezzo(100F);
        for(Prodotto prod : maggioridiCento)
        {
            System.out.println("id " + prod.getId());
            System.out.println("nome " + prod.getNome());
            System.out.println("descrizione " + prod.getDescrizione());
            System.out.println("prezzo " + prod.getPrezzo());
            System.out.println();
        }
    }
}
