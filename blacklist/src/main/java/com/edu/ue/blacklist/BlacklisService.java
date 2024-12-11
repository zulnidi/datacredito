package com.edu.ue.blacklist;

import java.util.List;

public interface BlacklisService {


    List<Blacklis> listar();

    Blacklis listarId(int id);

    Blacklis add(Blacklis p);

    Blacklis edit(Blacklis p);

    Blacklis delete(int id);


}
