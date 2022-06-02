package com.algaworks.brewer.controller;

import com.algaworks.brewer.model.Origem;
import com.algaworks.brewer.model.Produto;
import com.algaworks.brewer.model.Sabor;
import com.algaworks.brewer.repository.EstiloRepository;
import com.algaworks.brewer.service.CadastroProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProdutosController {

    @Autowired
    private EstiloRepository estiloRepository;

    @Autowired
    private CadastroProdutoService cadastroProdutoService;

    @RequestMapping("/produtos/novo")
    public ModelAndView novo(Produto produto){
        ModelAndView mv = new ModelAndView("produto/CadastroProduto");
        mv.addObject("sabores", Sabor.values());
        mv.addObject("estilos", estiloRepository.findAll());
        mv.addObject("origens", Origem.values());
        return mv;
    }

    @RequestMapping(value = "/produtos/novo", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid Produto produto, BindingResult result, Model model, RedirectAttributes attributes){

        if (result.hasErrors()){
            return novo(produto);
        }

        cadastroProdutoService.salvar(produto);
        attributes.addFlashAttribute("mensagem","Produto salvo com sucesso.");
        return  new ModelAndView("redirect:/produtos/novo");
    }

}
