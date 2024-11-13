package com.psii.escola.service;

import com.psii.escola.model.Inscricao;
import com.psii.escola.model.Disciplina;
import com.psii.escola.model.Estudante;
import com.psii.escola.repository.InscricaoRepository;
import com.psii.escola.repository.DisciplinaRepository;
import com.psii.escola.repository.EstudanteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    // Obtém todas as inscrições
    public List<Inscricao> getAllInscricoes() {
        return inscricaoRepository.findAll();
    }

    // Cria ou atualiza uma inscrição
    public void saveInscricao(Inscricao inscricao) {
        inscricaoRepository.save(inscricao); // O método save do Spring Data já cuida de criar ou atualizar a inscrição
    }

    // Verifica se o estudante está cadastrado em alguma inscrição
    public boolean isEstudanteCadastrado(Long estudanteId) {
        return inscricaoRepository.existsByEstudanteId(estudanteId);
    }

    // Verifica se a disciplina está cadastrada em alguma inscrição
    public boolean isDisciplinaCadastrada(Long disciplinaId) {
        return inscricaoRepository.existsByDisciplinaId(disciplinaId);
    }

    // Deleta uma inscrição
    public void deleteInscricao(Long id) {
        if (!inscricaoRepository.existsById(id)) {
            throw new EntityNotFoundException("Inscrição não encontrada com id: " + id);
        }
        Inscricao inscricao = inscricaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Inscrição não encontrada com id: " + id));

        // Verificar se a inscrição está associada a um estudante ou disciplina
        if (verificarInscricaoPorEstudante(inscricao.getEstudante().getId())) {
            throw new IllegalStateException("Não é possível excluir a inscrição. Estudante associado.");
        }
        if (verificarInscricaoPorDisciplina(inscricao.getDisciplina().getId())) {
            throw new IllegalStateException("Não é possível excluir a inscrição. Disciplina associada.");
        }

        inscricaoRepository.deleteById(id);
    }

    // Verifica se existe inscrição associada ao estudante
    public boolean verificarInscricaoPorEstudante(Long estudanteId) {
        // Esse método deve chamar o método no repositório para verificar se há
        // inscrição
        return inscricaoRepository.existsByEstudanteId(estudanteId);
    }

    // Verifica se existe inscrição associada à disciplina
    public boolean verificarInscricaoPorDisciplina(Long disciplinaId) {
        // Esse método deve chamar o método no repositório para verificar se há
        // inscrição
        return inscricaoRepository.existsByDisciplinaId(disciplinaId);
    }

    // Exclui um estudante, verificando se está cadastrado em alguma inscrição
    public void excluirEstudante(Long id) {
        if (verificarInscricaoPorEstudante(id)) {
            throw new IllegalStateException(
                    "Não é possível excluir o estudante porque ele está cadastrado em uma inscrição.");
        }
        estudanteRepository.deleteById(id);
    }

    // Exclui uma disciplina, verificando se está cadastrada em alguma inscrição
    public void excluirDisciplina(Long id) {
        if (verificarInscricaoPorDisciplina(id)) {
            throw new IllegalStateException(
                    "Não é possível excluir a disciplina porque ela está cadastrada em uma inscrição.");
        }
        disciplinaRepository.deleteById(id);
    }

    // Obtém uma inscrição pelo ID
    public Inscricao getInscricaoById(Long id) {
        Optional<Inscricao> inscricao = inscricaoRepository.findById(id);
        return inscricao.orElseThrow(() -> new EntityNotFoundException("Inscrição não encontrada com id: " + id));
    }
}
