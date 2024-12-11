package com.edu.ue.blacklist;

import java.util.List;

public interface DatacreditoService {

    List<Datacredito> listar();

    Datacredito listarId(int id);

    Datacredito add(Datacredito p); 

    Datacredito edit(Datacredito p); 

    Datacredito delete(int id);
}
