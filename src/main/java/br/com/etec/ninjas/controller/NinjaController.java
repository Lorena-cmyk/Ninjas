package br.com.etec.ninjas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.ninjas.model.Ninjas;
import br.com.etec.ninjas.service.NinjaService;
import jakarta.validation.Valid;

@RestController//metodo para enviar as requisicoes e receber as repostas 
@RequestMapping("/ninjas")//localhost:8080/ninjas = endereço da API
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @PostMapping
    public Ninjas cadastrarNinjas(@Valid @RequestBody Ninjas ninjas){
        return ninjaService.cadastrarNinjas(ninjas);
    }

    @GetMapping //é utilizado para mapear requisições HTTP do tipo GET/ mais usadas para buscar ou listar dados em uma api
    public List<Ninjas> listaNinjas(){
        return ninjaService.listarNinjas();
    }
    
}
