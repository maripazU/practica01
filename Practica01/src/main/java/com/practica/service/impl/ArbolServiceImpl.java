package com.practica.service.impl;

import com.practica.domain.Arbol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.practica.dao.ArbolDao;
import com.practica.service.ArbolService;

@Service 
public class ArbolServiceImpl implements ArbolService {

    @Autowired
    private ArbolDao arbolDao;

    @Override
    @Transactional(readOnly=true) 
    public List<Arbol> getArboles(boolean activos) {
        var lista=arbolDao.findAll();
        if (activos) {
            lista.removeIf(a -> !a.isActivo()); 
        }
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Arbol getArbol(Arbol arbol) {
        return arbolDao.findById(arbol.getIdArbol()).orElse(null); 
    }

    @Override
    @Transactional() 
    public void deleteArbol(Arbol arbol) {
       arbolDao.delete(arbol);
    }

    @Override
    @Transactional() 
    public void saveArbol(Arbol arbol) {
        arbolDao.save(arbol);
    }

}
