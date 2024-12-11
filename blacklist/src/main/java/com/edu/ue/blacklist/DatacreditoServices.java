package com.edu.ue.blacklist;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatacreditoServices implements DatacreditoService {
    @Autowired
    private DatacreditoRepository repositorio;

    @Override
    public List<Datacredito> listar() {
        return repositorio.findAll();
    }

    @Override
    public Datacredito listarId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public Datacredito add(Datacredito p) {
        return repositorio.save(p); 
    }

    @Override
    public Datacredito edit(Datacredito p) {
        return repositorio.save(p); 
    }

    @Override
    public Datacredito delete(int id) {
        Datacredito p = repositorio.findById(id);
        if (p != null) {
            repositorio.delete(p);
        }
        return p;
    }
}
