package com.practica.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "el-roble-c1c4f.appspot.com";

    final String rutaSuperiorStorage = "el arbol";
    
    final String rutaJsonFile = "firebase";
    
    final String archivoJsonFile = "el-roble-c1c4f-firebase-adminsdk-on4j0-55f5792a96.json";
    
}
