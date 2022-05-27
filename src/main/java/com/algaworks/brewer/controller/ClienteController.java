package com.algaworks.brewer.controller;

import com.algaworks.brewer.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClienteController {
    @RequestMapping("/clientes/novo")
    public String novo(Cliente cliente){
        return "cliente/CadastroCliente";
    }
}
