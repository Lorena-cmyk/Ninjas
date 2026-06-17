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
    
//Método para alterar/Atualizar ninjas 
    public Ninjas atualizarNinjas(Long id, Ninjas ninjaAtualizado ){
        Optional<Ninjas> ninjaCadastrado = ninjaRepository.findById(id);//optional= pode existir ou não 


        //Ta buscando os ninjas e atualizando as informaçoes no banco 
if (ninjaCadastrado.isPresent()) {
    Ninjas ninjas = ninjaCadastrado.get();//get busta e set insiro 

    ninjas.setNome(ninjaAtualizado.getNome());
    ninjas.setCpf(ninjaAtualizado.getCpf());
    ninjas.setEmail(ninjaAtualizado.getEmail());

    return ninjaRepository.save(ninjas);
}
  return null;
    }

    //Metodo deletar/exlcuir
//Ele nao tem retorno, pois vai excluir
    public void deletarNinja(Long id ){
        ninjaRepository.deleteById(id);
    }

}
