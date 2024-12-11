package com.edu.ue.blacklist;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface BlacklisRepository extends Repository<Blacklis, Integer> {

        List<Blacklis> findAll();
    
        Blacklis findById(int id);
    
        Blacklis save(Blacklis p);
    
        void delete(Blacklis p);
    }

