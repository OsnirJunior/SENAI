package com.psii.escola.service;

import com.psii.escola.model.Inscricao;
import com.psii.escola.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    public List<Inscricao> getAllInscricoes() {
        return inscricaoRepository.findAll();
    }

    public void saveInscricao(Inscricao inscricao) {
        inscricaoRepository.save(inscricao);
    }

    public void deleteInscricao(Long id) {
        inscricaoRepository.deleteById(id);
    }

    // Método para buscar uma inscrição pelo ID
    public Inscricao getInscricaoById(Long id) {
        Optional<Inscricao> inscricaoOptional = inscricaoRepository.findById(id);
        return inscricaoOptional.orElse(null); // Retorna null se a inscrição não for encontrada
    }
}
