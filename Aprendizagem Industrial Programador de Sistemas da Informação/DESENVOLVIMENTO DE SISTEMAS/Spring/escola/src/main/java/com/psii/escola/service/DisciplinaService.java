package com.psii.escola.service;

import com.psii.escola.model.Disciplina;
import com.psii.escola.repository.DisciplinaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

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
        if (!disciplinaRepository.existsById(id)) {
            throw new IllegalStateException("Disciplina com ID " + id + " não encontrada.");
        }
        disciplinaRepository.deleteById(id);
    }

}
