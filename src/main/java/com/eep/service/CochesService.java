package com.eep.service;

import com.eep.entity.Coches;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CochesService {

    //LISTAR
    public abstract List<Coches> listAllCoches();

    //AÑADIR
    public abstract Coches addCoche(Coches coche);

    //MODIFICAR
    public abstract Optional<Coches> buscarCoche(int id);//buscar para modificar
    public abstract Coches updateCoche(Coches coche);//ejecutar modificación

    //BORRAR
    public List<Integer> listCochesParaBorrar(ArrayList<Integer> id);

    //ASIGNACIÓN DE IMÁGENES
    public void generarImagenCoche(Coches coche);
}
