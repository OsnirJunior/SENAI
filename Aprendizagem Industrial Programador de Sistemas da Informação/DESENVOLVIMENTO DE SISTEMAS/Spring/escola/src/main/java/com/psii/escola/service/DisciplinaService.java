package com.psii.escola.service;

import com.psii.escola.model.Disciplina;
import com.psii.escola.repository.DisciplinaRepository;
import com.psii.escola.repository.InscricaoRepository; // Importando o repositório de Inscrição
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private InscricaoRepository inscricaoRepository; // Repositório de Inscrição para verificação

    public List<Disciplina> getAllDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Disciplina getDisciplinaById(Long id) {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrada com id: " + id));
    }

    public void saveDisciplina(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }

    public void excluirDisciplina(Long id) {
        // Verifique se a disciplina existe antes de tentar excluir
        if (!disciplinaRepository.existsById(id)) {
            throw new IllegalStateException("Disciplina com ID " + id + " não encontrada.");
        }
        disciplinaRepository.deleteById(id); // Exclui a disciplina do banco de dados
    }

}
