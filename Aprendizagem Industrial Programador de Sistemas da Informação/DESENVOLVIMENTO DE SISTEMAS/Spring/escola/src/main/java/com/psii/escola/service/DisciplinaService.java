package com.psii.escola.service;

import com.psii.escola.model.Disciplina;
import com.psii.escola.repository.DisciplinaRepository;
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
        return disciplinaRepository.findById(id).orElse(null);
    }

    public void saveDisciplina(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }

    public void deleteDisciplina(Long id) {
        disciplinaRepository.deleteById(id);
    }
}
