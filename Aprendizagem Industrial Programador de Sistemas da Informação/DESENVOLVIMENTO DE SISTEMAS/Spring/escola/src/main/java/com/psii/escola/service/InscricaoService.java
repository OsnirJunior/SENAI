package com.psii.escola.service;

import com.psii.escola.model.Inscricao;
import com.psii.escola.repository.InscricaoRepository;
import com.psii.escola.repository.DisciplinaRepository;
import com.psii.escola.repository.EstudanteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Inscricao> getAllInscricoes() {
        return inscricaoRepository.findAll();
    }

    public void saveInscricao(Inscricao inscricao) {
        inscricaoRepository.save(inscricao);
    }

    public void deleteInscricao(Long id) {
        Inscricao inscricao = inscricaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Inscrição não encontrada com id: " + id));

        inscricaoRepository.delete(inscricao);
    }

    public void excluirEstudante(Long id) {
        if (inscricaoRepository.existsByEstudanteId(id)) {
            throw new IllegalStateException("Não é possível excluir o estudante porque ele está cadastrado em uma inscrição.");
        }
        estudanteRepository.deleteById(id);
    }

    public void excluirDisciplina(Long id) {
        if (inscricaoRepository.existsByDisciplinaId(id)) {
            throw new IllegalStateException("Não é possível excluir a disciplina porque ela está cadastrada em uma inscrição.");
        }
        disciplinaRepository.deleteById(id);
    }

    public Inscricao getInscricaoById(Long id) {
        return inscricaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Inscrição não encontrada com id: " + id));
    }
}
