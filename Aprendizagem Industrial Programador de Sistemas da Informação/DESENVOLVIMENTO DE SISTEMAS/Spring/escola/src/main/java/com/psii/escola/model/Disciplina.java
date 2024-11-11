package com.psii.escola.model;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao; // Adicionando o campo descricao

    @OneToMany(mappedBy = "disciplina")
    private Set<Inscricao> inscricoes = new HashSet<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() { // Adicionando o getter para descricao
        return descricao;
    }

    public void setDescricao(String descricao) { // Adicionando o setter para descricao
        this.descricao = descricao;
    }

    public Set<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(Set<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
}
