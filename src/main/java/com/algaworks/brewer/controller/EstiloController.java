package com.algaworks.brewer.controller;


import com.algaworks.brewer.model.Estilo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstiloController {
    @RequestMapping("/estilos/novo")
    public String novo(Estilo estilo){
        return "estilo/CadastroEstilo";
    }
}
