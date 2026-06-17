package br.com.etec.ninjas.model;

 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "missao")
@Data
@Valid
public class Missao {

  @Id   
  @GeneratedValue(strategy =  GenerationType.AUTO)
  private Long id_missao;

  @Column(name = "nome_missao", nullable = false)
  @NotBlank(message = "Nome da missão é obrigatório")
  @Size (min = 3, max = 255, message = "Nome deve ter entre 3 a 255 caracteres.")
  private String nome;

  @Column(name = "descricao_missao", nullable = false)
  @NotBlank (message = "Descrição é obrigatótia!")
  private String descricao;

  @Column(name = "dificuldade_missao", nullable = false)
  @NotBlank(message = "Obrigatório preencher o nivel!")
  private String dificuldade;
    
}
