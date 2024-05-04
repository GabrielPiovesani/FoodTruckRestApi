package com.br.foodtruckapi.api.controller;


import com.br.foodtruckapi.domain.model.Estado;
import com.br.foodtruckapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;


    @GetMapping
    public List<Estado>listarEstados(){
        return estadoRepository.listar();
    }


}
