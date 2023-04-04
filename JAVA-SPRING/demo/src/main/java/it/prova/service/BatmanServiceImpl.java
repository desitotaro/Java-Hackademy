package it.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.prova.repository.BatmanRepository;

@Component("batmanService")
public class BatmanServiceImpl implements BatmanService{
    
    @Autowired
    private BatmanRepository repository;
    
    public BatmanServiceImpl() {
        System.out.println("Create service");
    }
    
    public BatmanRepository getRepository() {
        return repository;
    }
    
    public void setRepository(BatmanRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public void goForwardWithBatmobile() {
        if (this.repository.getBatman() != null)
        System.out.println("Vado avanti con la Batmobile");
    }
    
    @Override
    public void goBackWithBatmobile() {
        if (this.repository.getBatman() != null)
        System.out.println("Vado indietro con la Batmobile");
    }
    
    @Override
    public void attack() {
        if (this.repository.getBatman() != null)
        System.out.println("Attacco");
    }
    
    @Override
    public void climb() {
        if (this.repository.getBatman() != null)
        System.out.println("Mi arrampico");
    }
    
}
