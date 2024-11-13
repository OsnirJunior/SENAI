package com.psii.escola.service;

import com.psii.escola.model.Estudante;
import com.psii.escola.repository.EstudanteRepository;
import com.psii.escola.repository.InscricaoRepository; // Importando o repositório de Inscrição
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private InscricaoRepository inscricaoRepository; // Injeção do repositório de Inscrição

    public List<Estudante> getAllEstudantes() {
        return estudanteRepository.findAll();
    }

    public Estudante getEstudanteById(Long id) {
        return estudanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estudante não encontrado com id: " + id));
    }

    public void saveEstudante(Estudante estudante) {
        estudanteRepository.save(estudante);
    }

    public void excluirEstudante(Long id) {
        // Verifique se o estudante existe antes de tentar excluir
        if (!estudanteRepository.existsById(id)) {
            throw new IllegalStateException("Estudante com ID " + id + " não encontrado.");
        }
        estudanteRepository.deleteById(id); // Exclui o estudante do banco de dados
    }
}
