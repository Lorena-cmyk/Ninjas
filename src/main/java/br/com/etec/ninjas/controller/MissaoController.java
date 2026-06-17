package br.com.etec.ninjas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.ninjas.model.Missao;
import br.com.etec.ninjas.service.MissaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/missoes")
public class MissaoController {
    
    @Autowired
    private MissaoService missaoService;

    @PostMapping
    public missao cadastrarMissao(@Valid @RequestBody Missao missao){
        return missaoService.cadastrarMissao(missao);
    }

    @GetMapping
    public List<Missao> listarMissoes(){
        return missaoService.listarMissoes();
    }

    @GetMapping("/{dificuldade}")
    public List<Missao> buscarPorDificuldade(@PathVariable String dificuldade){
        return missaoService.buscarPorDificuldade(dificuldade);
    }


}
