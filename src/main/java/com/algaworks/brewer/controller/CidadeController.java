package com.algaworks.brewer.controller;

import com.algaworks.brewer.model.Cidade;
import com.algaworks.brewer.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CidadeController {
    @RequestMapping("/cidades/novo")
    public String novo(Cidade cidade){
        return "cidade/CadastroCidade";
    }
}
