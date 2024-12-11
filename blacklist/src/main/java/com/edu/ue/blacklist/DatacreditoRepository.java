package com.edu.ue.blacklist;

import java.util.List;

import org.springframework.data.repository.Repository;


    public interface DatacreditoRepository extends Repository<Datacredito, Integer> {

        List<Datacredito> findAll();
    
        Datacredito findById(int id);
    
        Datacredito save(Datacredito p);
    
        void delete(Datacredito p);
    }
    
