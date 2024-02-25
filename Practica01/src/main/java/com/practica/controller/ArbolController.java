package com.practica.controller;

import com.practica.domain.Arbol;
import com.practica.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.practica.service.ArbolService;

@Controller
@RequestMapping("/arbol") 
public class ArbolController { 
    
    @Autowired
    private ArbolService arbolService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var arboles=arbolService.getArboles(true); 
        model.addAttribute("arboles", arboles);
        model.addAttribute("totalArboles", arboles.size()); 
        return "/arbol/listado"; 
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStrorageImpl;
    
    @PostMapping("/guardar")
    public String guardar(Arbol arbol, @RequestParam("imagenFile") MultipartFile imagenFile){ 
        if (!imagenFile.isEmpty()) {
            arbolService.saveArbol(arbol);
            arbol.setRutaImagen(
            firebaseStrorageImpl.cargaImagen(imagenFile, "arbol", arbol.getIdArbol())
            );
        }
        arbolService.saveArbol(arbol);
        return "redirect:/arbol/listado";
    }
    
    @GetMapping("/eliminar/{idArbol}") 
    public String elimina(Arbol arbol){ 
        arbolService.deleteArbol(arbol);
        return "redirect:/arbol/listado"; 
    }
    
    @GetMapping("/modificar/{idArbol}")
    public String modifica(Arbol arbol, Model model){ 
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica"; 
    }
    
}
