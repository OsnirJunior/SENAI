package com.psii.escola.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate data_nascimento; // Adicione este campo

    @OneToMany(mappedBy = "estudante")
    private Set<Inscricao> inscricoes = new HashSet<>();

    // Getters e Setters para 'id' e 'nome'
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

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Set<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(Set<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
}
