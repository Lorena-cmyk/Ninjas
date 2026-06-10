package br.com.etec.ninjas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etec.ninjas.model.Ninjas;


public interface NinjaRepository extends JpaRepository<Ninjas, Long>{

    Ninjas findByNome(String nome);//O valor dps de findyBy é o que voce criou na model e vai querer pesquisa, ele faz uma busca especifica 

    List<Ninjas> findByNomeContaining(String nome);
                           //Containing=Contém,ele vai pesquisar por partes 
}
