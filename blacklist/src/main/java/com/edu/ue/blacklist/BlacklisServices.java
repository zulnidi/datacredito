package com.edu.ue.blacklist;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlacklisServices implements BlacklisService {
    @Autowired
    private BlacklisRepository repositorio;

    @Override
    public List<Blacklis> listar() {
        return repositorio.findAll();
    }

    @Override
    public Blacklis listarId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public Blacklis add(Blacklis p) {
        return repositorio.save(p);
    }

    @Override
    public Blacklis edit(Blacklis p) {
        return repositorio.save(p);
    }


    @Override
    public Blacklis delete(int id) {
        Blacklis p = repositorio.findById(id);
        if (p != null) {
            repositorio.delete(p);
        }
        return p;
    }
    
    
}
