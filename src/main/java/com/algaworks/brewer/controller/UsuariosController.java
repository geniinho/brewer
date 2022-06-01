package com.algaworks.brewer.controller;

import com.algaworks.brewer.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuariosController {
    @RequestMapping("/usuarios/novo")
    public String novo(Usuario usuario){
        return "usuario/CadastroUsuario";
    }
}
