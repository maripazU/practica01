package com.practica.service;

import com.practica.domain.Arbol;
import java.util.List;

public interface ArbolService {
    public List<Arbol> getArboles(boolean activos);

    public Arbol getArbol(Arbol arbol);
    
    public void deleteArbol(Arbol arbol);
   
    public void saveArbol(Arbol arbol);
    
}
