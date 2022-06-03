package com.algaworks.brewer.service;

import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.repository.EstiloRepository;
import com.algaworks.brewer.service.exception.NomeEstiloJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CadastroEstiloService {
    @Autowired
    EstiloRepository estiloRepository;

    @Transactional
    public void salvar(Estilo estilo){
        Optional<Estilo> estiloOptional = estiloRepository.findByNomeIgnoreCase(estilo.getNome());
        if(estiloOptional.isPresent()){
            throw new NomeEstiloJaCadastradoException("Estilo já cadastrado");
        }
        estiloRepository.saveAndFlush(estilo);
    }
}
