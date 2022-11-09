package com.tutorial.tutorialz.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import lombok.Data;

import com.tutorial.tutorialz.Model.Etiqueta;

@Entity
@Data
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorial_generator")
    private Long id;
  
    @Column(length = 100, nullable = false)
    private String titulo;
  
    @Column(length = 250, nullable = false)
    private String descricao;
  
    @Column(name = "publicado")
    private Boolean publicado;

   
    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
    @JoinTable(name = "tutorial_etiqueta",
          joinColumns = { @JoinColumn(name = "tutorial_id") },
          inverseJoinColumns = { @JoinColumn(name = "etiqueta_id") })
    private Set<Etiqueta> etiquetas = new HashSet<>(); 
    
}

/*
– A anotação @Entity indica que a classe é uma classe Java persistente.
– A anotação @Table fornece a tabela que mapeia essa entidade.

– A anotação @Id é para a chave primária.
– A anotação GenerationType.SEQUENCE é usada para definir a estratégia de geração da chave primária.

– A anotação @Column é usada para definir a coluna no banco de dados que mapeia o campo anotado.
*/
