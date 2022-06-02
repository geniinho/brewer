package com.algaworks.brewer.service;

import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.repository.EstiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroEstiloService {
    @Autowired
    EstiloRepository estiloRepository;

    @Transactional
    public void salvar(Estilo estilo){
        estiloRepository.save(estilo);
    }
}
