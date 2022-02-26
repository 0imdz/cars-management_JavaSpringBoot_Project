package com.eep.service.impl;

import com.eep.entity.Coches;
import com.eep.repository.CocheJPARepository;
import com.eep.service.CochesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service("cochesServiceImpl")
public class CochesServiceImpl implements CochesService {

    @Autowired
    @Qualifier("cocheJpaRepository")
    private CocheJPARepository cocheRepository;

    //LISTAR
    @Override
    public List<Coches> listAllCoches(){
        return cocheRepository.findAll();
    }

    //AÑADIR
    @Override
    public Coches addCoche(Coches coche){
        return cocheRepository.save(coche);
    }

    //MODIFICAR

    //BUSCAR PARA MODIFICAR
    @Override
    public Optional<Coches> buscarCoche(int id){
        Optional<Coches> cocheEncontrado=cocheRepository.findById(id);
        return cocheEncontrado;
    }

    //EJECUTAR MODIFICACIÓN
    @Override
    public Coches updateCoche(Coches coche){
        return cocheRepository.save(coche);
    }

    //ELIMINAR
    @Override
    public List<Integer> listCochesParaBorrar(ArrayList<Integer> cochesSeleccionados){

        for (int i=0; i<cochesSeleccionados.size(); i++){
            cocheRepository.deleteById(cochesSeleccionados.get(i));
        }
        return cochesSeleccionados;
    }

    @Override
    public void generarImagenCoche(Coches coche){
        //System.out.println(coche.getModelo()+".jpg");
        coche.setRutaimagen(coche.getModelo().toLowerCase()+".jpg");
    }
}
