package com.tutorial.tutorialz.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Comentario {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentario_generator")
  private Long id;

  @Lob
  private String conteudo;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "tutorial_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Tutorial tutorial;

}

/*
Observações:
A classe Comentario tem a anotação @ManyToOne 
para relacionamento muitos para um com a entidade Tutorial. 
elemento opcional é definido como false para relacionamento
 não nulo.
 
Também usamos a anotação @JoinColumn para especificar 
a coluna de chave estrangeira (tutorial_id). 
Se você não fornecer o nome JoinColumn, o nome será definido 
automaticamente.

@JsonIgnore é usado para ignorar a propriedade 
lógica usada na serialização e desserialização.

Também implementamos recursos de exclusão em cascata 
da chave estrangeira com @OnDelete(action = OnDeleteAction.CASCADE).

Definimos o @ManyToOne com FetchType.LAZY para o tipo de busca por ID.

Por padrão, a associação @ManyToOne usa FetchType.EAGER para o tipo de busca,
 mas é ruim para o desempenho
*/