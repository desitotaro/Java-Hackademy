package it.prova.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.model.Batman;

@Component("batmanRepository")
public class BatmanRepositoryImpl implements BatmanRepository{
    @Autowired
    private Batman batman;
    
    public BatmanRepositoryImpl()
    {
        System.out.println("Create repo");
    }

    @Override
    public Batman getBatman() {
       return this.batman;
    }

    @Override
    public void setBatman(Batman batman) {
       this.batman = batman;
    }
    
}
