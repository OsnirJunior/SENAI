package com.psii.escola.repository;

import com.psii.escola.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    boolean existsByEstudanteId(Long estudanteId);

    boolean existsByDisciplinaId(Long disciplinaId);
}
