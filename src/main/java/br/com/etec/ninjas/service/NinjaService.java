package br.com.etec.ninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etec.ninjas.model.Ninjas;
import br.com.etec.ninjas.repository.NinjaRepository;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninjas cadastrarNinjas(Ninjas ninjas){
        return ninjaRepository.save(ninjas);
    }

    //vai retornar a lista de ninjas enves de apenas 1 
    public List<Ninjas> listarNinjas(){
        return ninjaRepository.findAll();//findAll é um metodo herdado da repository feito pra listar
    }
        
    public Optional<Ninjas> pesquisarNinjas(Long id){
        return ninjaRepository.findById(id);
    }

    public Ninjas pesquisarNinjaPorNome(String nome){
        return ninjaRepository.findByNome(nome);
    }

    public List<Ninjas> pesquisarNinjaPorParteDoNome (String nome){
        return ninjaRepository.findByNomeContaining(nome);
    }
    
}
