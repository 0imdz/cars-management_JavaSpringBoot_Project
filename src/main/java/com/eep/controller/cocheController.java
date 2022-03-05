package com.eep.controller;

import com.eep.entity.Coches;
import com.eep.service.CochesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/coches")
public class cocheController {

    @Autowired
    @Qualifier("cochesServiceImpl")
    private CochesService cochesService;

    //INICIO
    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }

    //LISTAR
    @GetMapping("/mostrar")
    public ModelAndView mostrado(){
        ModelAndView mav=new ModelAndView("mostrar");
        mav.addObject("listaCoches", cochesService.listAllCoches());
        return mav;
    }

    //AÑADIR

    //MOSTRAR FORMULARIO DE ALTA
    @GetMapping("/anyadirform")
    public String irAlta(@ModelAttribute Coches coche,
                         Model model) {
        model.addAttribute("coches", new Coches());
        return "anyadir";
    }

    //EJECUTAR ALTA
    @PostMapping("/anyadir")
    public String anyadido(@ModelAttribute("coches") @Valid Coches coche,
                           BindingResult result){

        if(result.hasErrors()){
            return "anyadir";
        }else{
            cochesService.generarImagenCoche(coche);
            cochesService.addCoche(coche);
            return "redirect:/coches/mostrar";
        }
    }

    //MODIFICAR

    //BUSCAR PARA MODIFICAR
    @GetMapping("/busquedacoche/{id}")
    public String encontrarCoche(@PathVariable int id,
                                 Model model){

        Optional<Coches> cocheEncontrado = cochesService.buscarCoche(id);
        model.addAttribute("coches", cocheEncontrado);

        return "update";
    }

    //EJECUTAR MODIFICACIÓN
    @PostMapping("/editar")
    public String editar(@ModelAttribute("coches") @Valid Coches coche,
                         BindingResult result){

        if(result.hasErrors()){
            return "update";
        }else{
            cochesService.generarImagenCoche(coche);
            cochesService.updateCoche(coche);
        }

        return "redirect:/coches/mostrar";
    }

    //VISTA DETALLE

    //BUSCAR PARA VER VISTA DETALLE
    @GetMapping("/coche/{id}")
    public String encontrarCocheParaDetalle(@PathVariable int id,
                                            Model model){

        model.addAttribute("cochesEncontrados", cochesService.buscarCoche(id));

        return "detalle";
    }

    //ELIMINAR
    @PostMapping("/eliminar")
    public String deleteCourse(@RequestParam("cochesSeleccionados") ArrayList<Integer> cochesSeleccionados){

        System.out.println(cochesSeleccionados);
        cochesService.listCochesParaBorrar(cochesSeleccionados);
        return "redirect:/coches/mostrar";
    }

    //BIENVENIDA
    @GetMapping("/bienvenida")
    public String bienvenida(Model model) {
        return "bienvenida";
    }
}
