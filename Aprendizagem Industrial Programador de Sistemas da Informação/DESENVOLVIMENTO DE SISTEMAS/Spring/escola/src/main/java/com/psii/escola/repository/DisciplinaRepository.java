package com.psii.escola.repository;

import com.psii.escola.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    // JpaRepository já fornece métodos como save(), findById(), existsById(),
    // deleteById() de forma automática.

}
